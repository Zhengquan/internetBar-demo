package com.wbgl.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.wbgl.service.PublicService;
import com.wbgl.common.Constant;
import com.wbgl.entity.User;

public class LogoutController extends AbstractController {
	
	private PublicService publicService;
	
	public void setPublicService(PublicService publicService) {
		this.publicService = publicService;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Map<String, String> map = new HashMap<String, String>();
		String type = request.getParameter("type");
		map.put("type", type);
		//普通用户和会员的结账注销操作
		if("1".equals(type) || "2".equals(type)){
			User user = (User) session.getAttribute("user");
			map.put("identityId", user.getIdentityId());
			//获取在线时间
			Float onlineTime = (Float)session.getAttribute("onlineTime");
			float cash = (float) ((-1) * onlineTime.floatValue()*Constant.PRICE);
			map.put("cash", String.valueOf(cash));
			//修改金额
			boolean iCash = publicService.updateLogoutCash(map);
			//设置登录状态为0
			boolean iStatus = publicService.updateLogoutStatus(map);
			if(iStatus && iCash) {
				session.removeAttribute("user");   //移除其属性
				return new ModelAndView("login");
			}else{
				return null;
			}
		}
		
		//管理员注销
		if("3".equals(type)){
			session.removeAttribute("user");
			return new ModelAndView("login");
		}
		return null;
	}

}

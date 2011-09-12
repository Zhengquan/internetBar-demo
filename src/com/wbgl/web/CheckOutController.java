package com.wbgl.web;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.wbgl.entity.User;
import com.wbgl.service.PublicService;

public class CheckOutController extends AbstractController {

	private PublicService publicService;
	
	public void setPublicService(PublicService publicService) {
		this.publicService = publicService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String type = request.getParameter("type");
		String identityId = request.getParameter("identityId");
		Map<String, String> map = new HashMap<String, String>();
		map.put("identityId", request.getParameter("identityId"));
		
		HttpSession session = request.getSession();
		User user = (User)publicService.getUserInfo(identityId, type);
		//response
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray(); //json数组类，JSON格式
        //结账前先注销,在线或没有报错
		if(user == null || "1".equals(user.getLogged())) {
			jsonArray.add("false");
			out.println(jsonArray.toString());
			return null;
		}
		//结账余额
		Double remain = user.getRemain();
		//存入session中
		jsonArray.add(String.valueOf(remain.doubleValue()));
		if("1".equals(type)) {
			//删除临时用户
			boolean iDelete = publicService.deleteTempUser(map);
			if(iDelete == true ) {
				out.println(jsonArray.toString());
				return null;
			}
		}else if("2".equals(type)){
			//重置VIP用户余额
			boolean iUpdate = publicService.resetVipCash(map);
			if(iUpdate == true ) {
				out.println(jsonArray.toString());
				return null;
			}
		}
		out.println(false);
		return null;
	}

}

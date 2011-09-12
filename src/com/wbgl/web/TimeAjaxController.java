package com.wbgl.web;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.wbgl.common.Constant;
import com.wbgl.entity.User;
import com.wbgl.service.PublicService;

public class TimeAjaxController extends AbstractController {
	
	private PublicService publicService;
	
	public void setPublicService(PublicService publicService) {
		this.publicService = publicService;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Date loginTime = (Date) session.getAttribute("loginTime");
		int onlineMinute = (int)(new Date().getTime() - loginTime.getTime())/(60*1000)+1;
		int hour = onlineMinute/60;
		int minute = onlineMinute%60;
		StringBuffer sb = new StringBuffer();
		if(hour > 0){
			sb.append(String.valueOf(hour) + "小时"); //append串接字符串
		}
		sb.append(String.valueOf(minute) + "分钟");
		JSONArray jsonArray = new JSONArray();
		//加入在线的时间信息
		jsonArray.add(sb.toString());
		
		Float onlineTime = (Float)session.getAttribute("onlineTime");
		if(onlineTime == null)
			session.setAttribute("onlineTime",new Float(0.50));
		if(minute%(60*Constant.LEVEL) == 0) {
			onlineTime = new Float(onlineTime.floatValue() + Constant.LEVEL);
			session.setAttribute("onlineTime",onlineTime);				
		}
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(jsonArray.toString());
		return null;
	}

}

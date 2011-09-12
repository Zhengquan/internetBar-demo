package com.wbgl.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.wbgl.service.PublicService;

public class OnlineUserController extends AbstractController {
	
	private PublicService publicService;
	
	public void setPublicService(PublicService publicService) {
		this.publicService = publicService;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("onlineTempUser", publicService.getOnlineTempUser());
		session.setAttribute("onlineVipUser",publicService.getOnlineVipUser());
		return new ModelAndView("onlineuser");
	}

}

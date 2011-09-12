package com.wbgl.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.wbgl.service.PublicService;

public class LoginController extends AbstractController {

	private PublicService publicService;
	
	public void setPublicService(PublicService publicService) {
		this.publicService = publicService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String identityId = request.getParameter("identityId");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		boolean isChecked = publicService.userValidate(identityId, password, type);
		if(isChecked){
			HttpSession session = request.getSession();
			session.setAttribute("identityId", identityId);
			if("3".equals(type)){
				session.setAttribute("user", publicService.getAdminInfo(identityId));
				return new ModelAndView("admin");
			}else{
				if(session.getAttribute("user") == null){
					session.setAttribute("loginTime", new Date());
					publicService.updateUserLoginTime(identityId, type);
					session.setAttribute("user", publicService.getUserInfo(identityId, type));
				}
				return new ModelAndView("user");
			}
		}
		return new ModelAndView("login");
	}

}

package com.wbgl.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.wbgl.service.PublicService;

public class AddUserController extends AbstractController {

	private PublicService publicService;
	
	public void setPublicService(PublicService publicService) {
		this.publicService = publicService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("identityId", request.getParameter("identityId"));
		map.put("pwd", request.getParameter("pwd"));
		map.put("cash", request.getParameter("cash"));
		map.put("type", request.getParameter("type"));
		map.put("vipCard", request.getParameter("vipCard"));
		boolean success = publicService.insertUser(map);
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(success);
		return null;
	}

}

package com.wbgl.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.wbgl.service.PublicService;

public class PwdUpdateController extends AbstractController {
	
	private PublicService publicService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("identityId", request.getParameter("identityId"));
		map.put("oldPwd", request.getParameter("oldPwd"));
		map.put("newPwd", request.getParameter("newPwd"));
		boolean success = publicService.updatePwd(map);
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(success);
		return null;
	}

	public void setPublicService(PublicService publicService) {
		this.publicService = publicService;
	}

}

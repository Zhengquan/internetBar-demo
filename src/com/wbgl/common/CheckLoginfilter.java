package com.wbgl.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginfilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 拦截所有请求
	 * 对未登录的访问操作，跳转到登陆页面
	 * 已登录的操作则放行
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		String identityId = String.valueOf(session.getAttribute("identityId"));
		String uri = ((HttpServletRequest)request).getRequestURI();    //xxoo/jsp/login.jsp
		String prefix = uri.substring(0,uri.lastIndexOf("/")+1);      //xxoo/jsp/
		String methodName = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf(".")); //login

		if(("null".equals(identityId) || "".equals(identityId)) && !"login".equals(methodName)){
			//session.setAttribute("reason", Constant.NWDL);
			((HttpServletResponse)response).sendRedirect(prefix + "login.jsp");
		}else{
			chain.doFilter(request, response);                                  //过滤掉非法如？
		}
		     
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

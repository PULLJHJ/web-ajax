package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.web.common.CommonView;
import com.web.service.UserInfoService;
import com.web.service.impl.UserInfoServiceImpl;



@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet { // HttpServlet를 상속받아서 UserInfoServlet로 불릴 수 있음.
	private static final long serialVersionUID = 1L; 
    private Gson gson = new Gson();
    private UserInfoService uiService = new UserInfoServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		response.setContentType("application/json;charset=UTF-8");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

package com.page.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.page.pojo.Customer;
import com.page.service.FilmService;

@Controller
public class LoginController {
	@Resource
	private FilmService filmService;

	@RequestMapping("/login.action")
	public void userLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		Customer customer = null;
		PrintWriter printWriter = null;
		try {
			customer = filmService.selectFist_Name(username);
			printWriter = response.getWriter();
			printWriter.print(customer);
			printWriter.flush();
			printWriter.close();
		} catch (Exception ex) {
			customer = null;
		}
	}

}

package com.project.maven.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {

	@RequestMapping("calculator")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));
		String operation = request.getParameter("operations");
		int c = 0;

		switch (operation) {

			case "+":
				c = a + b;
				break;

			case "-":
				c = a - b;
				break;

			case "/":
				c = a / b;
				break;

			case "*":
				c = a * b;
				break;

			case "%":
				c = a % b;
				break;
	
			default:
				break;
		}

		mv.setViewName("resultpage");
		mv.addObject("result", c);
		return mv;
	}

}

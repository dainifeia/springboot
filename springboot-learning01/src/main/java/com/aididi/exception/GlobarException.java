package com.aididi.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobarException {

	private static final String DEFAULT_ERROR = "error";
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public ModelAndView error(HttpServletRequest request,HttpServletResponse response,Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.addObject("url",request.getRequestURL());
		mav.setViewName(DEFAULT_ERROR);
		return mav;
	}
}

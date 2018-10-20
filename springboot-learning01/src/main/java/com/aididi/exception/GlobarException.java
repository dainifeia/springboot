package com.aididi.exception;

import javax.servlet.http.HttpServletRequest;

import com.aididi.Utils.ResultError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
/**
 * 功能描述: 
 * @param: 全局异常捕获
 * @return: 
 * @auther: xuzexiang
 * @date: 2018/6/19 0019 上午 11:14
 */
@ControllerAdvice
public class GlobarException {

	private static final String DEFAULT_ERROR = "error";

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR);
		return mav;
	}

	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public ResultError<String> error(HttpServletRequest request,MyException e) throws  Exception{
	/*	ModelAndView mav = new ModelAndView();*/
		ResultError<String> resultError = new ResultError<>();
		resultError.setMessage(e.getMessage());
		resultError.setCode(ResultError.ERROR);
		resultError.setData("Some Data");
		resultError.setUrl(request.getRequestURL().toString());
		return resultError;
	}
}

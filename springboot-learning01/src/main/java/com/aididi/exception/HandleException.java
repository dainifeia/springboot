package com.aididi.exception;

import com.aididi.Utils.ResultEnum;

public class HandleException extends RuntimeException{
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	   
	public HandleException(ResultEnum resultEnum,String msg) {
		super(resultEnum.getMsg()+msg);
		this.code=resultEnum.getCode();
	}
	
}

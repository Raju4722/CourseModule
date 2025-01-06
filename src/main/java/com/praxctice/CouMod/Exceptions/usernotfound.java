package com.praxctice.CouMod.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class usernotfound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4494515727389560881L;

	public usernotfound(String msg) {
		super(msg);
	}
  
}

/**
 * 
 */
package com.dns.crossover.ass.utill;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author dinusha
 *
 */
public class ErrorInfo extends ModelAndView {
	
	private String message;

	public ErrorInfo(String message) {
		this.message = message;
	}

}

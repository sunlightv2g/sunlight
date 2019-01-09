package com.sunlight.webservice.helpers;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.jknack.handlebars.Options;

import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@HandlebarsHelper
public class UtilHelper {

	public String formatNumber(long val) {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(val);
	}
	
	public CharSequence eq(String firstStr, String secondStr, Options options) throws IOException {
		if(firstStr != null && firstStr.equals(secondStr)) {
			return options.fn(this);
		}else {
			return options.inverse(this);	
		}
	}
	
	public CharSequence eqLong(long firstStr, long secondStr, Options options) throws IOException {
		if(firstStr == secondStr) {
			return options.fn(this);
		}else {
			return options.inverse(this);	
		}
	}
	
	public CharSequence session(Options options) throws IOException {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession httpSession = request.getSession(true);
		String userid = (String) httpSession.getAttribute("USEID");
		
		//System.out.println("session : " + userid);
		
		if(userid != null && !userid.equals("")) {
			return options.fn(this);
		}else {
			return options.inverse(this);
				
		}
	}
	
}

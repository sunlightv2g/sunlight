package com.sunlight.webservice.helpers;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

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
		
	public String electric(String dbl1, double dbl2, double dbl3 ) {
		double db = Double.valueOf(dbl1);
		double rst = Math.round((db * dbl2 * dbl3));
		return String.valueOf(rst);
	}
	
	public String round(double val1, String val2) {
		double db = Double.valueOf(val1);
		double pos = Integer.parseInt(val2);
		double result = 0.0;
        double half = 0.5;
        double factor = 1;
       
        for (int i = 0; i< pos; i++){
            half *= 0.1;
            factor *= 10;
        }
        result = (int)((db+half)*factor)/(double)factor;

		return String.valueOf(result);
	}
	
	public String replace(String val, String chr1, String chr2) {
		return val.replace(chr1, chr2);
	}
	
	public CharSequence dateEquals(String var1, String var2, Options options) throws IOException {
		if(var1.substring(0,10).equals(var2.substring(0,10))){
			return options.fn(this);
		}else {
			return options.inverse(this);	
		}
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

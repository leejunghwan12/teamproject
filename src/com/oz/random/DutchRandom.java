package com.oz.random;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class DutchRandom {

	public static void pickOne(HttpServletRequest request) {
		
		
		 

		String [] who =  request.getParameterValues("who");
		
		Random r = new Random();
		   //�� �ڵ尡 ������ �� ���� �غ� 
		   int ran = r.nextInt(who.length)+1;
		try {
	
		   if (ran==1) {
			request.setAttribute("who", who[0]);
		   }else if (ran == 2) {
			request.setAttribute("who", who[1]);
		   }else if (ran ==3) {
			request.setAttribute("who", who[2]);   	
		   }else if (ran == 4){
			 request.setAttribute("who", who[3]);
		 
		   }
			} catch (Exception e) {
			}
	
	}

}

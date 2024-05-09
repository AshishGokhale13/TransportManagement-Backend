package com.roadline.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response  {
	
	int statusCode;
	Object Data;
	int errorCode;
	String message;
	
	
	public static Response success(Object obj,String message)
	{
		return new Response(200,obj,0,message);
	}
	public static Response success(Object obj)
	{
		return new Response(200,obj,0,"success");
	}
	
	public static Response error(int statusCode,Object obj,int errorCode,String message)
	{
		return new Response(statusCode,obj,errorCode,message);
	}
}

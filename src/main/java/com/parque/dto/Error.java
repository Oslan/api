package com.parque.dto;

import java.io.Serializable;

public class Error implements Serializable {  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	private String msg;
	private Object obj;
	
	public Integer getCod() {
		return cod;
	}
	
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	
}

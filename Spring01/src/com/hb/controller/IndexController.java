package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestVo;

public class IndexController implements Controller {
//	private GuestVo bean;
	
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
	
//	public IndexController(String msg){
//		this.msg=msg;
//	}

//	public void setBean(GuestVo bean) {
//		this.bean = bean;
//	}
//	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav=new ModelAndView();
		req.setAttribute("msg","Spring");
		mav.setViewName("index");
		return mav;
	}

}

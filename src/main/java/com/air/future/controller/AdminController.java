package com.air.future.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.air.future.service.AdminService;
import com.air.future.vo.Admin;

import lombok.extern.java.Log;

@SessionAttributes("admin")
@Controller
public class AdminController {
	
	@Autowired
	AdminService service;
	
	// 관리자 메인페이지 이동
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("todayInfo", service.todayInfo());
		model.addAttribute("popularFlight", service.popularFlight());
		model.addAttribute("rateContinents", service.rateContinents());
		model.addAttribute("recentReservation", service.recentReservation());
		return "admin/admin";
	}

	// 관리자 로그인 페이지 이동
	@RequestMapping(value = "adminLogin", method = RequestMethod.GET)
	public String adminLogin() {
		return "admin/login";
	}
	
	// 관리자 로그인 처리
	@RequestMapping(value = "adminLogin", method = RequestMethod.POST)
	public String adminLoginForm(Admin loginAdmin, Model model) {
		
		Admin admin = service.selectAdmin(loginAdmin.getAdmin_id());
		
		if (admin == null) {
			model.addAttribute("errorMsg", "존재하지 않는 아이디 입니다.");
			return "admin/login";
		}
		
		if (!admin.getAdmin_pw().equals(loginAdmin.getAdmin_pw())) {
			model.addAttribute("errorMsg", "비밀번호가 잘못되었습니다.");
			return "admin/login";
		}
		
		model.addAttribute("admin", admin);
		return "redirect:/admin";
	}
	
}

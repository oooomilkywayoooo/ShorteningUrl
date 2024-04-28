package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 管理者ログインコントローラー
 * 
 * @author login
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {

	@GetMapping
	public String view() {
		return "/login";
	}
	
}

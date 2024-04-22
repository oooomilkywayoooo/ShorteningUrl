package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * アクセスコントローラー
 * 
 * @author access
 *
 */
@Controller
@RequestMapping("/access")
public class AccessController {

	@GetMapping
	public String view() {
		return "/access";
	}
	
}

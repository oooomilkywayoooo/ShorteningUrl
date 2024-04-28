package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * メニューコントローラー
 * 
 * @author menu
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

	@GetMapping
	public String view() {
		return "/menu";
	}
	
}

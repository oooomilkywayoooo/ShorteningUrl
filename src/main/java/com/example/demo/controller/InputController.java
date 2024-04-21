package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.InputForm;
import com.example.demo.service.UrlInfoService;

import lombok.RequiredArgsConstructor;
/**
 * インプットコントローラー
 * 
 * @author input
 *
 */
@Controller
@RequiredArgsConstructor
public class InputController {
	
	private final UrlInfoService service;

	@GetMapping("/input")
	public String view(Model model, InputForm form) {
		return "input";
	}
	
	@PostMapping("/input")
	public String input(InputForm form) {
		
		 System.out.println(form.toString());
		 return "output";
	}
}

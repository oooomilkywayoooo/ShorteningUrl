package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * アウトプットコントローラー
 * 
 * @author output
 *
 */
@Controller
@RequestMapping("/output")
public class OutputController {

	@GetMapping
	public String view() {
		return "/output";
	}
	
}

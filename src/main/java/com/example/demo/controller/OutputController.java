package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.form.InputForm;

import lombok.RequiredArgsConstructor;
/**
 * アウトプットコントローラー
 * 
 * @author output
 *
 */
@Controller
@RequiredArgsConstructor
public class OutputController {

	@GetMapping("/output")
	public String view(Model model, InputForm form) {
		return "/output";
	}
	
}

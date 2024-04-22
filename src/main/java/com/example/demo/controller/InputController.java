package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UrlInfo;
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
	
	Map<String, String> inputMap = new HashMap<>(); // フォームから受け取ったURLとページ名

	@GetMapping("/input")
	public String view(Model model, InputForm form) {
		return "input";
	}
	
	@PostMapping("/input")
	public String input(InputForm form) {
		
		ArrayList<String> checkList = new ArrayList<>();		//要確認リスト
		UrlInfo urlInfo = new UrlInfo();
		
		form.setMap(inputMap);
		
		for (String key : inputMap.keySet()) {
			
			// System.out.println(key);
			
			if(!(key.startsWith("http://")) || !(key.startsWith("https://"))) {
				
				checkList.add(key);		
				inputMap.remove(key);
			}
			
		}
		
		for (String key : inputMap.keySet()) {
			
			
		}
		 return "output";
	}
	
}
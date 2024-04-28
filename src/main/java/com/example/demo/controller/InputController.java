package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.common.AppCommon;
import com.example.demo.constant.MessageConst;
import com.example.demo.entity.UrlInfo;
import com.example.demo.form.InputForm;
import com.example.demo.service.InputService;

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
	
	/** 短縮URL作成画面 Service */
	private final InputService service;
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	Map<String, String> outputMap = new HashMap<>(); // フォームから受け取ったURLとページ名
	ArrayList<String> checkList = new ArrayList<>(); // 要確認に表示するURL
	
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 変換前URL ページ名
	 * @return 変換後URL表示画面
	 */
	
	@GetMapping("/input")
	public String view(Model model, InputForm form) {
		return "input";
	}
	
	/**
	 * 短縮URL作成
	 * 
	 * @param model モデル
	 * @param form 変換前URL ページ名
	 * @return 変換後URL表示画面
	 */
	
	@PostMapping("/input")
	public String input(Model model, InputForm form) {
		
		outputMap.clear();
		checkList.clear();
		
		outputMap =  service.registUrl(form, checkList);
		ArrayList<UrlInfo> outputList = new ArrayList<UrlInfo>();
		String domain = "http://localhost:8080/";
		String screen = "";
		
		if(outputMap.isEmpty() && CollectionUtils.isEmpty(checkList)) {
			String errorMsg = AppCommon.getMessage(messageSource, MessageConst.INPUT_NULL);
			model.addAttribute("errorMsg",errorMsg);
			screen = "input";
		}else {
			
			for (Map.Entry<String, String> entry : outputMap.entrySet()) {
				
				var exist =  service.searchShorteningUrlById(entry.getKey());
				
				if(!(exist.isEmpty())) {
					outputList.add(exist.get());
				}
			}
			
			model.addAttribute("domain", domain);
			model.addAttribute("outputList", outputList);
			model.addAttribute("checkList", checkList);
			
			screen = "output";
		}
		
		return screen; 
	}
	
	
	
}
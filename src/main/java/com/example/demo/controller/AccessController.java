package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.UrlInfo;
import com.example.demo.service.AccessService;

import lombok.RequiredArgsConstructor;

/**
 * アクセスコントローラー
 * 
 * @author access
 *
 */
@Controller
@RequiredArgsConstructor
public class AccessController {
	private final AccessService service;

	/**
	 * 初期表示
	 * @param model
	 * @return アクセス確認画面
	 */

	@GetMapping("/access")
	public String showRegistrationDates(@RequestParam(name = "yearMonth", required = false) String yearMonth,
			Model model) {
		// 選択された値を処理
				if (yearMonth != null) {
					List<UrlInfo> entities = service.getEntitiesByYearMonth(yearMonth);
					model.addAttribute("entities", entities);
				}
		
		List<String> yearMonths = service.getAllYearMonths();
		model.addAttribute("yearMonths", yearMonths);

		return "/access";
	}
}

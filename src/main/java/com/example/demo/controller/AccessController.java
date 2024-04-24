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

	@GetMapping("/access")
	public String showRegistrationDates(Model model,
			@RequestParam(name = "yearMonth", required = false) String yearMonth) {
		
		if (yearMonth == null) {
	        // 初回遷移時に特定の年月を取得する
	        yearMonth = "2024-04";
	    }

		if (yearMonth != null) {
			List<UrlInfo> entities = service.getEntitiesByYearMonth(yearMonth);
			model.addAttribute("entities", entities);
		}

		List<String> yearMonths = service.getAllYearMonths();
		model.addAttribute("yearMonths", yearMonths);

		//		// データベースから登録日を取得
		//		List<Timestamp> registrationTimestamps = repository.findAll()
		//				.stream()
		//				.map(UrlInfo::getCreatedAt)
		//				.collect(Collectors.toList());
		//		
		//		// 年月を取得
		//		List<String> yearMonths = registrationTimestamps.stream()
		//				.map(timestamp -> new SimpleDateFormat("yyyy-MM").format(timestamp))
		//				.distinct()
		//				.collect(Collectors.toList());
		//
		//		model.addAttribute("yearMonths", yearMonths);

		return "/access";
	}

}

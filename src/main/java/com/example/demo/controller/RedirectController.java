package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.UrlInfo;
import com.example.demo.repository.UrlInfoRepository;
import com.example.demo.service.UrlInfoService;

import lombok.RequiredArgsConstructor;

/**
 * リダイレクトコントローラー
 * 
 * @author redirect
 *
 */
@Controller
@RequiredArgsConstructor
public class RedirectController {

	private final UrlInfoService service;
	private final UrlInfoRepository repository;

	@GetMapping("/{requestPath}")
	public RedirectView redirectPage(@PathVariable String requestPath) {
		// リクエストパスと一致するページ情報をデータベースから取得
		var urlInfo = service.searchShorteningUrlById(requestPath);

		if (!(urlInfo.isEmpty())) {
			// urlInfoを代入
			UrlInfo ui = urlInfo.get();
			// アクセス数をカウント
			int count = ui.getAccessCount();
			count++;
			ui.setAccessCount(count);
			repository.save(ui);
			// ページをリダイレクト
			return new RedirectView(ui.getUrl());
			
		} else {
			// エラーページなどを返す
			return new RedirectView();
		}
	}

}

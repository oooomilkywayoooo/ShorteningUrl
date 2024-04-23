package com.example.demo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UrlInfo;
import com.example.demo.form.InputForm;
import com.example.demo.repository.UrlInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InputService {

	private final UrlInfoRepository repository;

	public Optional<UrlInfo> searchUrlById(String url) {
		return repository.findById(url);
	}

	public Map<String, String> registUrl(InputForm form, ArrayList<String> checkList) {
		
		// 現在時刻取得
		Timestamp tm = new Timestamp(System.currentTimeMillis());
		
		Map<String, String> inputMap = new HashMap<>(); // フォームから受け取ったURLとページ名
		Map<String, String> outputMap = new HashMap<>(); // 登録済みのランダム文字列とページ名
		String shorteningUrl = "";		// 生成したランダム文字列
		

		form.setMap(inputMap);

		for (String key : inputMap.keySet()) {

			// System.out.println(key);

			if (!(key.startsWith("http://")) || !(key.startsWith("https://"))) {

				checkList.add(key);
				inputMap.remove(key);
			}

		}

		for (Map.Entry<String, String> entry : inputMap.entrySet()) {
			UrlInfo urlInfo = null;
			var exist = repository.findById(entry.getKey());
			
			
			if(exist == null) {
				urlInfo = new UrlInfo();
				shorteningUrl = randomText();		// ランダム文字列生成
				
				urlInfo.setShorteningUrl(shorteningUrl);
				urlInfo.setUrl(entry.getKey());
				urlInfo.setPageName(entry.getValue());
				urlInfo.setAccessCount(0);
				urlInfo.setCreatedAt(tm);
				urlInfo.setCreatedUserId(0);
				urlInfo.setUpdatedAt(tm);
				urlInfo.setUpdatedUserId(0);
				
				repository.save(urlInfo);
				
			}else {
				urlInfo = exist.get();
				shorteningUrl = urlInfo.getShorteningUrl();
				urlInfo.setPageName(entry.getValue());
				urlInfo.setUpdatedAt(tm);
				urlInfo.setUpdatedUserId(0);
				
				repository.save(urlInfo);
			}
			
			outputMap.put(shorteningUrl, entry.getValue());
			
		}
		
		return outputMap;
	}

	public static String randomText() {
		int length = 10;
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();

		StringBuilder stringBuilder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			stringBuilder.append(characters.charAt(index));
		}

		String randomString = stringBuilder.toString();

		return randomString;
	}

}

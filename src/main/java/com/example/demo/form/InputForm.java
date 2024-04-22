package com.example.demo.form;

import java.util.Map;

import lombok.Data;

@Data
public class InputForm {

	private String url1;
	private String url2;
	private String url3;
	private String url4;
	private String url5;

	private String page1;
	private String page2;
	private String page3;
	private String page4;
	private String page5;

	public Map<String, String> setMap(Map<String, String> inputMap) {
		
		if (this.url1 != null) {
			inputMap.put(this.url1, this.page1);
		}
		if (this.url2 != null) {
			inputMap.put(this.url2, this.page2);
		}
		if (this.url3 != null) {
			inputMap.put(this.url3, this.page3);
		}
		if (this.url4 != null) {
			inputMap.put(this.url4, this.page4);
		}
		if (this.url5 != null) {
			inputMap.put(this.url5, this.page5);
		}
		return inputMap;
	}
}

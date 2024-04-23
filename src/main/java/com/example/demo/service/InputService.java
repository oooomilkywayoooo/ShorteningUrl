package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UrlInfo;
import com.example.demo.repository.UrlInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InputService {
	
	private final UrlInfoRepository repository;
	
	public Optional<UrlInfo> searchUrlById(String url){
		return repository.findById(url);
	}
	
	/*public Optional<UrlInfo> registUrl(InputForm form){
		
	}*/
	
}

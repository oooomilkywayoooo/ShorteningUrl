package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.UrlInfo;

public interface UrlInfoRepository extends JpaRepository<UrlInfo,String> {
	
	@Query(value = "SELECT * FROM url_info " +
			"WHERE url = :url ", nativeQuery = true)
		UrlInfo findByUrl(@Param("url") String url);
}

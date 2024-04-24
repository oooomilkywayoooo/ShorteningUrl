package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.UrlInfo;

public interface UrlInfoRepository extends JpaRepository<UrlInfo, String> {

	@Query(value = "SELECT * FROM url_info " +
			"WHERE url = :url ", nativeQuery = true)
	UrlInfo findByUrl(@Param("url") String url);

	@Query(value = "SELECT * FROM url_info " +
			"WHERE created_at = :created_at ", nativeQuery = true)
	List<UrlInfo> findByCreatedAt(@Param("created_at") String url);

	@Query(value = "SELECT * FROM url_info " +
	        "WHERE created_at BETWEEN :startOfMonth AND :endOfMonth", nativeQuery = true)
	List<UrlInfo> findByCreatedAtBetween(Timestamp startOfMonth, Timestamp endOfMonth);


}

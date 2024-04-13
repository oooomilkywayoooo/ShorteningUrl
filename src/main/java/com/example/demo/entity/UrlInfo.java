package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="url_info")
@Data
public class UrlInfo {
	
	@Id
	@Column(name="shortening_url")
	private String shorteningUrl;
	
	private String url;
	
	@Column(name="page_name")
	private String pageName;
	
	@Column(name="access_count")
	private int accessCount;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="created_user_id")
	private int createdUserId;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Column(name="updated_user_id")
	private int updatedUserId;
}

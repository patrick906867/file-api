package com.example.rest.webservice.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FileVO {
	
	private Long id;
	private String name;
	private String uploadBy;
	private Date uploadTime;
	
	
	public Date getUploadTime() {
		return uploadTime;
	}



	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}



	public FileVO(){
		
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUploadBy() {
		return uploadBy;
	}



	public void setUploadBy(String uploadBy) {
		this.uploadBy = uploadBy;
	}





	public FileVO(Long id, String name, String uploadBy, Date uploadTime) {
		super();
		this.id = id;
		this.name = name;
		this.uploadBy = uploadBy;
		this.uploadTime = uploadTime;
	}



	@Override
	public String toString() {
		return "File [id=" + id + ", name=" + name + ", uploadBy=" + uploadBy + "]";
	}
	
	
	

}

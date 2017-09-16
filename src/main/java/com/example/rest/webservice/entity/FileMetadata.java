package com.example.rest.webservice.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="file")
public class FileMetadata {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String uploadBy;

    @Column(nullable = false)
    private String fileName;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

	public String getUploadBy() {
		return uploadBy;
	}

	public void setUploadBy(String uploadBy) {
		this.uploadBy = uploadBy;
	}



}

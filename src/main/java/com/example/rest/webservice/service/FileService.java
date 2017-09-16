package com.example.rest.webservice.service;


import org.springframework.web.multipart.MultipartFile;

import com.example.rest.webservice.entity.FileVO;

import java.util.List;

public interface FileService {
    FileVO saveFile(MultipartFile file, FileVO metaData);

    List<FileVO> searchFileBy(String keyword);
}

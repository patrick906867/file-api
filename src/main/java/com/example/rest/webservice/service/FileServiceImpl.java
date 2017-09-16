package com.example.rest.webservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.rest.webservice.dao.FileRepo;
import com.example.rest.webservice.entity.FileMetadata;
import com.example.rest.webservice.entity.FileVO;

@Service
public class FileServiceImpl implements FileService {

	private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

	@Autowired
	private FileRepo fileRepo;

	@Override
	@Transactional
	public FileVO saveFile(MultipartFile file, FileVO metaData) {
		FileMetadata fileData = new FileMetadata();

		fileData.setUploadTime(metaData.getUploadTime());
		fileData.setUploadBy(metaData.getUploadBy());
		fileData.setFileName(file.getName());
		FileMetadata savedFileData = fileRepo.save(fileData);
		metaData.setId(savedFileData.getId());
		metaData.setName(file.getName());

		return metaData;
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVO> searchFileBy(String keyword) {
		List<FileMetadata> entityList = fileRepo.findByFileNameOrUserId(keyword);
		List<FileVO> resList = new ArrayList<>();
		for (FileMetadata data : entityList) {
			resList.add(new FileVO(data.getId(), data.getUploadBy(), data.getFileName(), data.getUploadTime()));
		}
		return resList;
	}




}

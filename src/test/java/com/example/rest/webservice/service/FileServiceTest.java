package com.example.rest.webservice.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.rest.webservice.FileApiApplication;
import com.example.rest.webservice.entity.FileVO;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FileApiApplication.class)
public class FileServiceTest {

	@Autowired
	FileService fileService;

	@Autowired
	FileVO fileVO;

	@Test
	public void testSave() {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt", "Hello World".getBytes());
		
		fileVO.setUploadBy("patrick");
		fileVO.setUploadTime(new Date());

		fileService.saveFile(mockMultipartFile, fileVO);
		Long resultId = fileVO.getId();
		
		assertTrue(resultId==1);

	}
	
	public void test(){
		MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt", "Hello World".getBytes());
		fileVO.setUploadBy("patrick");
		fileVO.setUploadTime(new Date());

		fileService.saveFile(mockMultipartFile, fileVO);
		List<FileVO> files =fileService.searchFileBy("patrick");
		assertNotNull(files);
		
		
	}

}

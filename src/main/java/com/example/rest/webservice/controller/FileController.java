package com.example.rest.webservice.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.rest.webservice.entity.FileVO;
import com.example.rest.webservice.exception.FileNotExistException;
import com.example.rest.webservice.service.FileServiceImpl;


@RestController
public class FileController {
	@Autowired
	FileServiceImpl fileService;
	
    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

    @PostMapping(value = "/files")
    public ResponseEntity<Object> uploadFile(@RequestParam MultipartFile file, @RequestParam String uploadBy){
        FileVO metaData = new FileVO();
        metaData.setUploadTime(new Date());
        metaData.setUploadBy(uploadBy);;
        LOG.info(metaData.toString());

		FileVO fileVO= fileService.saveFile(file, metaData);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uploadBy}").buildAndExpand(fileVO.getUploadBy())
				.toUri();
		return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/files/{keyword}")
    public List<FileVO> findMeta(@PathVariable String keyword){
        LOG.info("Searching by keyword: " + keyword);
        List<FileVO> files= fileService.searchFileBy(keyword);
        if(files.isEmpty()){
        	throw new FileNotExistException("Not such file is upload");
        }
        return files;
    }
    


}

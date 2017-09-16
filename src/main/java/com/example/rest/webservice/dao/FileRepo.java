package com.example.rest.webservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.webservice.entity.FileMetadata;

import java.util.List;

@Repository
public interface FileRepo extends JpaRepository<FileMetadata,Long>{

    @Query("select d from FileMetadata d where d.fileName like %:keyword% or d.uploadBy like %:keyword%")
    List<FileMetadata> findByFileNameOrUserId(@Param("keyword") String keyword);
    
    
    List<FileMetadata> findByFileNameIgnoreCaseContaining(String keyword);
}

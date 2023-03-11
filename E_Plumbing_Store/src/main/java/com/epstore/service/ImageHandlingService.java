package com.epstore.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.epstore.DTO.ApiResponse;

public interface ImageHandlingService {

	ApiResponse uploadImage(Long Id, MultipartFile imageFile) throws IOException;
	byte[] serveImage(Long empId) throws IOException;

}

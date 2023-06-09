package com.example.ZyaPaarTest.conroller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ZyaPaarTest.service.ImageService;

@RestController
public class ImageController {
	
	
    @Autowired
    ImageService ImageService;
	
	@ResponseStatus(value = HttpStatus.OK)
	
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("upload")MultipartFile file) throws IOException{
		ImageService.uploadImage(file);
		System.out.println("uploaded");
	}
	
	@GetMapping("/downloadById/{fileName}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable int fileName) {
		byte[] image = ImageService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
	}
	
	@GetMapping("/downloadByName/{fileName}")
	public ResponseEntity<byte[]> downloadImageByName(@PathVariable String fileName) {
		byte[] image = ImageService.downloadImageByName(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
		
	}
	
    
}

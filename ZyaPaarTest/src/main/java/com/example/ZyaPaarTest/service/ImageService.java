package com.example.ZyaPaarTest.service;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ZyaPaarTest.entities.ImageEntity;
import com.example.ZyaPaarTest.repository.ImageRepository;
@Component
@Service
public class ImageService {

	
	@Autowired
    private ImageRepository imagerepository;
	
	public ImageEntity uploadImage(MultipartFile file) throws IOException {
		ImageEntity pImage = new ImageEntity();
		pImage.setName(file.getOriginalFilename());
	//	pImage.setType(file.getContentType());
		pImage.setImage(ImageUtil.compressImage(file.getBytes()));
		return imagerepository.save(pImage);
	}
	
	public byte[] downloadImage(int fileName){
        Optional<ImageEntity> imageData = imagerepository.findById(fileName);
        return ImageUtil.decompressImage(imageData.get().getImage());
    }
	
	public byte[] downloadImageByName(String fileName){
        Optional<ImageEntity> imageData = imagerepository.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImage());
    }
}

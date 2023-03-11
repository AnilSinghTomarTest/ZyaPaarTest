package com.example.ZyaPaarTest.entities;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Component
@Entity
@Table(name = "imageupload")
public class ImageEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	
	// @Column(name = "image", unique = false, nullable = false, length = 100000)
	 @Lob
		private byte[] image;

	 private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageEntity(int id, byte[] image, String name) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
	}

	public ImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ImageEntity [id=" + id + ", image=" + Arrays.toString(image) + ", name=" + name + "]";
	}
	 
	 
	  

	
	  

	  
}

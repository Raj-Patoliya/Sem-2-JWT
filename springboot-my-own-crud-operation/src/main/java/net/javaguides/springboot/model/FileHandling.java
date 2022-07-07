package net.javaguides.springboot.model;

import org.springframework.web.multipart.MultipartFile;

public class FileHandling {
	private String name;
	private MultipartFile fileName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFileName() {
		return fileName;
	}
	public void setFileName(MultipartFile fileName) {
		this.fileName = fileName;
	}
	
	
}

package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.FileUpload;
import net.javaguides.springboot.repository.FileUploadRepository;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Autowired
	private FileUploadRepository fileUploadRepository;
	@Override
	public void saveData(FileUpload fileUpload) {
		this.fileUploadRepository.save(fileUpload);
	}

}

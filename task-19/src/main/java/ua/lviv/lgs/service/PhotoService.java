package ua.lviv.lgs.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.Photo;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.repository.PhotoRepository;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photoRepository;

	public Photo storeFile(MultipartFile photo, Student student) throws IOException {
		String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
		Photo file = null;
		String contentType = photo.getContentType();
		byte[] bytes = photo.getBytes();
		if (!fileName.contains("..")) {
			file = new Photo(fileName, contentType, bytes);
		}
		file.setStudent(student);
		return photoRepository.save(file);
	}

	public Photo getFile(String photoId) throws FileNotFoundException {
		return photoRepository.findById(photoId)
				.orElseThrow(() -> new FileNotFoundException("File not found with Id =" + photoId));
	}
}

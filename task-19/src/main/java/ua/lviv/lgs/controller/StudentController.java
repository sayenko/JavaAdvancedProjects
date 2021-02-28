package ua.lviv.lgs.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ua.lviv.lgs.domain.Photo;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.dto.StudentResponse;
import ua.lviv.lgs.service.PhotoService;
import ua.lviv.lgs.service.StudentService;

@Controller
public class StudentController {
		
	@Autowired
	PhotoService photoService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("mode", "STUDENT_REGISTRATION");
		return "index";
	}
	
	@PostMapping("/student")
	public String save(@RequestParam("photo") MultipartFile photo, @RequestParam("firstName") String firstName,
			  @RequestParam("lastName") String lastName, @RequestParam("age") Integer age, HttpServletRequest req) throws IOException {
		
		Student student = new Student(firstName, lastName, age);
		
		Photo storePhoto = photoService.storeFile(photo, student);
		
		student.setPhoto(storePhoto);
		studentService.saveStudent(student);
		
		String photoUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/view/")
				.path(storePhoto.getId()).toUriString();
		
		StudentResponse response = new StudentResponse(firstName, lastName, age, storePhoto.getFileName(), photoUri);
		
		req.setAttribute("mode", "STUDENT_VIEW");
		req.setAttribute("response", response);
		return "index";
	}
	
	@GetMapping("/view/{fileId}")
	public ResponseEntity<Resource> downlaodFile(@PathVariable String fileId) throws FileNotFoundException {
		Photo photo = photoService.getFile(fileId);

		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photo.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getFileName() + "\"")
                .body(new ByteArrayResource(photo.getData()));
	}
}

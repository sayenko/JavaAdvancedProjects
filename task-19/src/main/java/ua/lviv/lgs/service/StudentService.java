package ua.lviv.lgs.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent (Student student) {
		return studentRepository.save(student);
	}
	
	public Student findById(Long studentId) throws FileNotFoundException {
		return studentRepository.findById(studentId).orElseThrow(() -> new FileNotFoundException("Student not found with Id =" + studentId));
	}
	
}

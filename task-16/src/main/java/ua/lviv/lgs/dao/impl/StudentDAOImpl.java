package ua.lviv.lgs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.Student;
import ua.lviv.lgs.dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO<Student>{

	private List<Student> students;
	
	public StudentDAOImpl() {
		if (this.students == null) {
			students = new ArrayList<>();
		}
	}
	
	@Override
	public Student create(Student student) {
		students.add(student);
		return student;
	}

	@Override
	public Student read(Integer id) {
		return students.stream().filter(student -> student.getId().equals(id)).findFirst().get();
	}

	@Override
	public Student update(Student student) {
		students.stream().filter(st -> st.getId().equals(student.getId())).forEach(st -> students.set(students.indexOf(st), student));
		return student;
	}

	@Override
	public void delete(Integer id) {		
		students.remove(students.stream().filter(student -> student.getId().equals(id)).findFirst().get());
	}

	@Override
	public List<Student> readAll() {
		return students;
	}
	
}

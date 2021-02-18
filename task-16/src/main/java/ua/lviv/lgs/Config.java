package ua.lviv.lgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.lviv.lgs.dao.impl.StudentDAOImpl;

@Configuration
public class Config {
	
	@Bean(name = "studentDAO")
	public StudentDAOImpl studentDAO() {
		return new StudentDAOImpl();
	}
	
	@Bean(name = "first_student")
	public Student getFirstStudent() {
		Student student = new Student("First", 18);
		student.setId(1);
		return student;
	}
	
	@Bean(name = "second_student")
	public Student getSecondStudent() {
		Student student = new Student("Second", 21);
		student.setId(2);
		return student;
	}
	
	@Bean(name = "third_student")
	public Student getThirdStudent() {
		Student student = new Student("Third", 24);
		student.setId(1);
		return student;
	}
	
}

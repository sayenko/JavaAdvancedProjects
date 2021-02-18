package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.dao.impl.StudentDAOImpl;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		StudentDAOImpl studentDAOImpl = (StudentDAOImpl) ctx.getBean("studentDAO");
		
		Student first_student = (Student) ctx.getBean("first_student");
		Student second_student = (Student) ctx.getBean("second_student");
		Student third_student = (Student) ctx.getBean("third_student");
		
		//CREATE
		System.out.println("CREATE Student");
		System.out.println("CREATE ---> " + studentDAOImpl.create(first_student));
		System.out.println("CREATE ---> " + studentDAOImpl.create(second_student));
		System.out.println("--------------------------------------------------------------------");
		
		//READ ALL Students
		System.out.println("READ ALL Students");
		System.out.println(studentDAOImpl.readAll());
		System.out.println("--------------------------------------------------------------------");
		
		//READ Student by id
		System.out.println("READ Student by id");
		System.out.println(studentDAOImpl.read(2));
		System.out.println("--------------------------------------------------------------------");
		
		//UPDATE Student
		System.out.println("UPDATE Student");
		System.out.println(studentDAOImpl.update(third_student));
		System.out.println("--------------------------------------------------------------------");
		System.out.println("READ ALL Students after UPDATING");
		System.out.println(studentDAOImpl.readAll());
		System.out.println("--------------------------------------------------------------------");
		
		//Delete Student
		System.out.println("DELETE Student");
		studentDAOImpl.delete(2);
		System.out.println("READ ALL Students after DELETING");
		System.out.println(studentDAOImpl.readAll());
	}
}

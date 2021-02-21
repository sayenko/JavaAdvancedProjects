package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.domain.University;
import ua.lviv.lgs.service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UniversityService service = ctx.getBean(UniversityService.class);
		
		//create University
		University kpi = new University();
		kpi.setName("KPI");
		kpi.setLevelOfAccreditation(3);
		kpi.setNumberOfInstitutes(7);
		kpi.setAmountOfStudents(10000);
		kpi.setUniversityAddress("Kyiv");
		
		University shevchenko = new University();
		shevchenko.setName("Shevchenko");
		shevchenko.setLevelOfAccreditation(4);
		shevchenko.setNumberOfInstitutes(5);
		shevchenko.setAmountOfStudents(12000);
		shevchenko.setUniversityAddress("Kyiv");
		
		University nau = new University();
		nau.setName("NAU");
		nau.setLevelOfAccreditation(3);
		nau.setNumberOfInstitutes(4);
		nau.setAmountOfStudents(8000);
		nau.setUniversityAddress("Kyiv");
		
		System.out.println("\ncreate University");
		System.out.println(service.save(kpi));
		System.out.println(service.save(shevchenko));
		System.out.println(service.save(nau));
				
		// read from DB
		System.out.println("\nread by id");
		System.out.println(service.findById((long)2));
		
		System.out.println("\nread by Level of accreditation");
		
		service.findByLevelOfAccreditation(3).stream().forEach(System.out::println);
		
		System.out.println("\nread by name");
		service.findByName("NAU").stream().forEach(System.out::println);
		
		System.out.println("\nread all");
		service.findAll().stream().forEach(System.out::println);
		
		//update from DB
		University updatedUniversity = service.findById((long)1);
		updatedUniversity.setName("KNEU");
		updatedUniversity.setNumberOfInstitutes(5);
		updatedUniversity.setAmountOfStudents(8000);
		
		System.out.println("\nupdate university");
		System.out.println(service.update(updatedUniversity));
		System.out.println("\nread all from updated DB");
		service.findAll().stream().forEach(System.out::println);
		
		//delete from DB
		service.deleteById((long)2);
		System.out.println("\nread all from deleted DB");
		service.findAll().stream().forEach(System.out::println);
	}

}

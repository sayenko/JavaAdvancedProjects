package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.repository.UserRepository;
import ua.lviv.lgs.repository.UserRolesRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				
		UserRepository userBean = run.getBean(UserRepository.class);
		userBean.save(createUser(passwordEncoder));
		userBean.save(createAdmin(passwordEncoder));
		
		UserRolesRepository userRoleBean = run.getBean(UserRolesRepository.class);
		userRoleBean.save(createUserRole());
		userRoleBean.save(createAdminRole());
	}
	
	public static User createUser(BCryptPasswordEncoder password) {				
		User user = new User();
		user.setUserId(1L);
		user.setEnabled(1);
		user.setEmail("user");
		user.setPassword(password.encode("user"));
		user.setUserName("user");
		return user;
	}
	
	public static User createAdmin(BCryptPasswordEncoder password) {
		User admin = new User();
		admin.setUserId(2L);
		admin.setEnabled(2);
		admin.setEmail("admin");
		admin.setPassword(password.encode("admin"));
		admin.setUserName("admin");
		return admin;
	}

	public static UserRole createUserRole() {
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		userRole.setUserid(1L);
		userRole.setUserroleid(1L);
		return userRole;
	}
	
	public static UserRole createAdminRole() {
		UserRole adminRole = new UserRole();
		adminRole.setRole("ROLE_ADMIN");
		adminRole.setUserid(2L);
		adminRole.setUserroleid(2L);
		return adminRole;
	}
	
}

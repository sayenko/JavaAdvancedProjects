package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.domain.University;

public interface UniversityService {
	
	University save(University univercity);
	
	University findById(Long id);
	
	University update(University univercity);
	
	void deleteById(Long id);

	List<University> findAll();
	
	List<University> findByName(String name);
	
	List<University> findByLevelOfAccreditation(Integer level);
	
}

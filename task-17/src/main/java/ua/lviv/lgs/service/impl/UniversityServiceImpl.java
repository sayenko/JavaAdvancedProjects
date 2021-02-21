package ua.lviv.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UniversityRepository;
import ua.lviv.lgs.domain.University;
import ua.lviv.lgs.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {
	
	@Autowired
	private UniversityRepository univercityRepository;

	@Override
	public University save(University univercity) {
		return univercityRepository.saveAndFlush(univercity);
	}

	@Override
	public University findById(Long id) {
		return univercityRepository.getOne(id);
	}

	@Override
	public University update(University univercity) {
		return univercityRepository.saveAndFlush(univercity);
	}

	@Override
	public void deleteById(Long id) {
		univercityRepository.deleteById(id);
	}

	@Override
	public List<University> findAll() {
		return univercityRepository.findAll();
	}

	@Override
	public List<University> findByName(String name) {
		return univercityRepository.findByName(name);
	}

	@Override
	public List<University> findByLevelOfAccreditation(Integer level) {
		return univercityRepository.findByLevelOfAccreditation(level);
	}

}

package ua.lviv.lgs.repository;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}

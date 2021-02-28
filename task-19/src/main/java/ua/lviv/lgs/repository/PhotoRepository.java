package ua.lviv.lgs.repository;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.domain.Photo;

public interface PhotoRepository extends CrudRepository<Photo, String> {

}

package ua.lviv.lgs.dao;

import java.util.List;

public interface StudentDAO<T> {
	T create(T t);

	T read(Integer id);

	T update(T t);

	void delete(Integer id);
	
	List<T> readAll();
}

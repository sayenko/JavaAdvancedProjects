package ua.com.magazine_store.dao;

import ua.com.magazine_store.domain.User;
import ua.com.magazine_store.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD <User>{
	User getUserByEmail(String email);
}

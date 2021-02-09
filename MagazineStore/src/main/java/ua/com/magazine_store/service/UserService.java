package ua.com.magazine_store.service;

import ua.com.magazine_store.domain.User;
import ua.com.magazine_store.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{
	User getUserByEmail(String email);
}

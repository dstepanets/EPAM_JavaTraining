package go.univer.service;

import go.univer.dao.PaginalList;
import go.univer.entity.users.User;

import java.util.List;

public interface UserService {
	User register(User user);
	boolean login(String email, String password);
	PaginalList<User> findAll(int page);
}

package go.univer.service;

import go.univer.dao.PaginalList;
import go.univer.entity.users.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	User register(User user);
	Optional<User> login(String email, String password);
	PaginalList<User> findAll(int page);
}

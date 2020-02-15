package go.univer.service;

import go.univer.dao.PaginalList;
import go.univer.domain.User;

import java.util.Optional;

public interface UserService {
	User register(User user);

	Optional<User> login(String email, String password);

	PaginalList<User> findAll(String strPageNum);

	int getUsersCount();
}

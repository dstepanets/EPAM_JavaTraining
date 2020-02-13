package go.univer.service;

import go.univer.dao.PaginalList;
import go.univer.domain.User;
import go.univer.entity.users.UserEntity;

import java.util.Optional;

public interface UserService {
	UserEntity register(UserEntity userEntity);

	Optional<UserEntity> login(String email, String password);

	PaginalList<User> findAll(String strPageNum);

	int getUsersCount();
}

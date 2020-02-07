package go.univer.service;

import go.univer.domain.User;
import go.univer.entity.users.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
	UserEntity register(UserEntity userEntity);

	Optional<UserEntity> login(String email, String password);

	List<User> findAll(String strPageNum);
	int getUsersCount();
}

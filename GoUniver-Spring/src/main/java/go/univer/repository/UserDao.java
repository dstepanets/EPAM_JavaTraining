package go.univer.repository;

import go.univer.entity.users.UserEntity;

import java.util.Optional;

public interface UserDao extends CrudPaginalDao<UserEntity> {
	Optional<UserEntity> findByEmail(String email);
}


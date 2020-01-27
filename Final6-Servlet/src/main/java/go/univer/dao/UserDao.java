package go.univer.dao;

import go.univer.domain.users.User;

import java.util.Optional;

public interface UserDao extends CrudPaginalDao<User> {
	Optional<User> findByEmail(String email);
}


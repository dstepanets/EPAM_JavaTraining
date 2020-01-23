package bank.repo;

import bank.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
	Optional<User> findByEmail(String email);
}

package bank.repo;

import bank.domain.User;

public interface UserRepository extends CrudRepository<User> {
	User findByEmail(String email);
}

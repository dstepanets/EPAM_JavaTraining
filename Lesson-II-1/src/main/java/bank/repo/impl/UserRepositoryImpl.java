package bank.repo.impl;

import bank.domain.User;
import bank.repo.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
	private final Map<Integer,User> userIdToUser = new HashMap<>();

	@Override
	public User findByEmail(String email) {
		return null;
	}

	@Override
	public void save(User entity) {

	}

	@Override
	public User findById(Integer id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public void update(User entity) {

	}

	@Override
	public void deleteById(Integer id) {

	}
}

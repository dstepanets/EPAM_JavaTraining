package bank.repo.impl;

import bank.domain.User;
import bank.repo.UserRepository;

import java.util.*;

public class UserRepositoryImpl implements UserRepository {

	private final Map<Integer,User> userIdToUser = new HashMap<>();

	@Override
	public Optional<User> findByEmail(String email) {
		User u;
		for (Map.Entry<Integer, User> entry : userIdToUser.entrySet()) {
			u = entry.getValue();
			if (u.getEmail().equals(email)) {
				return Optional.of(u);
			}
		}
		return null;
	}

	@Override
	public void save(User user) {
		if (user != null) {
			Integer id = user.getId();
			if (!userIdToUser.containsKey(id)) {
				userIdToUser.put(id, user);
			} else {
				throw new IllegalArgumentException("There is a user with the same ID (Use update)");
			}
		}
	}

	@Override
	public Optional<User> findById(Integer id) {
		return Optional.of(userIdToUser.get(id));
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<>(userIdToUser.values());
	}

	@Override
	public void update(User user) {
		if (user != null) {
			Integer id = user.getId();
			if (userIdToUser.containsKey(id)) {
				userIdToUser.put(id, user);
			} else {
				throw new IllegalArgumentException("There is no such user yet (Use save to add a new one)");
			}
		}
	}

	@Override
	public void deleteById(Integer id) {
		if (id != null) {
			userIdToUser.remove(id);
		}
	}
}

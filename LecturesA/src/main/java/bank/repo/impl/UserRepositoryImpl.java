package bank.repo.impl;

import bank.domain.User;
import bank.repo.UserRepository;

import java.util.*;

public class UserRepositoryImpl implements UserRepository {

	private final Map<Integer,User> userIdToUser = new HashMap<>();

	@Override
	public Optional<User> findByEmail(String email) {
//		TODO validate email
		return userIdToUser.values().stream()
				.filter((User user) -> user.getEmail().equals(email))
				.findAny();
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
		return Optional.ofNullable(userIdToUser.get(id));
	}


	@Override
	public List<User> findAll(int page, int itemsPerPage) {
		//	TODO implement pagination with streams (порядок
		//	 може не зберігатися, згодиться). Test (e.g. page #4, 2 itemsPerPage)
		return new ArrayList<>(userIdToUser.values());
	}

	@Override
	public long count() {
		return userIdToUser.size();
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

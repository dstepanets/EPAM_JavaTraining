package bank.repo.impl;

import bank.domain.Account;
import bank.repo.AccountRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {

	private final Map<Integer, Account> accIdToAccount = new HashMap<>();

	public void save(Account entity) {
		if (entity != null) {
			Integer id = entity.getId();
			if (!accIdToAccount.containsKey(id)) {
				accIdToAccount.put(id, entity);
			} else {
				throw new IllegalArgumentException("There is an account with the same ID (Use update)");
			}
		}
	}

	@Override
	public Account findById(Integer id) {
		return accIdToAccount.get(id);
	}

	@Override
	public List<Account> findAll() {
		return new ArrayList<>(accIdToAccount.values());
	}

	@Override
	public void update(Account entity) {
		if (entity != null) {
			Integer id = entity.getId();
			if (accIdToAccount.containsKey(id)) {
				accIdToAccount.put(id, entity);
			} else {
				throw new IllegalArgumentException("There is no such account yet (Use save to add a new one)");
			}
		}
	}

	@Override
	public void deleteById(Integer id) {
		if (id != null) {
			accIdToAccount.remove(id);
		}
	}
}

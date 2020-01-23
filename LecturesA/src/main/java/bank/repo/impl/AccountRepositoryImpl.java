package bank.repo.impl;

import bank.domain.Account;
import bank.repo.AccountRepository;

import java.util.*;

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
	public Optional<Account> findById(Integer id) {
		return Optional.of(accIdToAccount.get(id));
	}

	@Override
	public List<Account> findAll(int page, int itemsPerPage) {
		return new ArrayList<>(accIdToAccount.values());
	}

	@Override
	public long count() {
		return accIdToAccount.size();
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

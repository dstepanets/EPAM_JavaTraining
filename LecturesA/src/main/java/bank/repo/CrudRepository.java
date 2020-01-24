package bank.repo;

import bank.repo.impl.Pageable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CrudRepository <E> {
//	create
	void save(E entity);
//	read
	Optional<E> findById(Integer id);

	default List<E> findAll() {
		return Collections.emptyList();		// TODO default implementation
	}

	long count();
//	update
	void update(E entity);
//	delete
	void deleteById(Integer id);
}

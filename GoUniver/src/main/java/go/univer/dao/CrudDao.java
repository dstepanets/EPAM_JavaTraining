package go.univer.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CrudDao<E> {
	//	create
	void save(E entity);
	//	read
	Optional<E> findById(Integer id);

	default List<E> findAll() {
		return Collections.emptyList();		// TODO default implementation
	}

	//	update
	void update(E entity);
	//	delete
	void deleteById(Integer id);
}

package go.univer.repository;

import java.util.List;
import java.util.Optional;

public interface CrudDao<E> {
	//	create
	void save(E entity);

	//	read
	Optional<E> findById(Integer id);

	List<E> findAll();

	int count();

	//	update
	void update(E entity);

	//	delete
	void deleteById(Integer id);
}

package bank.repo;

import java.util.List;

public interface CrudRepository <E> {
//	create
	void save(E entity);
//	read
	E findById(Integer id);
	List<E> findAll();
//	update
	void update(E entity);
//	delete
	void deleteById(Integer id);
}

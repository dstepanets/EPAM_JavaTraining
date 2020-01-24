package bank.repo;

import bank.repo.impl.Pageable;

import java.util.List;

public interface CrudPageableRepository<E> extends CrudRepository<E> {

	List<E> findAll(int page, int itemsPerPage);

	default Pageable<E> findAll(Page page) {
		return null; // tmp TODO
	}

	long count();

}

package go.univer.dao;

import java.util.List;

public interface CrudPaginalDao<E> extends CrudDao<E> {

		List<E> findAll(int page, int itemsPerPage);

		default PaginalList<E> findAll(Page page) {
			return null; //  TODO
		}

		long count();


}

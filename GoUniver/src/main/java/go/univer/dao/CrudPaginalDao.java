package go.univer.dao;

import java.util.List;

public interface CrudPaginalDao<E> extends CrudDao<E> {

		default PaginalList<E> findAll(Page page) {
			return null; //  TODO default impl
		}

		long count();


}

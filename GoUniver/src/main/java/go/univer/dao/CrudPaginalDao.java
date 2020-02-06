package go.univer.dao;

public interface CrudPaginalDao<E> extends CrudDao<E> {
	PaginalList<E> findAll(Page page);
}

package go.univer.repository;

public interface CrudPaginalDao<E> extends CrudDao<E> {
	PaginalList<E> findAll(Page page);
}

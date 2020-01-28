package com.bank.dao;

import com.bank.dao.domain.Page;
import com.bank.dao.domain.Pageable;

import java.util.List;

public interface CrudPageableDao<E> extends CrudDao<E> {

	List<E> findAll(int page, int itemsPerPage);

	default Pageable<E> findAll(Page page) {
		return null; // tmp TODO
	}

	long count();

}

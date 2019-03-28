package com.demo.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Dao层基础功能接口（重用方法）
 *
 */
public interface IBaseDao<T, PK extends Serializable> {
	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public T findOne(PK id);

	public List<T> findAll();
}

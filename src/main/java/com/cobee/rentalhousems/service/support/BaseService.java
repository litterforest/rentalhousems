package com.cobee.rentalhousems.service.support;

import java.util.List;

import com.cobee.rentalhousems.component.page.Page;
import com.cobee.rentalhousems.entity.support.BaseEntity;

public interface BaseService<T extends BaseEntity> {

	List<T> list(T obj);
	
	Page<T> findByPage(T obj);
	
	Page<T> findByPage(T obj, String selectSqlID);

	T get(Integer id);

	void save(T obj);

	Integer delete(Integer id);

	Integer deleteByLogic(Integer id);

	Integer updateBySelective(T obj);
	
	Integer queryByCount(T obj);

}

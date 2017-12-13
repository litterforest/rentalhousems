package com.cobee.rentalhousems.service;

import java.util.List;

import com.cobee.rentalhousems.entity.BaseEntity;

public interface BaseService<T extends BaseEntity> {

	List<T> list(T obj);

	T get(Integer id);

	void save(T obj);

	Integer delete(Integer id);

	Integer deleteByLogic(Integer id);

	Integer updateBySelective(T obj);

}

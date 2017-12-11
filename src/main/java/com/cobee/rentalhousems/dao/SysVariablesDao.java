package com.cobee.rentalhousems.dao;

import java.util.List;

import com.cobee.rentalhousems.entity.SysVariables;

public interface SysVariablesDao {

	List<SysVariables> list(SysVariables sysVariables);
	
	SysVariables get(Integer id);
	
	void insertBySelective(SysVariables sysVariables);
	
	Integer delete(Integer id);
	
	Integer updateBySelective(SysVariables sysVariables);
	
}

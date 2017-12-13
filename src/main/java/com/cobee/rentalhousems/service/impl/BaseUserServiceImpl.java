package com.cobee.rentalhousems.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhousems.dao.BaseUserDao;
import com.cobee.rentalhousems.entity.BaseUser;
import com.cobee.rentalhousems.service.AbstractService;
import com.cobee.rentalhousems.service.BaseUserService;

@Service
@Transactional(readOnly = true)
public class BaseUserServiceImpl extends AbstractService<BaseUser, BaseUserDao> implements BaseUserService {

	

}

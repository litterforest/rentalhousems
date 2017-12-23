package com.cobee.rentalhousems.service.support;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cobee.rentalhousems.component.page.Page;
import com.cobee.rentalhousems.component.page.PageRequest;
import com.cobee.rentalhousems.dao.support.BaseDao;
import com.cobee.rentalhousems.entity.support.BaseEntity;

public class PagingAndSortingService<T extends BaseEntity, E extends BaseDao<T>> extends AbstractService<T, E> {

	private static final Logger logger = LoggerFactory.getLogger(PagingAndSortingService.class);

	private static final String DEFAULT_PAGING_METHOD = "list";

	@Autowired
	protected SqlSessionFactory sqlSessionFactory;

	private String getMapperNamespace() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		return parameterizedType.getActualTypeArguments()[1].getTypeName();
	}

	public Page<T> findByPage(T paramObj) {
		return this.findByPage(paramObj, DEFAULT_PAGING_METHOD);
	}

	public Page<T> findByPage(T paramObj, String selectSqlID) {
		String selectID = getMapperNamespace() + "." + selectSqlID;
		SqlSession session = SqlSessionUtils.getSqlSession(sqlSessionFactory);
		Configuration conf = session.getConfiguration();
		MappedStatement ms = conf.getMappedStatement(selectID);
		// 1,查询总记录数
		PageRequest pageRequest = paramObj.getPageRequest();
		// 1.1,记数的时候排除掉order by, limit子句的影响
		paramObj.setPageRequest(null);
		BoundSql bs = ms.getBoundSql(paramObj);
		String sql = bs.getSql();
		sql = sql.toLowerCase();

		if (logger.isDebugEnabled()) {
			logger.debug("lowercase native sql no order by no limit>>>>>>>>>:" + sql);
		}

		Integer fromIdx = sql.indexOf("from");
		String countSql = "select count(1) " + sql.substring(fromIdx);

		if (logger.isDebugEnabled()) {
			logger.debug("count sql no order by no limit>>>>>>>>>:" + countSql);
		}

		// 1.2,计算首页、上一页、下一页、尾页、总页
		Page<T> page = new Page<T>();
		Integer totalCount = doTotalCount(session, countSql, paramObj, bs.getParameterMappings());
		if (totalCount == 0) return page;
		page.setPageNo(pageRequest.getCurrentPage());
		page.setPageSize(pageRequest.getPageSize());
		page.setTotalCount(totalCount);
		
		if (logger.isDebugEnabled()) 
		{
			logger.debug("首页：" + page.getFirstPage() + " 上一页：" + page.getPrePage() + " 下一页：" + page.getNextPage() + " 尾页："
					+ page.getLastPage() + " 总页数：" + page.getTotalPage() + " 总记录数：" + page.getTotalCount());
		}
		
		// 2,获取分页的数据
		List<T> list = null;
		paramObj.setPageRequest(pageRequest);
		list = session.selectList(selectID, paramObj);
		page.setContent(list);
		return page;
	}
	
	private Integer doTotalCount(SqlSession session, String countSql, Object paramObj, List<ParameterMapping> parameterMappingList)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			conn = session.getConnection();
			ps = conn.prepareStatement(countSql);
			for (int i = 0; i < parameterMappingList.size(); i++) {
				ParameterMapping pm = parameterMappingList.get(0);
				ps.setObject(i + 1, PropertyUtils.getProperty(paramObj, pm.getProperty()));
			}
			resultSet = ps.executeQuery();
			resultSet.next();
			return resultSet.getInt(1);
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			if (resultSet != null)
			{
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		return 0;
}

}

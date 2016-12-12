package edu.cuit.questionnaire.persist.pagination;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * use mybatis interceptor to pagination<br>
 * 
 * @author leckie
 * @date May 11, 2015
 */
@Intercepts(@Signature(type = Executor.class, method = "query", args = {
        MappedStatement.class, Object.class, RowBounds.class,
        ResultHandler.class }))
public class PaginationInterceptor implements Interceptor {

	private Properties properties;

	/**
	 * 获取参数中的PageInfo对象<br>
	 * 
	 * @param parameter
	 * @return null or PageInfo
	 */
	private PageInfo getPageInfo(Object parameter) {
		PageInfo pageInfo = null;
		if (parameter == null) {
			return null;
		}
		if (parameter instanceof PageInfo) {
			pageInfo = (PageInfo) parameter;
		} else if (parameter instanceof ParamMap) {
			ParamMap<?> map = (ParamMap<?>) parameter;
			for (Object arg : map.values()) {
				if (arg instanceof PageInfo) {
					pageInfo = (PageInfo) arg;
					break;
				}
			}
		}
		return pageInfo;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		final Object[] args = invocation.getArgs();

		PageInfo pageInfo = getPageInfo(args[1]);
		if (pageInfo != null) {
			// 是分页方法, 进行拦截
			Page<?> page = new Page<Object>();
			Object result = invocation.proceed();
			page.addAll((List) result);
			page.setPageNum(pageInfo.getPageNum());
			page.setPageSize(pageInfo.getPageSize());
			page.setTotalRows(pageInfo.getTotalRows());
			page.setTotalPages(pageInfo.getTotalPages());

			return page;
		}

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Properties getProperties() {
		return this.properties;
	}

}

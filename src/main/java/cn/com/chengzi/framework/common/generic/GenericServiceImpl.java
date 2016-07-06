package cn.com.chengzi.framework.common.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class GenericServiceImpl<T,PK extends Serializable> implements GenericService<T, PK> {
    //protected GenericMapper<T,PK> genericMapper;
	
	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByWhere(T queryCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByWhere(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

}

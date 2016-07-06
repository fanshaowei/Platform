package cn.com.chengzi.framework.common.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface GenericService<T,PK extends Serializable> {
    public abstract List<T> getAll(); 
    
    public abstract List<T> getAll(PK id);
    
    public abstract List<T> findByWhere(T queryCriteria);
    
    public abstract List<T> findByWhere(Map<String,Object> paramMap);
    
}

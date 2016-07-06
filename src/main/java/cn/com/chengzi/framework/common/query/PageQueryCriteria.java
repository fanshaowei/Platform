package cn.com.chengzi.framework.common.query;

import cn.com.chengzi.framework.common.utils.StringUtil;

/**
 * 分页参数对象
 * @author fanshaowei
 *
 */
public class PageQueryCriteria implements QueryCriteria {
	private int index;	//从哪一条开始
    
    private int rows ;//到第几条结束
    
    private int pageNumber;//前端查询参数，第几页
    
    private int pageSize;//前端查询参数，页面大小
    
    private String sort ; // 排序对象
    
    private String order ;// DESC,ASC
    
    
    //-----------------------------------------------------------------------------
    
    public int getIndex(){
    	return index;
    }
    
    public void setIndex(int index){
    	this.index=index;
    }
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public String getSort() {
		return sort;
	}
	
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getOrder() {
		return order;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}

	 public int getPageNumber() {
			return pageNumber;
		}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//-----------------------------------------------------------------------------	

	public String getOrderBy() {
	        if (StringUtil.isEmpty(sort) || StringUtil.isEmpty(order)) {
	            return null;
	        }
	        return sort + " " + order.toUpperCase();
	    }
}

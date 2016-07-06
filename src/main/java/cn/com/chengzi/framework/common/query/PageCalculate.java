package cn.com.chengzi.framework.common.query;


/**
 * 分页对象
 * @author fanshaowei
 *
 */
public class PageCalculate {
    
	public int pageNumber = 1;  //第几页
    
    public int totalCount;      //总条数
    
    public int pageSize= 20;    //一页几条
    
    public int pageCount;       //总共分成多少页
    
    public int index = 0;       //分页起始记录  
    
    public PageCalculate(int totalCount,int pageSize,int pageNumber){
    	this.totalCount = totalCount;
    	this.pageSize = pageSize;
    	this.pageNumber = pageNumber;
    	if (pageSize != 0) {
            if (totalCount % pageSize == 0) {
                pageCount = totalCount / pageSize;
            } else {
                pageCount = totalCount / pageSize + 1;
            }
        }
    	
    	this.index = (pageNumber -1)  * pageSize;
    }
    
    //---------------------------------------------------------------------------
    
   /* public int getRowIndex(){
    	 this.index = (this.pageNumber -1)  * this.pageSize;
    	 return index;
    }*/

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotal() {
		return totalCount;
	}

	public void setTotal(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}

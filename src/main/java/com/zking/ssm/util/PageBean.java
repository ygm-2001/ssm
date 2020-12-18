package com.zking.ssm.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class PageBean {

	//三大要素
	private int page = 1;// 当前页码
	private int rows = 10;// 页大小
	private int total = 0;// 总记录数
	private boolean pagination = true;// 是否分页
	
	//请求的地址
	private String url;
	//请求的参数集合
	private Map<String, String[]> parameterMap;
	

	public PageBean() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPage(String page) {
		if (null != page && !"".equals(page.trim())) {
			this.page = Integer.parseInt(page);
		}

	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setRows(String rows) {
		if (null != rows && !"".equals(rows.trim())) {
			this.rows = Integer.parseInt(rows);
		}

	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotal(String total) {
		if (null != total && !"".equals(total.trim())) {
			this.total = Integer.parseInt(total);
		}

	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	public void setPagination(String pagination) {

		if ("false".equals(pagination)) {
			this.pagination = false;
		}
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination + "]";
	}

	/**
	 * 获取起始记录的下标
	 * 
	 * @return
	 */
	public int getStartIndex() {
		int startIndex = (this.page - 1) * this.rows;

		return startIndex;
	}

	/**
	 * 初始化pageBean
	 * @param req
	 * @param pageBean
	 */
	public void initPageBean(HttpServletRequest req, PageBean pageBean) {
		pageBean.setPage(req.getParameter("page"));
		pageBean.setRows(req.getParameter("rows"));
		pageBean.setPagination(req.getParameter("pagination"));
		
		
		pageBean.setUrl(req.getContextPath()+req.getServletPath());
		pageBean.setParameterMap(req.getParameterMap());
	}
	
	/**
	 * 获取最大页码数
	 * @return
	 */
	//maxPage
	public int getMaxPage() {
		int maxPage = this.total/this.rows;
		if(0!=this.total%this.rows) {
			maxPage =maxPage+1;
		}
		return maxPage;
	}
	
	/**
	 * 获取下一页
	 * @return
	 */
	public int getNextPage() {
		int nextPage = this.page+1;
		if(nextPage>this.getMaxPage()) {
			nextPage = this.getMaxPage();
		}
		return nextPage;
	}
	
	/**
	 * 获取上一页
	 * @return
	 */
	public int getFrontPage() {
		int frontPage = this.page-1;
		if(frontPage<1) {
			frontPage =1;
		}
		return frontPage;
	}
}

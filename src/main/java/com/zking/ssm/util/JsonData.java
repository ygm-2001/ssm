package com.zking.ssm.util;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 服务器返回给客户端的JSON格式的数据
 *
 */
public class JsonData extends HashMap<String, Object> implements Serializable {

	private static final long serialVersionUID = -8855960778711040221L;

	private static final String CODE_KEY = "code";// 操作代码 0 成功 非0 失败
	private static final String MESSAGE_KEY = "message";// 操作消息
	private static final String RESULT_KEY = "result";// 结果集
	private static final String PAGE_KEY = "page";// 页码
	private static final String ROWS_KEY = "rows";// 每页行数/页大小
	private static final String TOTAL_KEY = "total";// 总记录数
	private static final String TS_KEY = "ts";// 时间戳

	public JsonData() {
		super();
		this.put(CODE_KEY, 0);// 默认操作成功
		this.put(TS_KEY, System.currentTimeMillis());
	}

	public void setCode(Integer code) {
		this.put(CODE_KEY, code);
	}

	public void setMessage(String message) {
		this.put(MESSAGE_KEY, message);
	}

	public void setResult(Object result) {
		this.put(RESULT_KEY, result);
	}

	public void setPage(Integer page) {
		this.put(PAGE_KEY, page);
	}

	public void setRows(Integer rows) {
		this.put(ROWS_KEY, rows);
	}

	public void setTotal(Integer total) {
		this.put(TOTAL_KEY, total);
	}

}

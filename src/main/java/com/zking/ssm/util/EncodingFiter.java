package com.zking.ssm.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 中文乱码处理
 * 
 */
public class EncodingFiter implements Filter {

	private String encoding = "UTF-8";// 默认字符集

	public EncodingFiter() {
		super();
	}

	@Override
	public void destroy() {
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// 中文处理必须放到 chain.doFilter(request, response)方法前面
		resp.setContentType("text/html;charset=" + this.encoding);
		if (req.getMethod().equalsIgnoreCase("post")) {
			req.setCharacterEncoding(this.encoding);
		} else {
			Map map = req.getParameterMap();// 保存所有参数名=参数值(数组)的Map集合
			Set set = map.keySet();// 取出所有参数名
			Iterator it = set.iterator();
			while (it.hasNext()) {
				String name = (String) it.next();
				String[] values = (String[]) map.get(name);// 取出参数值[注：参数值为一个数组]
				for (int i = 0; i < values.length; i++) {
					values[i] = new String(values[i].getBytes("ISO-8859-1"),
							this.encoding);
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String s = filterConfig.getInitParameter("encoding");// 读取web.xml文件中配置的字符集
		if (null != s && !s.trim().equals("")) {
			this.encoding = s.trim();
		}
	}

}

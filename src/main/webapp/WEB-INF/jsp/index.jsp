<html>
<head>
    <title>主界面</title>
    <%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@include file="/common/head.jsp" %>
</head>
<body>
<details>
    <summary>页面说明</summary>
    <h1>欢迎进入index.jsp</h1>
    <h2>【本次jsp页面主要用于测试，正式页面位于Vue】</h2>
</details>

<div align="center">
    <h3>正式测试</h3>
</div>
<%--<details>--%>
<%--    <summary>User测试相关内容</summary>--%>
<h4>内容如下</h4>
<mark>根据id查询user用户</mark><br/>
${user}<br/>
<mark>增加一个用户</mark><br/>
<form action="${ctx}/user/add" method="post">
    <label>一个简单的注册</label><br/>
    处理信息：${addUser}<br/>
    处理结果：${mgs}<br/>
    姓名：<input type="text" name="name"/>
    密码：<input type="password" name="password"/>
    <br/>
    <input type="submit"/> <input type="reset" />
</form>

<%--</details>--%>

</body>

</html>
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
<label>一个简单的注册</label><br/>
处理信息：${addUser},${updPwdUser}<br/>
<div align="center">
    <label class="return">处理结果：${mgs}</label><br/>
</div>
<details>
    <summary>测试user注册api</summary>
    <form action="${ctx}/user/add" method="post">
        身份证号：<input type="text" name="jIdentity"/><br/>
        姓名：<input type="text" name="jName"/>
        <br/>
        <input type="submit"/> <input type="reset" />
    </form>
</details>

<form action="${ctx}/user/updPwd" method="post">
    身份证号：<input type="text" name="identity"/><br/>
    旧密码：<input type="text" name="oldPwd"/><br/>
    新密码：<input type="text" name="newPwd"/>
    <br/>
    <input type="submit"/> <input type="reset" />
</form>

<%--</details>--%>

</body>
<style>
    mark{
        background-color: #358046;
        color: #fffbe0;
    }
    .return{
        font-size: 30px;
        font-weight: bolder;
    }
</style>
</html>
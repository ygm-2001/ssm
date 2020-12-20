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
<div align="right"><a href="${ctx}"><button>刷新本页面</button></a></div>
<%--关于用户的一些api测试--%>
<%--<details>--%>
<%--    <summary>User测试相关内容</summary>--%>
<h4>内容如下</h4>
<mark>根据id查询user用户</mark><br/>
${user}<br/>
<mark>增加一个用户</mark><br/>
<label>一个简单的注册</label><br/>
处理信息：${addUser},${updPwdUser},${updStatusUser}<br/>
<div align="center">
    <label class="return">处理结果：${mgs}</label><br/>
</div>
<%--  用户注册api测试--%>
<details>
    <summary>测试user注册api</summary>
    <form action="${ctx}/user/add" method="post">
        身份证号：<input type="text" name="jIdentity"/><br/>
        姓名：<input type="text" name="jName"/>
        <br/>
        <input type="submit"/> <input type="reset" />
    </form>
</details>

<%--  用户修改密码api测试--%>
<details>
    <summary>测试user修改密码api（注意：用户状态需要‘已激活’）</summary>
<form action="${ctx}/user/updPwd" method="post">
    身份证号：<input type="text" name="identity"/><br/>
    旧密码：<input type="password" name="oldPwd" show-password/><br/>
    新密码：<input type="password" name="newPwd" show-password/>
    <br/>
    <input type="submit"/> <input type="reset" />
</form>
</details>

<%--  用户登录api测试--%>
<%--<details>--%>
<%--    <summary>测试user登录api</summary>--%>
<form action="${ctx}/user/login" method="post">
    身份证号：<input type="text" name="identity"/><br/>
    密码：<input type="password" name="password" show-password/>
    <br/>
    <input type="submit"/> <input type="reset" />
</form>
<%--</details>--%>



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
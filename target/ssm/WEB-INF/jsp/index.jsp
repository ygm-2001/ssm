<html>
<head>
    <title>主界面</title>
    <%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@include file="/common/head.jsp" %>
<%--    10秒刷新本页--%>
<%--    <meta http-equiv="refresh" content="10; url=http://localhost:8080/ssm/user/listUser" />--%>
</head>
<body onload="init()">
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
处理信息：${addUser},${updPwdUser},${updStatusUser},${actUser}<br/>
<div align="center">
    <label class="return">处理结果：<mark class="mgs">${mgs}</mark></label><br/>
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
<details>
    <summary>测试user登录api</summary>
<form action="${ctx}/user/login" method="post">
    身份证号：<input type="text" name="identity"/><br/>
    密码：<input type="password" name="password" show-password/>
    <br/>
    <input type="submit"/> <input type="reset" />
</form>
</details>

<%--  用户激活api测试--%>
<%--<details>--%>
<%--    <summary>user未激活api<-->已激活<-->已上机</summary>--%>
<div align="center">
    <%--注意这里不嫩写在form，不然action将是form的--%>
        <c:if test="${empty listUserAll}">
            <a href="${ctx}/user/listUser">
                <button>获取身份证号</button>
            </a>
        </c:if>
<%--            身份激活验证--%>
        <form action="${ctx}/user/actStatus" method="post">
            身份证号：<select name="identity">
            <c:forEach items="${listUserAll}" var="u">
                <c:if test="${u.state=='未激活'}">
                    <option>${u.identity}</option>
                </c:if>
            </c:forEach>
        </select>
            <c:if test="${not empty listUserAll}">
                <input type="submit" value="激活" /> <input type="reset" value="刷新"/>
            </c:if>
        </form>

        <%--    下机【已激活，已上机】-->未激活--%>
        <form action="${ctx}/user/actStatusDown" method="post">
            身份证号：<select name="identity">
            <c:forEach items="${listUserAll}" var="u">
                <c:if test="${u.state=='已激活' or u.state=='已上机'}">
                    <option>${u.identity}</option>
                </c:if>
            </c:forEach>
        </select>
            <c:if test="${not empty listUserAll}">
                <input type="submit" value="下机" /> <input type="reset" value="刷新"/>
            </c:if>
        </form>
</div>
<%--</details>--%>

<%--</details>--%>

</body>
<style>
    mark{
        background-color: #30801f;
        color: #ecffea;
    }
    .return{
        font-size: 30px;
        font-weight: bolder;
    }
    .mgs{
        background-color: #5eff49;
        color: #ff4242;
        border-radius: 10%;
    }
</style>
<script>
    function init() {

    }
</script>
</html>
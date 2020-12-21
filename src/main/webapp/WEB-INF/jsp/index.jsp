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
<mark>当前user传参</mark><br/>
${user}<br/>
<mark>增加一个用户</mark><br/>
<label>一个简单的注册</label><br/>
处理信息：${addUser},${updPwdUser},${updStatusUser},${actUser}<br/>
<div align="center">
    <label class="return">处理结果：<mark class="mgs">${mgs}</mark></label><br/>
</div>
<%--    这个是一个测试一个好玩的（修改背景颜色，但是效果只能维持Tomcat启动这一次）--%>
<details>
    <summary>修改背景颜色</summary>
    <style style="display:block;" contentEditable>
        body { background: #617480; }
    </style>
</details>

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
<details>
    <summary>测试user未激活api<-->已激活<-->已上机</summary>
    <div align="center">
        <%--注意这里不嫩写在form，不然action将是form的--%>
<%--        注意：同时查获得是用户信息 2--%>
            <c:if test="${empty listUserAll}">
                <a href="${ctx}/user/listUserNoPager?lv=2">
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
</details>

<%--  用户的查询，模糊查询，分页查询，以及集合以上一些按钮状态的改变--%>
<%--<details>--%>
<%--    <summary>测试用户表单的显示（分页信息，注意：'需要查询的是用户，网管就不要安排出来了'）</summary>--%>
<div align="center">
<%-- 模糊按钮查询对象--%>
<%--    需要实现的是按钮--%>
<%--    按钮名称     关键字--%>
<%--state--%>
<%--①    未激活    '未激活'--%>
<%--②    已激活    '已激活'--%>
<%--③    已上机    '已上机'--%>
<%--vipid--%>
<%--①    小白        4--%>
<%--②    高级用户   3，2，1--%>
<%--③    白金        3--%>
<%--④    黄金        2--%>
<%--⑤    钻石        1--%>
    <a href="${ctx}/user/listUserBy?state=未激活"><button>未激活</button></a>
        <a href="${ctx}/user/listUserBy?state=已激活"><button>已激活</button></a>
            <a href="${ctx}/user/listUserBy?state=已上机"><button>已上机</button></a>
    <br/>
                <a href="${ctx}/user/listUserBy?vipid=1"><button>铂金会员</button></a>
                    <a href="${ctx}/user/listUserBy?vipid=2"><button>黄金会员</button></a>
                        <a href="${ctx}/user/listUserBy?vipid=3"><button>青铜会员</button></a>
                            <a href="${ctx}/user/listUserBy?vipid=4"><button>黑铁会员</button></a>
   <br/>
    <a href="${ctx}/user/checkVipUser?vipId=1,2,3"><button>会员用户</button></a>
    <table>
        <tr class="tab-header">
            <td>编号</td>
            <td>用户名</td>
            <td>余额</td>
            <td>状态</td>
            <td>会员等级</td>
            <td>operation操作</td>
        </tr>
        <c:forEach items="${listUserTab}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.money}</td>
                <td>${u.state}</td>
                <td>
                    <a href="${ctx}/user/checkVip?vipid=${u.vipid}"><button>查看会员</button></a>
                </td>
                <td>
                    operation操作
                </td>
            </tr>
        </c:forEach>
    </table>
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
    input{
        border-radius: 10%;
    }
    .tab-header{
        font-weight: bolder;
    }
</style>
<script>
    function init() {
        // alert("欢迎光临")
    //    进入本页加载一些初始化数据
    }
</script>
</html>
<html>
<head>
    <title>上传界面</title>
    <%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@include file="/common/head.jsp" %>
</head>
<body>
<h1>
    上传界面
</h1>
<h2>
    <form action="${ctx}/file/upload" method="post" enctype="multipart/form-data">
        <input name="bookId" value="${param.bookId}"/>
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>

</h2>

<h4>
    <a href="${ctx}/bookList?bookName=">返回</a>
</h4>
<a href="${ctx}">返回主页</a><br/>
</body>
</html>

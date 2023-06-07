<%--
  Created by IntelliJ IDEA.
  User: poker
  Date: 2023/6/6
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<div class="container">
    <h3>添加用户</h3>
    <form action="${pageContext.request.contextPath}/adduserServlet" method="post">
        <div class="form-group">
            <label for="username">username</label>
            <input type="text" class="form-contorl" id="username" name="username">
        </div>

        <div class="form-group">
            <label for="password">password</label>
            <input type="text" class="form-contorl" id="password" name="password">
        </div>

        <div class="form-group" style="text-align:center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>

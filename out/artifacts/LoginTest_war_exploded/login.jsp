<%--
  Created by IntelliJ IDEA.
  User: poker
  Date: 2023/6/6
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/loginServlet" method="post">
      用户名:<input type="text" name="username"> <br>
      密码:<input type="password" name="password"><br>

      <input type="submit" value="登录">

  </form>
  </body>
</html>

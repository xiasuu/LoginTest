<%--
  Created by IntelliJ IDEA.
  User: poker
  Date: 2023/6/6
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息管理系统</title>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <table class="table table-bordered table-hover">
        <div style="float: left;">
            <form class="form-inline" action="${pageContext.request.contexPath}/finduserByPageServlet" method="post">
                <div class="form-group">
                    <label for="id">id</label>
                    <input>
                </div>
            </form>
        </div>
        <tr class="success">
            <th>id</th>
            <th>username</th>
            <th>password</th>
        </tr
        >
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="add.html">添加联系人</a></td>
        </tr>
    </table>
</div>
</body>
</html>

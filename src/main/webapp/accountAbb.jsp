<%--
  Created by IntelliJ IDEA.
  User: ztc
  Date: 2020/11/30
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addt.do" method="post">
    <table width="30%" border=1>
        <tr>
            <td>账号</td> <td><input type="text" placeholder="请输入新的账号" name="zpassword"></td>
        </tr>
        <tr>
            <td>密码</td> <td><input type="password" placeholder="请输入你的密码" name="zname" ></td>
        </tr>
        <tr>
            <td colspan="2">添加</td>
        </tr>
    </table>
</form>
</body>
</html>

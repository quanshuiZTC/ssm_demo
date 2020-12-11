<%--
  Created by IntelliJ IDEA.
  User: ztc
  Date: 2020/11/25
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addp.do"   enctype="multipart/form-data" method="post">
    <table width="30%" border=1>
        <tr>
            <td>姓名</td>  <td><input type="text" name="name"></td>
        </tr>

        <tr>
            <td>性别</td>

            <td>
                <input type='radio' name='sex' value='m' checked="checked">男
                <input type="radio" name="sex" value="f">女<br>
            </td>

        </tr>

        <tr>
            <td>年龄</td>  <td><input type="text" name="age" ></td>
        </tr>


        <tr>
            <td>班级</td>

            <td>
                <select name="bid">
                    <c:forEach varStatus="sta" var="cla" items="${classrooms}">
                        <option value="${cla.id}">${cla.bname}</option>
                    </c:forEach>
                </select>
            </td>

        </tr>

        <tr>
            <td>上传图片</td>
            <td>
                <input type='file' name='filename'>
            </td>
        </tr>


        <tr>
            <td colspan="2"><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
    <br>
    <form action="${pageContext.request.contextPath}/fuzzyQueryp.do" method="post">
        <input type='submit'value='返回'>
    </form>

</body>
</html>

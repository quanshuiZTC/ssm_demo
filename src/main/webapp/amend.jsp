<%--
  Created by IntelliJ IDEA.
  User: ztc
  Date: 2020/11/4
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script src="${pageContext.request.contextPath}/jquery-3.3.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<script>
    <%--$(document).ready(function () {--%>
    <%--            $.ajax({--%>
    <%--                type:"post",--%>
    <%--                url:"${pageContext.request.contextPath}/queryclassx.do",--%>
    <%--                success:function (data) {--%>
    <%--                    var querall= $("#bj").val()--%>
    <%--                    var str=""--%>
    <%--                        for (var i= 0;i< data.length ;i++){--%>
    <%--                           // str+=  "<option value=' "+ data[i].id + data.id==querall?'selected':'' +">"+data.bname+"</option>"--%>
    <%--                           str+="<option  value='"+data[i].id +"'"+[data[i].id==querall?'selected':'']+">"+data[i].bname+"</option>";--%>
    <%--                        }--%>
    <%--                   $ ("#ll").html(str)--%>
    <%--                },--%>
    <%--                error:function () {--%>
    <%--                    alert("出错了")--%>
    <%--                }--%>
    <%--            })--%>
    <%--})--%>
</script>
<body>

<form action="${pageContext.request.contextPath}/updatep.do" method="post">
    <input type="hidden" name="id" value="${querall.id}"/>
    <table width="30%" border=1>
        <tr>
            <td>姓名</td>  <td><input type="text" name="name" value="${querall.name}" ></td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                <input type='radio' name='sex' value='m'  ${querall.sex=="m"?"checked":""} >男
                <input type="radio" name="sex" value="f" ${querall.sex=="f"?"checked":"" }>女<br>
            </td>
        </tr>

        <tr>
            <td>年龄</td>  <td><input type="text" name="age" value="${querall.age}"></td>
        </tr>

        <tr>
            <td>班级</td>



            <td>
                <select name="bid">
                    <c:forEach varStatus="sta" var="cla" items="${classrooms}">
                        <option value="${cla.id}" ${cla.id==querall.bid?"selected":""}>${cla.bname}</option>
                    </c:forEach>
                </select>
            </td>

<%--            <td ><select id="ll"></select> </td>--%>
        </tr>

        <tr>
            <td>照片</td>
            <td>
                <img src="${pageContext.request.contextPath}/file/${querall.picture}"  style="width:25px;height:25px">
            </td>
        </tr>

        <tr>
            <td>修改照片</td>
            <td>
                <input type='file' name='filename'>
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="修改" id="xg"></td>
        </tr>

<%--        <input type="hidden" id="bj" value="${querall.bid}"/>--%>
    </table>
    </form>
    <br>
    <form action="${pageContext.request.contextPath}/fuzzyQueryp.do" method="post">
        <input type='submit'value='返回'>
    </form>

</body>
</html>

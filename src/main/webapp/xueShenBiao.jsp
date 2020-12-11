<%--
  Created by IntelliJ IDEA.
  User: ztc
  Date: 2020/11/3
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
        function readradio(){
            var cstuden = document.getElementsByName("student")
            for (var i = 0; i < cstuden.length; i++) {
                cstuden[i].checked = !cstuden[i].checked;
            }
        }
    $(function () {
        $("[data-toggle='popover']").popover();
    });
</script>
<body>

    <form action="${pageContext.request.contextPath}/fuzzyQueryp.do" method="post">
        <input  type="text" placeholder="姓名" name="name">
        <input  type="text" placeholder="年龄" name="age">
        <select name="bid">
            <c:forEach varStatus="sta" var="cla" items="${classrooms}">
                <option value="none" selected disabled hidden>请选择班级</option>
                <option value="${cla.id}">${cla.bname}</option>
            </c:forEach>
        </select>
        <input type="submit" value="查询">
    </form>

    <form action="${pageContext.request.contextPath}/deleteByIds.do" >
        <table width="30%" border=1>
                <tr>
                    <input type='submit'value='批量删除'>
                    <td> <input type="checkbox" onclick="readradio()"></td>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>班级</td>
                    <td>照片</td>
                    <td>设置</td>
                </tr>


            <c:forEach varStatus="sta" var="quall" items="${querall}">
                <tr>
                    <td><input type="checkbox" name="student" value="${quall.id}"></td>
                    <td>${sta.index+1}</td>
                    <td>${quall.name}</td>
                    <td>${quall.sex=="m"?"男":"女"}</td>
                    <td>${quall.age}</td>
                    <td>${quall.classx.bname}</td>
                    <td><img src="${pageContext.request.contextPath}/file/${quall.picture}"  style="width:25px;height:25px"></td>
                    <td><a href="${pageContext.request.contextPath }/deletep.do?id=${quall.id}">删除</a>|<a href="${pageContext.request.contextPath }/getByidp.do?id=${quall.id}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <form action="${pageContext.request.contextPath}/queryclassx.do" method="post">
        <input type='submit'value='添加新学生'>
    </form>

    <div>
        <a href="${pageContext.request.contextPath}/fuzzyQueryp.do?page=1" >首页</a>
<c:if test="${page!=1}">
        <a href="${pageContext.request.contextPath}/fuzzyQueryp.do?page=${page-1}" >上一页</a>
</c:if>
<c:if test="${page!=pages}">
        <a href="${pageContext.request.contextPath}/fuzzyQueryp.do?page=${page+1} ">下一页</a>
</c:if>
        <a href="${pageContext.request.contextPath}/fuzzyQueryp.do?page=${pages}">尾页</a>
        共${pages}页|当前在第${page}页
    </div>

</body>
</html>

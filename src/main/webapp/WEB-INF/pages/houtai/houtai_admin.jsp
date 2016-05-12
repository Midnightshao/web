<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>用户</title>
</head>
<body>
asldjfkasdjfwaijgwrauighveiuahgwaughwauklgawhdukghkdsahgwaedf
<%--<div class="panel panel-default">--%>
    <%--<!-- Default panel contents -->--%>
    <%--<div class="panel-heading">Panel heading</div>--%>
    <%--<div class="panel-body">--%>
        <%--<p> 这个是用户管理</p>--%>
    <%--</div>--%>

    <table class="table" border="1" bgcolor="#f0f8ff">
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>图片</td>
        </tr>
        <t:forEach items="${admin_list}" var="st">
        <tr>
            <td>${st.id}</td>
            <td>${st.name}</td>

            <td>
                <form:form action="/houtai_admin/delete" method="post">
                    <input type="hidden" name="id" value="${st.id}">
                    <input type="submit" value="删除">
                </form:form>
                </td>
        </tr>
        </t:forEach>
     </table>
<%--</div>--%>
</body>
</html>

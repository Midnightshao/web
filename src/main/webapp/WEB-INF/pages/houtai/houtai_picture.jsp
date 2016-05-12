<%--
  Created by IntelliJ IDEA.
  User: guanghaoshao
  Date: 16/3/9
  Time: 上午11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>


<t:forEach items="${serverPicture}" var="stu">
  <div class="panel panel-default">
    <div class="panel-heading">${stu.img_picture} &nbsp;&nbsp;&nbsp;<a href="/starter/houtai_picture/${stu.id}">删除</a></div>
  </div>
</t:forEach>
<h2>更改图片</h2>
<form style="margin: 13%" action="/starter/houtai_picture/add" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputFile">图片</label>
    <input type="file" id="exampleInputFile" name="file">
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>

</body>
</html>

<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>哎好天气</title>
</head>
<body>
<h1>ddddfjklafklajsfjasjfusvfadjvadfojvdjgreuvjfxzvjfvojf哈哈哈</h1><br>

<t:forEach items="${Stu}" var="stu">
    <div class="panel panel-default">
        <div class="panel-heading">${stu.title} &nbsp;&nbsp;&nbsp;<a href="/starter/delete/${stu.id}">删除</a></div>
        <div class="panel-body">
            <div>
                <li>${stu.img_type}</li>
                <li>${stu.content}</li>
            </div>
        </div>
    </div>
</t:forEach>

<form style="margin: 13%" action="/starter/add" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="EXAMPLEINPUTFILE">标题</label>
        <input type="text" class="form-control" placeholder="标题" name="title"></div>
    <div class="form-group">
        <label for="EXAMPLEINPUTFILE">输入内容</label>
        <textarea class="form-control" rows="3" name="content"></textarea>    </div>
    <div class="form-group">
        <label for="exampleInputFile">图片</label>
        <input type="file" id="exampleInputFile" name="file">
        <p class="help-block">Example block-level help text here.</p>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
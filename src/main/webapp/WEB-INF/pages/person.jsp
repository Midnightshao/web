<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guanghaoshao
  Date: 16/2/29
  Time: 上午1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>person</title>
  <link href="/css/bootstrap.min.css" rel="stylesheet">

  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>

  <script src="//cdn.bootcss.co=m/respond.js/1.4.2/respond.min.js"></script>
  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
  <script src="/js/bootstrap.min.js"></script>
  <script src="/js/bootstrap.js"></script>
  <script src="/js/npm.js"></script>
</head>
<body>
<script>
  function ab(c) {
    var abc = new Array("activity1", "activity2", "activity3");
    var bcd = document.getElementById("iframes") ;
    for(var i=0;i<abc.length;i++){
      if(i==c){
        document.getElementById(abc[i]).className="active";
      }else {
        document.getElementById(abc[i]).className="";
      }
    }
    switch (c){
      case 0:
          bcd.src="/person1.jsp";
        break;
      case 1:
          bcd.src="/person2.jsp"
        break;
      case 2:
          bcd.src="/person3.jsp"
        break;
    }
  }

  function abc(c) {
    var abc = new Array("activiti1", "activiti2", "activiti3");
    for(var i=0;i<abc.length;i++){
      if(i==c){
        document.getElementById(abc[i]).className="active";
      }else {
        document.getElementById(abc[i]).className="";
      }
    }
  }
</script>
<script>
  function absa(a){
    alert("xxxxxx")
    alert(a)
    document.getElementById("iframes").src=a;
  }
</script>
<jsp:include page="include_title.jsp"></jsp:include>

<div class="container">
  <div class="page-header"  style="background-image:url(img/chuyin5.jpg);height: 100px">
  </div>
  <div>
    <span> <img src="img_person/${picture_img}" width="30%" height="30%" style="margin-top: -10%"></span><span>${person_name}</span>
  </div>
</div>
<div class="container">
  <ul class="nav nav-tabs">
    <li role="presentation" id="activiti1" onclick="abc(0)" class="${person1}"><a href="/person/peronzone"   >个人空间</a></li>
    <li role="presentation" id="activiti2" onclick="abc(1)" class="${person2}"><a href="/person/publishing"   >个人发表</a></li>
    <li role="presentation" id="activiti3" onclick="abc(2)" class="${person3}"><a href="/person/other"   >其他</a></li>
  </ul>
</div>
<!-- 16:9 aspect ratio -->
<div class="container">
  <t:import url="${person}.jsp"></t:import>
</div>
</body>
</html>

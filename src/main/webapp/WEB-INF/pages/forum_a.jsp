<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: guanghaoshao
  Date: 16/1/3
  Time: 下午5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <META HTTP-EQUIV="pragma" CONTENT="no-cache">
  <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
  <META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Insert title here</title>
  <!-- Bootstrap -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">

  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>

  <script src="/js/jquery-1.8.0.js"></script>
  <script src="/js/jquery-1.8.0.min.js"></script>

  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
  <script src="/js/bootstrap.min.js"></script>
  <script src="/js/bootstrap.js"></script>
  <script src="/js/npm.js"></script>

</head>
<body>
<jsp:include page="include_title.jsp"></jsp:include>
<script>
  function ab(){
    var content=document.getElementById("content").value;
    var rid_id =document.getElementById("rid_id").value;
    jQuery.ajax({
      type:"POST",
      data:{"contents":content,"rid_id":rid_id},
      url:"/Forum_a/add.do",
      dataType:'json',
      async:true,
      success : function(msg) {
        alert("aaaaaa");
      },
    });
  }
</script>
<div style="margin-left: 5%;margin-right: 5%">
<div class="panel panel-default">
<div class="panel-heading">
  <h3 class="panel-title">${query_title}</h3>
</div>
  <!--这里就是循环的地方-->
    <div class="panel-body">

      <t:forEach items="${query_content}" var="st">
          <div class="row">
              <div class="col-md-1"><img src="/img_person/chuyin1.jpg" width="60px" height="50px"><br>${st.person_id}</div>

              <div class="col-md-10" style="margin-left: 8%" >&nbsp;&nbsp;${st.content}<hr></div>
          </div>
      </t:forEach>
    </div>
  </div>
</div>
<div style="margin-left: 5%;margin-right: 5%">
  <div>
    <label class="control-label">内容:</label>
  </div>
<form class="form-horizontal" onsubmit="ab();">

  <input type="hidden" name="rid_id" id="rid_id" value="${query_id}"/>
  <%--<div>--%>
    <%--<label class="control-label">内容:</label>--%>
  <%--</div>--%>
  <div class="form-group">
      <div class="col-sm-10">
      <textarea class="form-control" name="content" id="content" rows="3"></textarea>
      </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">发表中</button>
    </div>
  </div>
</form>
</div>
</body>
</html>

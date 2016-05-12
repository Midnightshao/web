<%--
  Created by IntelliJ IDEA.
  User: guanghaoshao
  Date: 15/12/24
  Time: 上午9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Bootstrap -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>

<script src="//cdn.bootcss.co=m/respond.js/1.4.2/respond.min.js"></script>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/npm.js"></script>

<head>
    <title>论坛标题</title>
</head>
<body>
<script>
  function bd(){
    var sh=document.getElementById("game").value;
    if(sh=="true"){
        return true;
    }
    else if(sh=="false"){
        alert("您没登录")
        return false;
    }
        return false;
  }
</script>
<jsp:include page="include_title.jsp"></jsp:include>
<ol class="breadcrumb" style="margin-top: -10px">
  <li><a href="/">主页</a></li>
  <li><a href="#">这里</a></li>
</ol>
<div class="row">
  <div class="col-sm-9" style="margin-left: 1%">

    <div class="panel panel-default">
        <!--这里就是循环的地方-->
      <div class="panel-heading">
        <h3 class="panel-title">java 论坛稍微记录一下待定</h3>
      </div>

           <div class="panel-body">
              <t:forEach items="${server}" var="st">
                <li style="list-style: none;text-align: left;margin-left: 3%" ><a href="/Forum_a/query/${st.id}"><h5>${st.title}</h5></a></li>
                <hr>
              </t:forEach>
          </div>
    </div>
    <!--这里是要添加的分页-->
    <nav>
      <ul class="pagination">
        <li class="${shangyiye}">
          <a href="/ForumControl/${yeshu-1}" aria-label="Previous">
            <span aria-hidden="true" >&laquo;</span>
          </a>
        </li>
        <li class="${first}"><a href="/ForumControl/1">1</a></li>
        <li class="${first}"><a>......</a></li>
        <t:forEach items="${fenye}" var="tr">
          <li class="${tr.checked}"><a href="${tr.title}">${tr.address}</a></li>
        </t:forEach>
        <li class="${last}"><a>....</a></li>
        <li class="${last}"><a href="/ForumControl/${yema}">${yema}</a></li>
        <li class="${xiayiye}">
          <a href="/ForumControl/${yeshu+1}" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </ul>
    </nav>
    <input type="hidden" id="game" value="${shuru}"/>
    <form class="form-horizontal" action="/ForumControl/add" method="post" onsubmit="bd();">
      <div class="form-group">
        <label class="col-sm-2 control-label">标题:</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" name="title" placeholder="Text input">
          </div>
      </div>

      <div class="form-group">
        <label  class="col-sm-2 control-label">内容:</label>
          <div class="col-sm-10">
            <textarea class="form-control" name="content" rows="3"></textarea>
          </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">发表中</button>
        </div>
      </div>
    </form>
  </div>
  <div class="col-sm-3" style="margin-left: -1.8%">
         <span class="hidden-xs">
           <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title">论坛</h3>
              </div>
              <!--这里就是循环的地方-->
              <div class="row">
                <div class="panel-body" style="padding: 10%">
                    <center>
                      <li style="list-style: none">开心就好</li>
                    </center>
                </div>
              </div>
            </div>
             <div class="panel panel-default">
              <div class="panel-heading">
                   <h3 class="panel-title">论坛</h3>
              </div>
                            <!--这里就是循环的地方-->
              <div class="row">
                <div class="panel-body" style="padding: 10%">
                   <center>
                      <li style="list-style: none">开心就好</li>
                   </center>
                </div>
              </div>
           </div>
          </span>
  </div>
</div>
</body>
</html>

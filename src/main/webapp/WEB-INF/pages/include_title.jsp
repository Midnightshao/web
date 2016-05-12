<%--
  Created by IntelliJ IDEA.
  User: guanghaoshao
  Date: 16/1/3
  Time: 下午5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Insert title here</title>
  <!-- Bootstrap -->
<script>
  function MyAutoRun(){
    var d=document.getElementById("name").value;
    if(d!=""){
      document.getElementById("names").style.display="none"
      document.getElementById("nameid").style.display="block"
    }else{
      document.getElementById("names").style.display="block"
      document.getElementById("nameid").style.display="none"
    }
  }
  window.onload=MyAutoRun;
</script>
<script>
  function ab(c) {
    var abc = new Array("activity1", "activity2", "activity3");
    for(var i=0;i<3;i++){
      if(i==c){
        document.getElementById(abc[i]).className="active";
      }else {
        document.getElementById(abc[i]).className="";
      }
    }
  }
</script>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li   id="activity1"><a href="#" onclick="ab(0);" >代码 <span class="sr-only-focusable"></span></a></li>
        <li   id="activity2"><a href="#" onclick="ab(1);" >动漫 <span class="sr-only-focusable"></span></a></li>
        <li   id="activity3"><a href="#" onclick="ab(2);" >音乐 <span class="sr-only-focusable"></span></a></li>
      </ul>
      <input type="hidden" id="name" value="${name}"/>

      <ul class="nav navbar-nav navbar-right" id="names">
        <li><a href="/hello">登陆</a></li>
        <li style="margin-top: 12%">|</li>
        <li><a href="/hello/register">注册</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right" id="nameid" style="display: none">
        <li><a href="/person/peronzone">${name}</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Insert title here</title>
  <script src="/js/jquery-1.8.0.js"></script>
  <script src="/js/jquery-1.8.0.min.js"></script>
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- 可选的Bootstrap主题文件（一般不用引入） -->
  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <%--<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>--%>

  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

</head>

<body>
<script>
  function login(){
    var username=document.getElementById("inputEmail3").value;
    jQuery.ajax({
      type:"POST",
      data:"name="+username,
      url:"/hello/panduan.do",
      dataType:'json',
      async:true,
      success : function(msg) {
        document.getElementById("yonghu").innerHTML=msg.String;
      },
       error : function(){
         alert("网络不通");
       }
    });
  }
  function ab(){
    var a=document.getElementById("inputPassword3").value;
    var b=document.getElementById("inputPassword4").value;
    var c=document.getElementById("inputEmail3").value;
    var d=document.getElementById("inputEmail5").value;
    if(c==""){
      alert("用户名不能为空");
      return false;
    }
    if(a==""){
      alert("密码不能为空")
      return false;
    }
    if(b==""){
      alert("确认密码不能为空")
      return false;
    }
    if(d==""){

    }
    if(a!=b){
      alert("两次写入不正确");
      return false;
    }
      return true;
  }
  function cd(){

  }
</script>
<div style="margin: 15%">
<form class="form-horizontal" action="/hello/register_add" method="post"  onsubmit="return ab();">
  <div class="form-group">

    <label for="inputEmail3" class="col-sm-2 control-label">邮箱：</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="name" onblur="login()">
    </div>
  </div>
  <div class="form-group">

    <label for="inputEmail3" class="col-sm-2 control-label">昵称：</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail5" placeholder="昵称" name="nicheng">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">确认密码：</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div >
        <label id="yonghu">
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">注 册</button>
    </div>
  </div>
</form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: guanghaoshao
  Date: 16/2/29
  Time: 下午7:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>Bootstrap 101 Template</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
  <%--<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->--%>
  <%--<!--[if lt IE 9]>--%>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/npm.js"></script>

</head>
<body>
<script>
  function yanzheng(){
  var ini=document.getElementById("age").value;
    var reg = new RegExp("^[0-9]*$");
    if(!reg.test(ini)){
      alert("请输入数字");
      return false;
    }
    return true;
  }
</script>
  <form style="margin: 1%" action="/person/add_person" method="post" onsubmit="return yanzheng();" enctype="multipart/form-data">
  <div class="form-group">
    <label for="EXAMPLEINPUTFILE">昵称</label>
    <input type="text" class="form-control" placeholder="标题" value="${person_name}" name="name"></div>
    <div class="form-group">
    <label for="EXAMPLEINPUTFILE">年龄</label>
    <input type="text" class="form-control" placeholder="年龄" id="age" value="${person_age}"  name="age"></div>
    <div class="form-group">
      <label for="EXAMPLEINPUTFILE">城市</label>
      <input type="text" class="form-control" placeholder="城市" value="${person_city}" name="city"></div>
  <div class="form-group">
    <label for="EXAMPLEINPUTFILE">输入座右铭</label>
    <textarea class="form-control" rows="3" name="content" >${person_content}</textarea></div>
  <div class="form-group">
    <label for="exampleInputFile">可以传照片</label>
    <input type="file" id="exampleInputFile" name="file" value="${picture_img}"  content="${picture_img}"/>
    <!--<p class="help-block">Example block-level help text here.</p>-->
  </div>
  <button type="submit" class="btn btn-default">提交</button>
  </form>
</body>
</html>

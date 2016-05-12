<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body  style="background-color:#666">
	<Center>
		<Label>这个是后台登陆</Label>
		<form action="/login/login" method="post" style="margin-top:20%;background-color:#999;width:auto;padding:10%" >
			姓名:<input type="text" name="username"><br>
			密码:<input type="password" name="password"><br>
          
            <input type="submit" value="确定" style="background-color:#06F;margin:10px;"/>
            <input type="reset" value="重置"	style="background-color:#0F9;margin:10px;"/>
	</form>
	</Center>
</body>
</html>
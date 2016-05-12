
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>成功</h1>
<%
Cookie cookie[]=request.getCookies();
  Cookie cookie1;
  String value=null;
  String name=null;
  for(int i=0;i<cookie.length-1;i++){
    cookie1=cookie[i];
    value=cookie1.getValue();
    %>
  <%=value
  %>
  <%
  System.out.println();
  %>
  <%
    name=cookie1.getName();
  %>
  <%=name%>
  <%
    System.out.println();
  %>
<%}%>
</body>
</html>

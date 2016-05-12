<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c" %>
<%@ taglib prefix="q" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
    <!-- Bootstrap -->
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
                    <li><a href="hello">登陆</a></li>
                    <li style="margin-top: 12%">|</li>

                    <li><a href="/hello/register">注册</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" id="nameid" style="display: none">
                <%--<c:form id="_form" method="post" action="">--%>
                    <li><a>${name}</a></li>
                <%--</c:form>--%>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">

    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <%--<!-- Indicators -->--%>
        <%--&lt;%&ndash;<ol class="carousel-indicators">&ndash;%&gt;--%>

            <%--&lt;%&ndash;<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<t:forEach items="${contact_picture}" var="st">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li data-target="#carousel-example-generic" data-slide-to="1"></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li data-target="#carousel-example-generic" data-slide-to="2"></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</t:forEach>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</ol>&ndash;%&gt;--%>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">

                <div class="item active">
                        <img src="/img/${contact_picture_first}">
                </div>
            <t:forEach items="${contact_picture}" var="st">
                    <div class="item">
                        <img src="/img/${st.img_picture}">
                    </div>
                </t:forEach>
            </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
        </div>
    </div>
</div>
    <div class="visible-xs-block container" style="margin-top: 5%">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="false">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingTwo">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse"data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            点击查看
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <table border="1" width="100%" style="border:#d5d5d5;" >
                            <tr>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><a href="/luntan"><h4>java</h4></a></td>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>php</h4></td>
                            </tr>
                            <tr>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>jsp</h4></td>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>html</h4></td>
                            </tr>
                            <tr>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>go</h4></td>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>JavaScript</h4></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container" style="margin-top: 3%">
    <div class="row">
        <div class="col-md-9 col-sm-9">

            <div class="panel panel-default">

                <div class="panel-heading">
                    <h3 class="panel-title">论坛</h3>
                </div>
                <t:forEach items="${contact}" var="st">
                <!--这里就是循环的地方-->
                     <div class="row">
                         <div class="panel-body" style="padding: 5%">
                            <div>
                                <li style="list-style: none;"><h2>${st.title} </h2></li>
                                <li style="list-style: none;">
                                    <img src="img/${st.img_type}" style="width:100%;height: auto">
                                </li><br>
                                    <li style="list-style: none">${st.content}</li>
                                <div>
                                </div>
                            </div>
                         <hr/>
                </div>
            </div>
                </t:forEach>
         </div>
        </div>
        <%--<td><a href="/luntan">java</a></td>--%>
        <div class="col-md-3 col-sm-3">
            <span class="hidden-xs">
                <div>

                    <!--这里就是循环的地方-->
                    <div class="list-group">
                        <a href="#" class="list-group-item disabled">fd</a>
                        <table border="1" width="100%" style="border:#d5d5d5;" >
                            <tr>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><a href="/luntan"><h4>java</h4></a></td>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>php</h4></td>
                            </tr>
                            <tr>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>jsp</h4></td>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>html</h4></td>
                            </tr>
                            <tr>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>go</h4></td>
                                <td width="150" style="vertical-align:middle; text-align:center;word-break:break-all"><h4>JavaScript</h4></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </span>
        </div>
    </div>
</div>
</body>
</html>
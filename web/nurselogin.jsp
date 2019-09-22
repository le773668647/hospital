<%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 19-6-26
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"
                +request.getServerName()+":"+request.getServerPort()
                +path+"/";
    %>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <base href="<%=basePath%>">
    <title>管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="validate/js/jquery-1.11.3.min.js" ></script>
    <script type="text/javascript" src="validate/js/additional-methods.min.js" ></script>
    <script type="text/javascript" src="validate/js/jquery.metadata.js" ></script>
    <script type="text/javascript" src="validate/js/jquery.validate.min.js" ></script>
    <script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
    <script type="text/javascript" src="validate/login.js"></script>
</head>
<body style="background-color: #E2E2E2;">
<% Object message=request.getAttribute("result");
    if (message!=null&&!"".equals(message))
    {

%>

<script language="JavaScript">
    alert("<%=message%>")
</script>
<%}%>
<div class="container">
    <div class="row text-center " style="padding-top:100px;">
        <div class="col-md-12">
            <h2>护士登陆</h2>
        </div>
    </div>
    <div class="row ">

        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div class="panel-body">
                <form id="loginForm" action="<%=basePath%>NurseLogin" method="post">
                    <hr />
                    <h5>输入登陆信息</h5>
                    <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-user"  ></i></span>
                        <input type="text" class="form-control" id="aid" name="aid" placeholder="工号 " />
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                        <input type="password" class="form-control" id="password" name="password" placeholder="密码" />
                    </div>

                    <button type="button" class="btn btn-primary col-md-offset-7" onclick="check()">登录</button>
                    <hr />
                </form>
            </div>

        </div>
    </div>
</div>
<script language="javascript">
    function check() {
        var id=document.getElementById("aid").value;
        // alert(id);
        var password=document.getElementById("password").value;
        if(id!=""){
            if(password!=""){
                document.getElementById("loginForm").submit();
            }else {
                alert("输入密码");
            }

        }else{
            alert("请输入用户名");
        }
    }


</script>
</body>
</html>


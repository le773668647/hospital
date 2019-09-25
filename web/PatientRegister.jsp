<%@ page import="cn.zz.getMessage.PhoneCode" %><%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 19-6-27
  Time: 下午3:13
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
    <title>患者注册</title>
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
<div class="container">
    <div class="row text-center " style="padding-top:100px;">
        <div class="col-md-12">
            <h2>患者注册</h2>
        </div>
    </div>
    <div class="row ">

        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div class="panel-body">
                <form id="loginForm" action="<%=basePath%>PatientRegister" method="post">
                    <hr />
                    <h5>填写注册信息</h5>
                    <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon" ><i class="fa "></i></span>
                        <input type="text" placeholder="请输入手机号码" id="mobile" name="phone_user"/>
                        <jsp:useBean id="GetMessage" class="cn.zz.getMessage.PhoneCode"  ></jsp:useBean>
                        <%--<input type="button" onclick="second60();<%PhoneCode.getPhonemsg("13948831040");%>" id="getyanzhengma" value="获取验证码" >--%>
                        <input type="button" onclick="second60();sel()" id="getyanzhengma" value="获取验证码" />
                        <input type="text" id="ajaxdata" hidden/>
                        <script language="JavaScript">
                            function check() {
                                var code=document.getElementById("yanzhengma").value;
                                var result=document.getElementById("ajaxdata").value;
                                // alert(code);
                                // alert(result);
                                if (code==result) {
                                       alert("正确")
                                    $("#yanzheng").val("验证通过");
                                    $("#yanzheng").attr("disabled","disabled");
                                }else {
                                    alert("验证码错误，重新输入");
                                }
                            }
                        </script>
                        
                        <script language="javascript">
                        function sel(){

                        var mobile=document.getElementById("mobile").value;
                        alert(mobile);
                         $.ajax({
                             url:"/PhoneCode",
                             type:"post",
                             // async:false,
                             data:{
                                 "mobile":mobile
                             },
                             success:function (data) {
                                 $("#ajaxdata").val(data);
                                 // alert(data);
                                 
                             }
                         })

                        }

                        </script>
                        <%--<script language="javascript">--%>

                            <%--function sel(){--%>

                                <%--document.getElementById("mobile").value();--%>

                            <%--}--%>

                        <%--</script>--%>
                        <script type="text/javascript" >
                            var timer;
                            var count = 60;
                            function second60() {
                                count--;
                                $("#getyanzhengma").val(count + "s再次获取");
                                if (count == 0) {
                                    $("#getyanzhengma").removeAttr("disabled");
                                    clearTimeout(timer);
                                    count = 60;
                                    $("#getyanzhengma").val("点击获取验证码");
                                    $("#getyanzhengma").removeClass("disabled");
                                }
                                else {
                                    $("#getyanzhengma").addClass("disabled");
                                    $("#yanzhengma").removeAttr("disabled");
                                    $("#getyanzhengma").attr("disabled", "disabled");
                                    timer = setTimeout("second60()", 1000);
                                }
                            }
                        </script>

                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa "  ></i></span>
                        <input type="text"  id="yanzhengma" name="yanzhengma" placeholder="验证码 " />
                        <input type="button" value="验证" onclick="check()" id="yanzheng"/>
                    </div>
                    <div class="form-group input-group" >
                        <span class="input-group-addon"><i class="fa "  ></i></span>
                        <input type="password" class="form-control" id="password" name="password" placeholder="密码 " />
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa "  ></i></span>
                        <input type="password" class="form-control" id="repassword" name="repassword" placeholder="确认密码" />
                    </div>

                    <%--<button type="submit" class="btn btn-primary col-md-offset-7" onclick="lastcheck()">注册</button>--%>
                    <input type="button" class="btn btn-primary col-md-offset-7"  value="注册" onclick="lastcheck()"/>

                    <script language="javascript">
                        function lastcheck() {
                            // alert("点击有效");
                            var passwd=document.getElementById("password").value;
                            // alert(passwd);
                            var repasswd=document.getElementById("repassword").value;
                            // alert(repasswd);
                            var mobile=document.getElementById("mobile").value;
                            // alert(mobile);
                            var rs=document.getElementById("yanzheng").disabled;
                            // alert(rs);
                            if(mobile!=""){
                               if(rs){
                                   if(passwd!=""&&repasswd!=""){
                                       if(passwd==repasswd){
                                           document.getElementById("loginForm").submit();

                                       }else{
                                           alert("两次输入密码不同,重新输入");
                                       }


                                   }else{
                                       alert("输入密码并且确认密码");

                                   }

                               }else{
                                   alert("请验证");
                               }
                            }else{
                                alert("输入手机号");
                            }

                        }

                    </script>
                    <hr/>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>


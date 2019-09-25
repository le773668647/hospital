<%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 19-7-6
  Time: 下午2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
    System.out.println(basePath);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>患者</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">患者</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="patient.jsp">患者</a>
        </div>
        <!--顶部-->
        <div class="header-right">
            <a href="patientlogin.jsp" class="btn btn-danger" title="Logout"> 退出系统</a>
        </div>
    </nav>
    <!-- 导航 -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <div class="user-img-div">
                        <img src="assets/img/user.png" class="img-thumbnail" />

                        <div class="inner-text">
                            当前用户:<c:if test="${user != null}">
                            ${user}
                        </c:if>
                            <br />

                        </div>
                    </div>
                </li>

                <li>
                    <a class="active-menu" href="patient.jsp"><i class="fa fa-dashboard "></i>导航</a>
                </li>
                <!--用户信息-->
                <% Object message=request.getAttribute("result");
                    if (message!=null&&!"".equals(message))
                    {

                %>

                <script language="JavaScript">
                    alert("<%=message%>")
                </script>
                <%}%>
                <li >
                    <a ><i class="fa fa-desktop" ></i>我要挂号<span class="fa arrow" onclick="click()"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="patientguahao.jsp"><i class="fa fa-toggle-on"></i>挂号预约</a>
                        </li>
                        <li>
                            <a href="patientchakanguahao.jsp"><i class="fa fa-toggle-on"></i>查看预约</a>
                        </li>
                    </ul>
                </li>

                <!--分类信息-->
                <li>
                    <a ><i class="fa fa-desktop "></i>我要缴费<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="pay.jsp"><i class="fa fa-toggle-on"></i>缴费</a>
                        </li>

                    </ul>
                </li>

            </ul>
        </div>
    </nav>

    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner" >
            <%--编写数据增加表单--%>

                <div class="col-md-12"  id="div">
                    <div class="col-md-6 col-md-offset-4">
                        <h1 class="h1">挂号预约</h1>
                    </div>
                    <div class="col-md-12">
                        <hr>
                    </div>
                </div>
                <%--编写数据增加表单--%>
                <form action="<%=basePath%>PatientG" method="post" class="form-horizontal" id="guahao">
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">身份证后6位</label>
                        <div class="col-md-6">
                            <input type="text" name="id" id="id" class="form-control input-sm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">姓名</label>
                        <div class="col-md-6">
                            <input type="text" name="name" id="name" class="form-control input-sm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">年龄</label>
                        <div class="col-md-6">
                            <input type="text" name="age" id="age" class="form-control input-sm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">电话</label>
                        <div class="col-md-6">
                            <input type="text" name="mobile" id="mobile" class="form-control input-sm">
                        </div>
                    </div>
                        <%--aid--%>
                    <div class="form-group">
                            <label  class="col-md-3 control-label">性别</label>
                            <div class="col-md-6">
                                <select class="form-control"id="sex" name="sex" >
                                        <option value="1">男</option>
                                        <option value="0">女</option>
                                </select>
                            </div>
                        </div>
                        <%--iid--%>
                    <div class="form-group">
                            <label class="col-md-3 control-label">科室</label>
                            <div class="col-md-6">
                                <select class="form-control" id="object" name="object">

                                        <option value="1">内科</option>
                                        <option value="2">外科</option>
                                        <option value="3">骨科</option>
                                        <option value="4">儿科</option>

                                </select>
                            </div>
                        </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">时间</label>
                        <div class="col-md-6">
                            <select class="form-control" id="time" name="time">

                                <option value="1">8:00-10:00</option>
                                <option value="2">10:00-12:00</option>
                                <option value="3">14:00-15:30</option>
                                <option value="4">15:30-17:00</option>

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <input type="reset" class="btn btn-success" value="重置"/>
                            <input type="submit" class="btn btn-success" value="提交"/>
                        </div>
                    </div>
                </form>



        </div>



    </div>
</div>
</div>


<jsp:include page="pages/back/footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>
</body>
</html>



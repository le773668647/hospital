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
            + path ;
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
                        <%--<li>--%>
                            <%--<a href="/pages/back/ItemServlet/list"><i class="fa fa-flash "></i>列表分类</a>--%>
                        <%--</li>--%>
                    </ul>
                </li>
                <!--图书信息-->
                <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-yelp "></i>个人信息 <span class="fa arrow"></span></a>--%>
                    <%--<ul class="nav nav-second-level">--%>
                        <%--<li>--%>
                            <%--<a href="/pages/back/books/BooksServlet/insertPro"><i class="fa fa-coffee"></i>增加图书</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="/pages/back/books/BooksServlet/listSplit"><i class="fa fa-flash "></i>图书列表</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <!--借书登记-->
                <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-bicycle "></i>借书登记 <span class="fa arrow"></span></a>--%>
                    <%--<ul class="nav nav-second-level">--%>
                        <%--<li>--%>
                            <%--&lt;%&ndash;<a href="/pages/back/lenbook/LenbookServlet/insertPro"><i class="fa fa-desktop "></i>借书信息录入 </a>&ndash;%&gt;--%>
                            <%--<a href="/pages/back/lenbook/lenbook_insert.jsp"><i class="fa fa-desktop "></i>借书信息录入 </a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="/pages/back/lenbook/LenbookServlet/listSplit"><i class="fa fa-desktop "></i>借书信息列表 </a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            </ul>
        </div>
    </nav>

    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner" >
            <%--编写数据增加表单--%>
            <%--<div hidden="hidden" id="hideen1">--%>
                <%--<div class="col-md-12"  id="div">--%>
                    <%--<div class="col-md-6 col-md-offset-4">--%>
                        <%--<h1 class="h1">增加图书操作</h1>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-12">--%>
                        <%--<hr>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--&lt;%&ndash;编写数据增加表单&ndash;%&gt;--%>
                <%--<form action="<%=basePath%>pages/back/books/BooksServlet/insert" method="post" class="form-horizontal" id="insertForm">--%>
                    <%--&lt;%&ndash;图书名称&ndash;%&gt;--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="name" class="col-md-3 control-label">图书名称</label>--%>
                        <%--<div class="col-md-6">--%>
                            <%--<input type="text" name="name" id="name" class="form-control input-sm">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<c:if test="${allAdmins != null}">--%>
                        <%--&lt;%&ndash;aid&ndash;%&gt;--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="aid" class="col-md-3 control-label">管理员ID</label>--%>
                            <%--<div class="col-md-6">--%>
                                <%--<select class="form-control"id="aid" name="aid">--%>
                                    <%--<c:forEach items="${allAdmins}" var="admin">--%>
                                        <%--<option value="${admin.aid}">${admin.aid}</option>--%>
                                    <%--</c:forEach>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</c:if>--%>

                    <%--<c:if test="${allItems != null}">--%>
                        <%--&lt;%&ndash;iid&ndash;%&gt;--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="iid" class="col-md-3 control-label">分类名称</label>--%>
                            <%--<div class="col-md-6">--%>
                                <%--<select class="form-control"id="iid" name="iid">--%>
                                    <%--<c:forEach items="${allItems}" var="item">--%>
                                        <%--<option value="${item.iid}">${item.name}</option>--%>
                                    <%--</c:forEach>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</c:if>--%>

                    <%--<!--内容简介-->--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="note" class="col-md-3 control-label">内容简介</label>--%>
                        <%--<div class="col-md-6">--%>
                            <%--<textarea name="note" id="note" class="form-control"></textarea>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <%--<div class="form-group">--%>
                        <%--<div class="col-md-5 col-md-offset-3">--%>
                            <%--<button type="submit" class="btn btn-success c">提交</button>--%>
                            <%--<button type="reset" class="btn btn-success">重置</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</form>--%>

            <%--</div>--%>

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


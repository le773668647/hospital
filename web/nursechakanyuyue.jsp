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
    <title>护士</title>
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
                <span class="sr-only">护士</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="nurse.jsp">护士</a>
        </div>
        <!--顶部-->
        <div class="header-right">
            <a href="nurselogin.jsp" class="btn btn-danger" title="Logout"> 退出系统</a>
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
                            当前护士:<c:if test="${user != null}">
                            ${user}
                        </c:if>
                            <br />

                        </div>
                    </div>
                </li>

                <li>
                    <a class="active-menu" href="nurse.jsp"><i class="fa fa-dashboard "></i>导航</a>
                </li>
                <!--用户信息-->
                <li >
                    <a ><i class="fa fa-desktop" ></i>就诊辅助<span class="fa arrow" ></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="rightnow.jsp"><i class="fa fa-toggle-on"></i>当前情况</a>
                        </li>
                        <li>
                            <a href="nursechakanyuyue.jsp"><i class="fa fa-toggle-on"></i>查看预约</a>
                        </li>
                    </ul>
                </li>

                <!--分类信息-->
                <li>
                    <a ><i class="fa fa-desktop "></i>治疗<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="yaofangzhenshi.jsp"><i class="fa fa-toggle-on"></i>药房/诊室</a>
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


<%@ page import="cn.zz.book.vo.Chufang" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.zz.book.dbc.DatabaseConnection" %>
<%@ page import="cn.zz.book.DAO.impl.ChufangImpl" %>
<%@ page import="java.sql.SQLException" %><%--
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
            + path+"/" ;
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
                    <a ><i class="fa fa-desktop" ></i>我要挂号<span class="fa arrow"></span></a>
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
                <form id="chakanguahaoform" method="post" action="<%=basePath%>BeforePay">
                    <input type="submit" value="刷新" class="btn btn-primary"/>
                    <table class="table table-border">
                        <tr>
                            <th>编号</th>
                            <th>名字</th>
                            <th>数量</th>
                            <th>状态</th>
                            <th></th>
                        </tr>
                        <% Object list=request.getAttribute("list");
                            ArrayList<Chufang> arrayList=null;
                            if (list!=null&&!"".equals(list))
                            {     arrayList=(ArrayList) list;
//                                System.out.println(arrayList.get(0));
                        %>
                        <%for(int i=0;i<arrayList.size();i++){
                            System.out.println("xxx");
                        %>
                        <tr>
                            <td><%=arrayList.get(i).getId()%></td>
                            <td><%=arrayList.get(i).getMedicinename()%></td>
                            <td><%=arrayList.get(i).getAmount()%></td>
                            <td><%=arrayList.get(i).getStatus()%></td>
                        </tr>
                        <%}}%>
                    </table>
                </form>

                <form id="pay" action="<%=basePath%>Pay" method="post">
                <input  id="sign" type="text" name="sign" />
                <input type="submit" value="支付" />


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


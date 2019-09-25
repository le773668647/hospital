<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.zz.book.vo.Huanzhe" %><%--
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


<script language="JavaScript">
    // alert("传输成功");
</script>

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

            </ul>
        </div>
    </nav>

    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner" >
            <form id="chakanguahaoform" method="post" action="<%=basePath%>PatientChakanguahao">
                <input type="submit" value="刷新" class="btn btn-primary"/>
            <table class="table table-border">


                    <tr>
                        <th>身份证后六位</th>
                        <th>名字</th>
                        <th>年龄</th>
                        <th>电话</th>
                        <th>性别</th>
                        <th>科室</th>
                        <th>时间</th>
                    </tr>

                <% Object list=request.getAttribute("list");
                    ArrayList<Huanzhe> arrayList=null;
                    if (list!=null&&!"".equals(list))
                    {     arrayList=(ArrayList) list;
//                        System.out.println(arrayList.get(0));

                    %>
                            <%for(int i=0;i<arrayList.size();i++){
                                System.out.println("xxx");
                            %>
                <tr>
                            <td><%=arrayList.get(i).getId()%></td>
                            <td><%=arrayList.get(i).getName()%></td>
                            <td><%=arrayList.get(i).getAge()%></td>
                            <td><%=arrayList.get(i).getMobile()%></td>
                            <td><%=arrayList.get(i).getSex()%></td>
                            <td><%=arrayList.get(i).getObject()%></td>
                            <td><%=arrayList.get(i).getTime()%></td>
                            <td></td>


                        </tr>
                    <%}}%>
                </table>
            </form>
            <div class="col-md-5 col-md-offset-3">
                    <%--<jsp:include page="/pages/split_bar.jsp"></jsp:include>--%>
                </div>

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


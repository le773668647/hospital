<%@ page import="cn.zz.book.vo.Huanzhe" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <title>医生</title>
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
                <span class="sr-only">医生</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="patient.jsp">医生</a>
        </div>
        <!--顶部-->
        <div class="header-right">
            <a href="doctorlogin.jsp" class="btn btn-danger" title="Logout"> 退出系统</a>
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
                            当前医生:<c:if test="${user != null}">
                            ${user}
                        </c:if>
                            <br />

                            <%--当前科室:<c:if test="${object != null}">--%>
                            <%--${object}--%>
                            <%--</c:if>--%>

                        </div>
                    </div>
                </li>

                <li>
                    <a class="active-menu" href="doctor.jsp"><i class="fa fa-dashboard "></i>导航</a>
                </li>
                <!--用户信息-->
                <li >
                    <a ><i class="fa fa-desktop" ></i>我要看病<span class="fa arrow" onclick="click()"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="kanbing.jsp"><i class="fa fa-toggle-on"></i>开始看病</a>
                        </li>
                        <li>
                            <a href="doctoryuyue.jsp"><i class="fa fa-toggle-on"></i>查看预约</a>
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
                    <h1 class="h1">处方</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            <%--编写数据增加表单--%>
            <form action="<%=basePath%>DoctorKanbing" method="post" class="form-horizontal" id="guahao">
                <%----%>
                <input  id="a1" type="submit" class="btn btn-success" value="开始" />
                <input  id="a2" type="submit" class="btn btn-success" value="下一个" />
                    <% Object list=request.getAttribute("list");
                    ArrayList<Huanzhe> arrayList=null;
                    if (list!=null&&!"".equals(list))
                    {     arrayList=(ArrayList) list;
//                        System.out.println(arrayList.get(0));

                    %>

                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">身份证后6位</label>
                    <div class="col-md-6">
                        <input type="text" name="id" id="id" class="form-control input-sm" value="<%=arrayList.get(0).getId()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">姓名</label>
                    <div class="col-md-6">
                        <input type="text" name="name" id="name" class="form-control input-sm" value="<%=arrayList.get(0).getName()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">年龄</label>
                    <div class="col-md-6">
                        <input type="text" name="age" id="age" class="form-control input-sm" value="<%=arrayList.get(0).getAge()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">电话</label>
                    <div class="col-md-6">
                        <input type="text" name="mobile" id="mobile" class="form-control input-sm" value="<%=arrayList.get(0).getMobile()%>">
                    </div>
                </div>
                <%--aid--%>
                <div class="form-group">
                    <label  class="col-md-3 control-label">性别</label>
                    <div class="col-md-6">
                        <input type="text" name="sex" id="sex" class="form-control input-sm" value="<%=arrayList.get(0).getSex()%>">
                    </div>
                </div>
                <%--iid--%>
                <div class="form-group">
                    <label class="col-md-3 control-label">科室</label>
                    <div class="col-md-6">
                        <input type="text" name="object" id="object" class="form-control input-sm" value="<%=arrayList.get(0).getObject()%>">
                    </div>
                </div>

            </form>





        <form action="<%=basePath%>KanbingEnd" method="post" class="form-horizontal" id="guahao">
            <div class="form-group">
                <label class="col-md-3 control-label">编号</label>
                <div class="col-md-6">
                    <input type="text" name="chufangbianhao" id="chufangbianhao" class="form-control input-sm" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">药品</label>
                <div class="col-md-6">
                    <select class="form-control" id="medicine" name="medicine">

                        <option value="1">头孢</option>
                        <option value="2">消食片</option>
                        <option value="3">板蓝根</option>
                        <option value="4">棉签</option>

                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">数量</label>
                <div class="col-md-6">
                    <input type="text" name="amount" id="amount" class="form-control input-sm" >
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-5 col-md-offset-3">

                    <input type="submit" class="btn btn-success" value="提交"/>
                </div>
            </div>
        </form>
                <%}%>

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


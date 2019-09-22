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
  <title>管理系统</title>
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
        <span class="sr-only">管理员</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/pages/index.jsp">管理员</a>
    </div>
    <!--顶部-->
    <div class="header-right">
      <a href="login.jsp" class="btn btn-danger" title="Logout"> 退出系统</a>
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
              管理员: <c:if test="${aid != null}">
              ${aid}
            </c:if>
              <br />
              <small>上次登录日期:
                <c:if test="${lastdate != null}">
                  ${lastdate}
                </c:if>
              </small>
            </div>
          </div>
        </li>

        <li>
          <a class="active-menu" href="/pages/index.jsp"><i class="fa fa-dashboard "></i>导航</a>
        </li>
        <!--用户信息-->
        <li >
          <a ><i class="fa fa-desktop" ></i>预约专区<span class="fa arrow" onclick="click()"></span></a>
          <ul class="nav nav-second-level">
            <li>
              <a href="../adminyuyue.jsp"><i class="fa fa-toggle-on"></i>查看预约</a>
            </li>
          </ul>
        </li>


        <!--图书信息-->
        <li>
        <a><i class="fa fa-yelp "></i>医生专区 <span class="fa arrow"></span></a>
        <ul class="nav nav-second-level">
        <li>
        <a href="../admindoctor.jsp"><i class="fa fa-coffee"></i>医生列表</a>
        </li>
        <li>
        <a href="../admindoctorinsert.jsp"><i class="fa fa-flash "></i>信息录入</a>
        </li>
        </ul>
        </li>
        <!--借书登记-->
        <li>
        <a ><i class="fa fa-bicycle "></i>护士专区 <span class="fa arrow"></span></a>
        <ul class="nav nav-second-level">
        <li>
        <a href="../adminnurse.jsp"><i class="fa fa-desktop "></i>护士列表 </a>
        </li>
        <li>
        <a href="../adminnurseinsert.jsp"><i class="fa fa-desktop "></i>信息录入 </a>
        </li>
        </ul>
        </li>
        <li>
          <a ><i class="fa fa-bicycle "></i>药品专区 <span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li>
              <a href="../adminmidicine.jsp"><i class="fa fa-desktop "></i>药品列表 </a>
            </li>
            <li>
              <a href="../adminmidicineinsert.jsp"><i class="fa fa-desktop "></i>信息录入 </a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>

  <!-- 此处编写内容  -->
  <div id="page-wrapper">
    <div id="page-inner">
    <%--编写数据增加表单--%>


    </form>
</div>



</div>
</div>
</div>


<jsp:include page="back/footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>
</body>
</html>

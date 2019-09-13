package cn.zz.book.servlet;

import cn.zz.book.vo.Admin;
import cn.zz.book.factory.ServiceFactory;
import cn.zz.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet",urlPatterns = "/pages/back/AdminServlet/*")
public class AdminServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp";//定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        System.out.println(status);
        if(status != null){
            if("login".equals(status)){
                path = this.login(request);
            }
        }

        request.getRequestDispatcher(path).forward(request,response);
    }
    public String login(HttpServletRequest request) {
        String msg = "";//表示提示信息
        String url = "";//表示跳转路径
        //取得页面中传递过来的数据
        String aid = request.getParameter("aid");
//        System.out.println(aid);
        String password = request.getParameter("password");
//        System.out.println(password);

        //判断数据是否为空
        if(ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(password)){//表示数据存在
//            System.out.println(ValidateUtils.validateEmpty(password));

            Admin vo = new Admin();
            vo.setAid(aid);//取得参数
//            System.out.println(aid);
//            vo.setPassword(new MD5Code().getMD5ofStr(password+aid));//需要加盐处理
            vo.setPassword(password);
            //System.out.println(vo.getPassword());//用于测试输出加盐密码
            try{
//                System.out.println(ServiceFactory.getIAdminServiceInstance().login(vo));
                if(ServiceFactory.getIAdminServiceInstance().login(vo)) {
                    request.getSession().setAttribute("aid",aid);//保存aid

                    request.getSession().setAttribute("lastdate",vo.getLastdate());
                    msg = "登录成功";
                    url = "/pages/index.jsp";
                }else{
                    msg = "登录失败，错误的ID或密码";
                    url = "/login.jsp";
                }
                }catch (Exception e){
                e.printStackTrace();
            }

            }

        else{
            msg = "数据不能为空";
            url = "/kong.jsp";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";

        }
}

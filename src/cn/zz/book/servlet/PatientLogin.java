package cn.zz.book.servlet;

import cn.zz.book.DAO.impl.PatientRegisterImpl;
import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.vo.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-05 下午3:22
 */
@WebServlet(name ="PatientLogin",urlPatterns = "/PatientLogin/*")
public class PatientLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result="";
        String url="";
        String mobile=req.getParameter("aid");
     String password=req.getParameter("password");
        Patient patient=new Patient();
        patient.setPhonenum(mobile);
        System.out.println(patient.getPhonenum());
        patient.setPassword(password);
        System.out.println(patient.getPassword());
        DatabaseConnection databaseConnection=new DatabaseConnection();
        PatientRegisterImpl patientRegister=new PatientRegisterImpl(databaseConnection.getConn());
        try {
//            PrintWriter out=resp.getWriter();
              boolean judge=patientRegister.search(patient);
            System.out.println(judge);
            if (judge){
//                out.print("登陆成功");
                result="登陆成功";
                url="shouye.jsp";
              req.setAttribute("result",result);
              req.setAttribute("url",url);
              req.setAttribute("mobile",patient.getPhonenum());
              resp.sendRedirect("/patient.jsp");
              req.getSession().setAttribute("user",patient.getPhonenum());//保存号码
            }else{
                result="登录失败：用户名或密码错误";
                req.setAttribute("result",result);
                req.getRequestDispatcher("/patientlogin.jsp").forward(req,resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }

    }
}

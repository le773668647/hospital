package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.DoctorImpl;
import cn.ylcto.book.DAO.impl.PatientRegisterImpl;
import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.vo.Doctor;
import cn.ylcto.book.vo.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-09 上午9:20
 */
@WebServlet(name = "DoctorLogin",urlPatterns = "/DoctorLogin/*")
public class DoctorLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result="";
        String url="";
        String id=req.getParameter("aid");
        String password=req.getParameter("password");
        Doctor doctor=new Doctor();
        doctor.setId(id);
        System.out.println(doctor.getId());
        doctor.setPassword(password);
        System.out.println(doctor.getPassword());
        DatabaseConnection databaseConnection=new DatabaseConnection();
        DoctorImpl doctor1=new DoctorImpl(databaseConnection.getConn());
        try {
//            PrintWriter out=resp.getWriter();
            boolean judge=doctor1.login(doctor);
            System.out.println(judge);
            if (judge){
//                out.print("登陆成功");
                result="登陆成功";
                url="admindoctor.jsp";
                req.setAttribute("result",result);
                req.setAttribute("url",url);
                req.setAttribute("id",doctor.getId());

                req.getSession().setAttribute("user",doctor.getId());//保存号码
                req.getSession().setAttribute("object",doctor.getObject());//待完善
                resp.sendRedirect("/doctor.jsp");
            }else{
                result="登录失败：用户名或密码错误";
                req.setAttribute("result",result);
                req.getRequestDispatcher("/doctorlogin.jsp").forward(req,resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
    }
}

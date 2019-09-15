package cn.zz.book.servlet;

import cn.zz.book.DAO.impl.NurseImpl;
import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.vo.Nurse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-09 上午11:23
 */
@WebServlet(name = "NurseLogin",urlPatterns = "/NurseLogin/*")
public class NurseLogin extends HttpServlet {
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
        Nurse nurse=new Nurse();
        nurse.setId(id);
        System.out.println(nurse.getId());
        nurse.setPassword(password);
        System.out.println(nurse.getPassword());
        DatabaseConnection databaseConnection=new DatabaseConnection();
        NurseImpl nurse1=new NurseImpl(databaseConnection.getConn());
        try {
//            PrintWriter out=resp.getWriter();
            boolean judge=nurse1.login(nurse);
            System.out.println(judge);
            if (judge){
//                out.print("登陆成功");
                result="登陆成功";
                url="admindoctor.jsp";
                req.setAttribute("result",result);
                req.setAttribute("url",url);
                req.setAttribute("id",nurse.getId());

                req.getSession().setAttribute("user",nurse.getId());//保存号码
                req.getSession().setAttribute("object",nurse.getObject());//待完善
                resp.sendRedirect("/nurse.jsp");
            }else{
                result="登录失败：用户名或密码错误";
                req.setAttribute("result",result);
                req.getRequestDispatcher("/nurselogin.jsp").forward(req,resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
    }
    }


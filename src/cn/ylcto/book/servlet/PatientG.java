package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.HuanzheImpl;
import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.vo.Huanzhe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-07 下午10:08
 */
@WebServlet(name ="PatientG",urlPatterns = "/PatientG/*")
public class PatientG extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Huanzhe huanzhe=new Huanzhe();
        huanzhe.setId(req.getParameter("id"));
        huanzhe.setName(req.getParameter("name"));
        huanzhe.setAge(req.getParameter("age"));
        huanzhe.setMobile(req.getParameter("mobile"));
        huanzhe.setSex(req.getParameter("sex"));
        huanzhe.setObject(req.getParameter("object"));
        huanzhe.setTime(req.getParameter("time"));
        DatabaseConnection databaseConnection=new DatabaseConnection();
        HuanzheImpl huanzhe1=new HuanzheImpl(databaseConnection.getConn());
        try {
            int result=huanzhe1.add(huanzhe);
            if (result>0){
                System.out.println("ok");
                req.setAttribute("result","提交成功");

            }else{
                System.out.println("!ok");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("patientguahao.jsp").forward(req,resp);

    }
}

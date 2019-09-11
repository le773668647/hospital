package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.HuanzheImpl;
import cn.ylcto.book.dbc.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-09 下午5:40
 */
@WebServlet(name = "DoctorKanbing",urlPatterns = "/DoctorKanbing/*")
public class DoctorKanbing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseConnection databaseConnection=new DatabaseConnection();
        HuanzheImpl huanzhe1=new HuanzheImpl(databaseConnection.getConn());
        try {
//            req.getParameter()
            req.setAttribute("list",huanzhe1.search());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("kanbing.jsp").forward(req,resp);
    }

}
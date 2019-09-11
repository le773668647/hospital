package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.DoctorImpl;
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
 * @create 2019-07-09 下午2:33
 */
@WebServlet(name ="AdminChakanDoctor",urlPatterns = "/AdminChakanDoctor/*")
public class AdminChakanDoctor extends HttpServlet

    {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseConnection databaseConnection=new DatabaseConnection();
        DoctorImpl doctor=new DoctorImpl(databaseConnection.getConn());
        try {
            req.setAttribute("list",doctor.search());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("admindoctor.jsp").forward(req,resp);
    }

}

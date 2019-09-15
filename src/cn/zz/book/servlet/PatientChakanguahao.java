package cn.zz.book.servlet;

import cn.zz.book.DAO.impl.HuanzheImpl;
import cn.zz.book.dbc.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-08 上午10:47
 */
@WebServlet(name = "PatientChakanguahao",urlPatterns = "/PatientChakanguahao/*")
public class PatientChakanguahao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseConnection databaseConnection=new DatabaseConnection();
        HuanzheImpl huanzhe1=new HuanzheImpl(databaseConnection.getConn());
        try {
            req.setAttribute("list",huanzhe1.search());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("patientchakanguahao.jsp").forward(req,resp);
    }

}

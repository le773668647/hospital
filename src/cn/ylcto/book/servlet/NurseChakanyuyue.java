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
 * @create 2019-07-10 上午12:12
 */
@WebServlet(name = "NurseChakanyuyue",urlPatterns = "/NurseChakanyuyue/*")
public class NurseChakanyuyue extends HttpServlet {
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
        req.getRequestDispatcher("rightnow.jsp").forward(req,resp);
    }

}

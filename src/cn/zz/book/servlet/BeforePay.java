package cn.zz.book.servlet;

import cn.zz.book.DAO.impl.ChufangImpl;
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
 * @create 2019-07-10 上午1:38
 */
@WebServlet(name = "BeforePay",urlPatterns = "/BeforePay/*")
public class BeforePay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseConnection databaseConnection=new DatabaseConnection();
        ChufangImpl chufang=new ChufangImpl(databaseConnection.getConn());
        try {
            req.setAttribute("list",chufang.search());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("pay.jsp").forward(req,resp);
    }

}

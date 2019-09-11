package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.ChufangImpl;
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
 * @create 2019-07-10 上午12:42
 */
@WebServlet(name ="YaofangZhenshi" ,urlPatterns = "/YaofangZhenshi/*")
public class YaofangZhenshi extends HttpServlet {
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
        req.getRequestDispatcher("yaofangzhenshi.jsp").forward(req,resp);
    }

}

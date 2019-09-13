package cn.zz.book.servlet;

import cn.zz.book.DAO.impl.MedicineImpl;
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
 * @create 2019-07-09 下午3:46
 */
@WebServlet(name = "AdminChakanM",urlPatterns = "/AdminChakanM/*")
public class AdminChakanM extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseConnection databaseConnection=new DatabaseConnection();
        MedicineImpl medicine=new MedicineImpl(databaseConnection.getConn());
        try {
            req.setAttribute("list",medicine.search());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("adminmidicine.jsp").forward(req,resp);
    }

}

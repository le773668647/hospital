package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.ChufangImpl;
import cn.ylcto.book.DAO.impl.PatientRegisterImpl;
import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.vo.Chufang;
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
 * @create 2019-07-10 上午1:22
 */
@WebServlet(name="Pay",urlPatterns="/Pay/*")
public class Pay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("sign");

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ChufangImpl chufang1=new ChufangImpl(databaseConnection.getConn());

        try {
            chufang1.pay(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("/pay.jsp").forward(req, resp);


    }
}

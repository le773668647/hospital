package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.DoctorImpl;
import cn.ylcto.book.DAO.impl.NurseImpl;
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
 * @create 2019-07-09 下午2:43
 */
@WebServlet(name = "AdminChakanNurse",urlPatterns = "/AdminChakanNurse/*")
public class AdminChakanNurse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseConnection databaseConnection=new DatabaseConnection();
        NurseImpl nurse=new NurseImpl(databaseConnection.getConn());
        try {
            req.setAttribute("list",nurse.search());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("adminnurse.jsp").forward(req,resp);
    }

}

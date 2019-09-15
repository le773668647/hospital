package cn.zz.book.servlet;

import cn.zz.book.DAO.impl.PatientRegisterImpl;
import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.vo.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-03 下午9:35
 */
@WebServlet(name="PatientRegister",urlPatterns = "/PatientRegister/*")
public class PatientRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient patient=new Patient();
        patient.setPhonenum(req.getParameter("phone_user"));
        System.out.println(patient.getPhonenum());
        patient.setPassword(req.getParameter("password"));
        DatabaseConnection databaseConnection=new DatabaseConnection();
        PatientRegisterImpl patientRegister=new PatientRegisterImpl(databaseConnection.getConn());
        try {
            patientRegister.add(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("patientlogin.jsp").forward(req,resp);


    }

    public void register(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {

    }

}

package cn.zz.book.servlet;

import cn.zz.book.DAO.impl.NurseImpl;
import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.vo.Doctor;
import cn.zz.read.Read;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zzzz
 * @create 2019-07-09 上午10:56
 */
@WebServlet(name = "NurseImport",urlPatterns = "/NurseImport/*")
public class NurseImport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getParameter("path");
        String path1=("/home/lz/桌面/");
        System.out.println(path1+path);
        Read read = new Read();
        InputStream inputStream = new FileInputStream(path1+path);
        DatabaseConnection databaseConnection=new DatabaseConnection();
        NurseImpl doctorimpl=new NurseImpl(databaseConnection.getConn());
        List<Doctor> list= read.imports(inputStream);
        System.out.println(list.get(0).getId());

        try {
            for (int i=0;i<list.size();i++){
                int a=doctorimpl.add(list.get(i));
                System.out.println(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("adminnurse.jsp").forward(req,resp);
    }
    }


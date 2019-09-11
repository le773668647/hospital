package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.MedicineImpl;
import cn.ylcto.book.DAO.impl.NurseImpl;
import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.vo.Doctor;
import cn.ylcto.book.vo.Medicine;
import cn.ylcto.read.Read;
import cn.ylcto.read.ReadM;

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
 * @create 2019-07-09 下午3:26
 */
@WebServlet(name = "MedicineImport",urlPatterns = "/MedicineImport/*")
public class MedicineImport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getParameter("path");
        String path1=("/home/lz/桌面/");
        System.out.println(path1+path);
        ReadM read = new ReadM();
        InputStream inputStream = new FileInputStream(path1+path);
        DatabaseConnection databaseConnection=new DatabaseConnection();
        MedicineImpl medicine=new MedicineImpl(databaseConnection.getConn());
        List<Medicine> list= read.imports(inputStream);
        System.out.println(list.get(0).getId());

        try {
            for (int i=0;i<list.size();i++){
                int a=medicine.add(list.get(i));
                System.out.println(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("adminmidicine.jsp").forward(req,resp);
    }
}

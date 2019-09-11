package cn.ylcto.book.servlet;

import cn.ylcto.book.DAO.impl.ChufangImpl;
import cn.ylcto.book.DAO.impl.HuanzheImpl;
import cn.ylcto.book.DAO.impl.MedicineImpl;
import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.vo.Chufang;
import cn.ylcto.book.vo.Medicine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-09 下午9:18
 */
@WebServlet(name = "KanbingEnd",urlPatterns = "/KanbingEnd/*")
public class KanbingEnd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("chufangbianhao");
        String medicinename=req.getParameter("medicine");
        String medicinename1=null;
        switch (req.getParameter("medicine")){
            case "1":medicinename1="头孢";break;
            case "2":medicinename1="消食片";break;
            case "3":medicinename1="板蓝根";break;
            case "4":medicinename1="棉签";break;
        }
        String amount=req.getParameter("amount");
        DatabaseConnection databaseConnection=new DatabaseConnection();
        HuanzheImpl huanzhe=new HuanzheImpl(databaseConnection.getConn());
        MedicineImpl medicine=new MedicineImpl(databaseConnection.getConn());
        Medicine medicine1=new Medicine();
        medicine1.setName(medicinename1);
        medicine1.setAmount(amount);
        ChufangImpl chufang=new ChufangImpl(databaseConnection.getConn());
        Chufang chufang1=new Chufang();
        chufang1.setId(id);
        chufang1.setMedicinename(medicinename);
        chufang1.setAmount(amount);
        try {
            chufang.add(chufang1);
            huanzhe.modify(id);
            medicine.down(medicine1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
        req.getRequestDispatcher("/kanbing.jsp").forward(req,resp);
    }
}

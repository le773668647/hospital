package cn.zz.book.DAO.impl;

import cn.zz.book.vo.Medicine;
import cn.zz.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author zzzz
 * @create 2019-07-09 下午3:28
 */
public class MedicineImpl extends AbstractDAOImpl {
    public MedicineImpl(Connection conn) {
        super(conn);
    }
    public int add(Medicine medicine) throws SQLException {
        String sql = "INSERT INTO medicine(id,name,price,amount) VALUES(?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,medicine.getId());
        super.pstmt.setString(2,medicine.getName());
        super.pstmt.setString(3,medicine.getPrice());
        super.pstmt.setString(4,medicine.getAmount());
        return super.pstmt.executeUpdate();
    }

    public ArrayList<Medicine> search() throws SQLException {
        ArrayList<Medicine> arrayList=new ArrayList<>();
        String sql="select id,name,price,amount from medicine ";
        super.pstmt=super.conn.prepareStatement(sql);
        ResultSet resultSet=super.pstmt.executeQuery();
        while(resultSet.next()){
            Medicine medicine=new Medicine();
            medicine.setId(resultSet.getString("id"));
            medicine.setName(resultSet.getString("name"));
            medicine.setPrice(resultSet.getString("price"));
            medicine.setAmount(resultSet.getString("amount"));

//            if (resultSet.getString("sex").equals("1")) {
//                huanzhe.setSex("男");
//            }else{
//                huanzhe.setSex("女");
//            }
//            switch (resultSet.getString("object")){
//                case "1":huanzhe.setObject("内科");break;
//                case "2":huanzhe.setObject("外科");break;
//                case "3":huanzhe.setObject("骨科");break;
//                case "4":huanzhe.setObject("儿科");break;
//            }
//            switch (resultSet.getString("time")){
//                case "1":huanzhe.setTime("8:00-10:00");break;
//                case "2":huanzhe.setTime("10:00-12:00");break;
//                case "3":huanzhe.setTime("14:00-15:30");break;
//                case "4":huanzhe.setTime("15:00-17:00");break;
//            }

            arrayList.add(medicine);
        }

        return arrayList;
    }
    public int down(Medicine medicine) throws SQLException {
        String sql = "update  medicine set amount=amount-? where name=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,medicine.getAmount());
        super.pstmt.setString(2,medicine.getName());
        return super.pstmt.executeUpdate();
    }


}
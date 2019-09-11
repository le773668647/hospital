package cn.zz.book.DAO.impl;

import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.vo.Huanzhe;
import cn.zz.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author zzzz
 * @create 2019-07-07 下午10:41
 */
public class HuanzheImpl extends AbstractDAOImpl {
    public HuanzheImpl(Connection conn) {
        super(conn);
    }
    public int modify(String id) throws SQLException {
        String sql = "update  patient_guahao set status=? where id=?";
        super.pstmt = super.conn.prepareStatement(sql);
        String status="1";
        super.pstmt.setString(1,status);
        super.pstmt.setString(2,id);
        return super.pstmt.executeUpdate();
    }
    public int add(Huanzhe huanzhe) throws SQLException {
        String sql = "INSERT INTO patient_guahao(id,name,age,mobile,sex,object,time) VALUES(?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,huanzhe.getId());
        super.pstmt.setString(2,huanzhe.getName());
        super.pstmt.setString(3,huanzhe.getAge());
        super.pstmt.setString(4,huanzhe.getMobile());
        super.pstmt.setString(5,huanzhe.getSex());
        super.pstmt.setString(6,huanzhe.getObject());
        super.pstmt.setString(7,huanzhe.getTime());
        return super.pstmt.executeUpdate();

    }
    public ArrayList<Huanzhe> search() throws SQLException {
        ArrayList<Huanzhe> arrayList=new ArrayList<>();
        String sql="select * from patient_guahao where status=0";
        super.pstmt=super.conn.prepareStatement(sql);

        ResultSet resultSet=super.pstmt.executeQuery();
        while(resultSet.next()){
            Huanzhe huanzhe=new Huanzhe();
            huanzhe.setId(resultSet.getString("id"));
            huanzhe.setName(resultSet.getString("name"));
            huanzhe.setAge(resultSet.getString("age"));
            huanzhe.setMobile(resultSet.getString("mobile"));
            if (resultSet.getString("sex").equals("1")) {
                huanzhe.setSex("男");
            }else{
                huanzhe.setSex("女");
            }
            if (resultSet.getString("status").equals("1")){
                huanzhe.setStatus("已结束");
            }else{
                huanzhe.setStatus("等待");
            }
            switch (resultSet.getString("object")){
                case "1":huanzhe.setObject("内科");break;
                case "2":huanzhe.setObject("外科");break;
                case "3":huanzhe.setObject("骨科");break;
                case "4":huanzhe.setObject("儿科");break;
            }
            switch (resultSet.getString("time")){
                case "1":huanzhe.setTime("8:00-10:00");break;
                case "2":huanzhe.setTime("10:00-12:00");break;
                case "3":huanzhe.setTime("14:00-15:30");break;
                case "4":huanzhe.setTime("15:00-17:00");break;
            }

            arrayList.add(huanzhe);
        }

        return arrayList;
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection=new DatabaseConnection();
        HuanzheImpl huanzhe=new HuanzheImpl(databaseConnection.getConn());
        try {
               for (int i=0;i<huanzhe.search().size();i++) {
                   System.out.println(huanzhe.search().get(i).toString());

               }
            }
         catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseConnection.close();
        }
    }
}

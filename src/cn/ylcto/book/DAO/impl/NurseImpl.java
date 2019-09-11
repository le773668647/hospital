package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.vo.Doctor;
import cn.ylcto.book.vo.Nurse;
import cn.ylcto.util.test.AbstractDAOImpl;
import org.apache.poi.hssf.record.formula.functions.N;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author zzzz
 * @create 2019-07-08 下午4:27
 */
public class NurseImpl extends AbstractDAOImpl {
    public NurseImpl(Connection conn) {
        super(conn);
    }
    public int add(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO nurse(id,name,object) VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,doctor.getId());
        super.pstmt.setString(2,doctor.getName());
        super.pstmt.setString(3,doctor.getObject());
        return super.pstmt.executeUpdate();
    }

    public ArrayList<Nurse> search() throws SQLException {
        ArrayList<Nurse> arrayList=new ArrayList<>();
        String sql="select id,name,object from nurse ";
        super.pstmt=super.conn.prepareStatement(sql);
        ResultSet resultSet=super.pstmt.executeQuery();
        while(resultSet.next()){
            Nurse nurse=new Nurse();
            nurse.setId(resultSet.getString("id"));
            nurse.setName(resultSet.getString("name"));
            nurse.setObject(resultSet.getString("object"));

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

            arrayList.add(nurse);
        }

        return arrayList;
    }

    public boolean login(Nurse nurse) throws SQLException {

        boolean result=false;
        String sql="select * from nurse where id=? and password=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,nurse.getId());
        super.pstmt.setString(2,nurse.getPassword());
        ResultSet resultSet=super.pstmt.executeQuery();
        System.out.println("开始while循环");
        if(resultSet.next()){
            System.out.println("start");
            result=true;
            System.out.println(result);
        }

        return result;




    }

}

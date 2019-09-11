package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.vo.Doctor;
import cn.ylcto.book.vo.Huanzhe;
import cn.ylcto.book.vo.Patient;
import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author zzzz
 * @create 2019-07-08 下午4:27
 */
public class DoctorImpl extends AbstractDAOImpl {
    public DoctorImpl(Connection conn) {
        super(conn);
    }
    public int add(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO doctor(id,name,object) VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,doctor.getId());
        super.pstmt.setString(2,doctor.getName());
        super.pstmt.setString(3,doctor.getObject());
        return super.pstmt.executeUpdate();
    }

    public ArrayList<Doctor> search() throws SQLException {
        ArrayList<Doctor> arrayList=new ArrayList<>();
        String sql="select id,name,object from doctor ";
        super.pstmt=super.conn.prepareStatement(sql);
        ResultSet resultSet=super.pstmt.executeQuery();
        while(resultSet.next()){
            Doctor doctor=new Doctor();
            doctor.setId(resultSet.getString("id"));
            doctor.setName(resultSet.getString("name"));
            doctor.setObject(resultSet.getString("object"));

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

            arrayList.add(doctor);
        }
        System.out.println(arrayList);
        return arrayList;
    }

    public boolean login(Doctor doctor) throws SQLException{

            boolean result=false;
            String sql="select * from doctor where id=? and password=?";
            super.pstmt=super.conn.prepareStatement(sql);
            super.pstmt.setString(1,doctor.getId());
            super.pstmt.setString(2,doctor.getPassword());
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


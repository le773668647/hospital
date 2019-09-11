package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.vo.Patient;
import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zzzz
 * @create 2019-07-03 下午10:47
 */
public class PatientRegisterImpl extends AbstractDAOImpl {

    public PatientRegisterImpl(Connection conn) {
        super(conn);
    }

//    public static void main(String[] args) {
//        DatabaseConnection dbc=  new DatabaseConnection();
//        Connection conn=dbc.getConn();
//        PatientRegisterImpl patientRegister=new PatientRegisterImpl(conn);
//        patientRegister.
//    }
    public void add(Patient patient) throws SQLException {
        String sql = "INSERT INTO patient(phone_num,password) VALUES(?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,patient.getPhonenum());
        super.pstmt.setString(2,patient.getPassword());
        super.pstmt.executeUpdate();

    }
    public boolean search(Patient patient) throws SQLException {
        boolean result=false;
        String sql="select * from patient where phone_num=? and password=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,patient.getPhonenum());
        super.pstmt.setString(2,patient.getPassword());
        ResultSet resultSet=super.pstmt.executeQuery();
        System.out.println("开始while循环");
        if(resultSet.next()){
            System.out.println("start");
            result=true;
            System.out.println(result);
        }

        return result;

    }

//    public static void main(String[] args) {
//        Patient patient=new Patient();
//        patient.setPhonenum("13102107322");
//        patient.setPassword("123");
//        DatabaseConnection databaseConnection=new DatabaseConnection();
//        Connection connection=databaseConnection.getConn();
//        PatientRegisterImpl patientRegister=new PatientRegisterImpl(connection);
//        try {
//            patientRegister.search(patient);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            databaseConnection.close();
//        }
//
//    }
}

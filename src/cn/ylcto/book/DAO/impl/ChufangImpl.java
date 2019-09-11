package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.vo.Chufang;

import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author zzzz
 * @create 2019-07-10 上午12:27
 */
public class ChufangImpl extends AbstractDAOImpl {
    public ChufangImpl(Connection conn) {
        super(conn);
    }
    public int pay(String id) throws SQLException {
        String sql = "update  chufang set status=? where id=?";
        super.pstmt = super.conn.prepareStatement(sql);
        String status="1";
        super.pstmt.setString(1,status);
        super.pstmt.setString(2,id);
        return super.pstmt.executeUpdate();
    }
    public int add(Chufang chufang) throws SQLException {
        String sql = "INSERT INTO chufang(id,medicinename,amount) VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,chufang.getId());
        super.pstmt.setString(2,chufang.getMedicinename());
        super.pstmt.setString(3,chufang.getAmount());
        return super.pstmt.executeUpdate();

    }
    public ArrayList<Chufang> search() throws SQLException {
        ArrayList<Chufang> arrayList=new ArrayList<>();
        String sql="select id,medicinename,amount,status from chufang ";
        super.pstmt=super.conn.prepareStatement(sql);
        ResultSet resultSet=super.pstmt.executeQuery();
        while(resultSet.next()){
            Chufang chufang=new Chufang();
            chufang.setId(resultSet.getString("id"));
            switch (resultSet.getString("medicinename")){
                case "1":chufang.setMedicinename("头孢");break;
                case "2":chufang.setMedicinename("消食片");break;
                case "3":chufang.setMedicinename("板蓝根");break;
                case "4":chufang.setMedicinename("棉签");break;
            }

            chufang.setAmount(resultSet.getString("amount"));
            if (resultSet.getString("status").equals("1")){
                chufang.setStatus("已支付");
            }else{
                chufang.setStatus("未支付");
            }

//

            arrayList.add(chufang);
        }
        System.out.println(arrayList);
        return arrayList;
    }
}

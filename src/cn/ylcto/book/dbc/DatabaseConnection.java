package cn.ylcto.book.dbc;
import java.sql.*;

public class DatabaseConnection {
    private static final String DBDRIVER ="com.mysql.jdbc.Driver";
    private static final String DBURL ="jdbc:mysql://localhost:3306/booksystem?useUnicode=true&characterEncoding=utf8";
    private static final String DBUSER ="root";
    private static final String DBPASS ="123456";

    private Connection conn;

    public DatabaseConnection(){
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        return this.conn;
    }
    public void close(){
        if (this.conn != null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

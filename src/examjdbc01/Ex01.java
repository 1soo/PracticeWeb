package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
    public static void main(String[] args){
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("클래스 로딩!");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl",
                    "jspuser",
                    "1234");
            System.out.println("접속 성공!");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

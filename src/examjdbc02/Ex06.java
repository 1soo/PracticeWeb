package examjdbc02;

import examjdbc01.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex06 {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();
        try{
            conn = util.getConnection();
            System.out.println("접속 성공!");

            StringBuilder query = new StringBuilder();
            query.append("delete from \"MEMBER\" ");
            query.append("where \"NUM\"=?");

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString());
            pstmt.setInt(1, 5);
            result = pstmt.executeUpdate();
            System.out.println(result + "행이 삭제되었습니다.");

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(pstmt);
            util.close(conn);
        }
    }
}
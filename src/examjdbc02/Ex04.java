package examjdbc02;

import examjdbc01.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex04 {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstmt = null;
        JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();
        int result = 0;
        try{
            conn = util.getConnection();
            System.out.println("접속 성공!");

            StringBuilder query = new StringBuilder();
            query.append("insert into \"MEMBER\" ");
            query.append("(\"NUM\", \"MEMBERID\", \"MEMBERPW\", \"NICKNAME\", \"REGDATE\") ");
            query.append("values (\"MEMBER_SEQ\".nextval, ?, ?, ?, sysdate)");

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, "tester5");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "nick5");
            result = pstmt.executeUpdate();
            System.out.println(result + "행이 삽입되었습니다.");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(pstmt);
            util.close(conn);
        }
    }
}
package examjdbc01;

import java.sql.*;

public class Ex06 {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try{
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl",
                    "jspuser",
                    "1234");
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
            if(pstmt != null){
                try{
                    pstmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
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
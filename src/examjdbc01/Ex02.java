package examjdbc01;

import java.sql.*;

public class Ex02 {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl",
                    "jspuser",
                    "1234");
            System.out.println("접속 성공!");
            pstmt = conn.prepareStatement("select * from \"MEMBER\"");
            rs = pstmt.executeQuery();

            while(rs.next()){
                MemberVo vo = new MemberVo(
                rs.getInt(1),
                rs.getString(2),
                rs.getString("MEMBERPW"),
                rs.getString(4),
                rs.getDate("REGDATE"));

                System.out.println(vo);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
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

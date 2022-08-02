package examjdbc02;

import examjdbc01.JdbcConnectionUtil;
import examjdbc01.MemberVo;

import java.sql.*;

public class Ex03 {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();
        try{
            conn = util.getConnection();
            System.out.println("접속 성공!");
            pstmt = conn.prepareStatement("select * from \"MEMBER\" WHERE \"MEMBERPW\"=?");
            pstmt.setInt(1, 1234);
            rs = pstmt.executeQuery();

            while(rs.next()){
                MemberVo vo = new MemberVo(
                        rs.getInt("NUM"),
                        rs.getString("MEMBERID"),
                        rs.getString("MEMBERPW"),
                        rs.getString("NICKNAME"));
                vo.setRegdate(rs.getDate("REGDATE"));
                System.out.println(vo);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(rs);
            util.close(pstmt);
            util.close(conn);
        }
    }
}
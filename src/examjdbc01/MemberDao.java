package examjdbc01;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    // db 역할
    private JdbcConnectionUtil util;

    public MemberDao(){
        util = JdbcConnectionUtil.getInstance();
    }

    // C
    public int insertMember(MemberVo vo){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try{
            conn = util.getConnection();

            StringBuilder query = new StringBuilder();
            query.append("insert into \"MEMBER\" ");
            query.append("(\"NUM\", \"MEMBERID\", \"MEMBERPW\", \"NICKNAME\", \"REGDATE\") ");
            query.append("values (\"MEMBER_SEQ\".nextval, ?, ?, ?, ?)");

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, vo.getMemberId());
            pstmt.setString(2, vo.getMemberPw());
            pstmt.setString(3, vo.getNickName());
            pstmt.setDate(4, (Date) vo.getRegdate());
            result = pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(pstmt);
            util.close(conn);
        }
        return result;
    }

    // R
    // 단일 선택
    public MemberVo selectMember(int num){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberVo vo = null;
        try{
            conn = util.getConnection();
            pstmt = conn.prepareStatement("select * from \"MEMBER\" WHERE \"NUM\"=?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            while(rs.next()){
                vo = new MemberVo(
                    rs.getInt("NUM"),
                    rs.getString("MEMBERID"),
                    rs.getString("MEMBERPW"),
                    rs.getString("NICKNAME"));
                vo.setRegdate(rs.getDate("REGDATE"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(rs);
            util.close(pstmt);
            util.close(conn);
        }
        return vo;
    }
    // 전체 선택
    public ArrayList<MemberVo> selectMemberAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<MemberVo> result = new ArrayList<>();
        try{
            conn = util.getConnection();
            pstmt = conn.prepareStatement("select * from \"MEMBER\"");
            rs = pstmt.executeQuery();

            while(rs.next()){
                MemberVo vo = new MemberVo(
                        rs.getInt("NUM"),
                        rs.getString("MEMBERID"),
                        rs.getString("MEMBERPW"),
                        rs.getString("NICKNAME"));
                vo.setRegdate(rs.getDate("REGDATE"));
                result.add(vo);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(rs);
            util.close(pstmt);
            util.close(conn);
        }
        return result;
    }

    // U
    public int updateMember(MemberVo vo){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try{
            conn = util.getConnection();

            StringBuilder query = new StringBuilder();
            query.append("update \"MEMBER\" ");
            query.append("set \"MEMBERPW\"=?, \"NICKNAME\"=? ");
            query.append("where \"NUM\"=?");

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, vo.getMemberPw());
            pstmt.setString(2, vo.getNickName());
            pstmt.setInt(3, vo.getNum());
            result = pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(pstmt);
            util.close(conn);
        }
        return result;
    }

    // D
    // 단일 삭제
    public int deleteMember(int num){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try{
            conn = util.getConnection();

            StringBuilder query = new StringBuilder();
            query.append("delete from \"MEMBER\" ");
            query.append("where \"NUM\"=?");

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString());
            pstmt.setInt(1, num);
            result = pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(pstmt);
            util.close(conn);
        }
        return result;
    }
    // 전체 삭제
    public void deleteMemberAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = util.getConnection();

            StringBuilder query = new StringBuilder();
            query.append("delete from \"MEMBER\" ");
            query.append("where \"NUM\">0");

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString());

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            util.close(pstmt);
            util.close(conn);
        }
    }
}

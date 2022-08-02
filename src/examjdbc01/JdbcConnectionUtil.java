package examjdbc01;

import java.sql.*;

// 싱글톤 적용
public class JdbcConnectionUtil {
    private static JdbcConnectionUtil instance;

    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String user = "jspuser";
    private String password = "1234";
    private JdbcConnectionUtil(){

    }

    public static JdbcConnectionUtil getInstance() {
        // 멀티 스레드 환경에서 한 스레드가 이 블록을 다 수행할 때까지 다른 스레드에서의 접근을 대기하게 함.
        synchronized (JdbcConnectionUtil.class) {
            if (instance == null) {
                instance = new JdbcConnectionUtil();
            }
            return instance;
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void close(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void close(Statement stmt){
        if(stmt != null){
            try{
                stmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void close(Connection con){
        if(con != null){
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}

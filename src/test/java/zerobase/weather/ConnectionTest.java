package zerobase.weather;

import java.sql.*;

public class ConnectionTest {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://172.30.1.63:3306/project";
    private static final String USER = "user";
    private static final String PW = "user1234";
    public static Statement stmt;


    public static void main(String[] args) {
        Connection conn = null;


        try {
            //드라이버 연결
            Class.forName(DRIVER);

            //접속 URL, mysql 유저 아이디, 비밀번호로 접속
            conn = DriverManager.getConnection(URL, USER, PW);

            //접속성공 메세지
            System.out.println("Database connection established");
        } catch (Exception e) {

            //예외 발생시 메세지
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();

                    System.out.println("Database Connection Terminated");
                } catch (Exception e) {}
            }
        }
    }
}
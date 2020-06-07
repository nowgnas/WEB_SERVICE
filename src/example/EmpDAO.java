package example;

import java.sql.*;
import java.util.*;

public class EmpDAO {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3307/testdb?&serverTimezone=UTC";
    String userid = "root";
    String passwd = "1234";

    public EmpDAO() {
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<EmpDTO> select() {
        ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(url, userid, passwd);
            String sql = "SELECT id,pw,name,email from userinfo";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                String email = rs.getString("email");

                EmpDTO dto = new EmpDTO(id, pw, name, email);
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

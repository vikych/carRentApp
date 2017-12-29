package common;

import dbconnection.ConnectionProvider;

import java.sql.*;

public class JPAUtil {
    Statement st;

    public JPAUtil() throws Exception {

//        Class.forName("com.mysql.jdbc.Driver");
//        System.out.println("Driver Loaded.");
//        String url = "jdbc:mysql://localhost:3306/databaseconnection";

        Connection conn = ConnectionProvider.jdbcConnection();
        System.out.println("Got Connection.");
        st = conn.createStatement();
    }
    public void executeSQLCommand(String sql) throws Exception {
        st.executeUpdate(sql);
    }

    public void checkData(String sql) throws Exception {
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData metadata = rs.getMetaData();

        for (int i = 0; i < metadata.getColumnCount(); i++) {
            System.out.print("\t"+ metadata.getColumnLabel(i + 1));
        }
        System.out.println("\n----------------------------------");

        while (rs.next()) {
            for (int i = 0; i < metadata.getColumnCount(); i++) {
                Object value = rs.getObject(i + 1);
                if (value == null) {
                    System.out.print("\t       ");
                } else {
                    System.out.print("\t"+value.toString().trim());
                }
            }
            System.out.println("");
        }
    }
}

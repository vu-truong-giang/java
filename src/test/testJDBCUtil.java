package test;

import java.sql.Connection; // Thêm dòng này để import lớp Connection
import database.JDBCUtil;

public class testJDBCUtil {
       public static void main(String[] argv) {
    	   Connection connection = JDBCUtil.getConnection();
    	   
    	   JDBCUtil.printInfo(connection);
    	   
    	   JDBCUtil.closeConnection(connection);
       }
}

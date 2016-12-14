
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guowh
 */
public class DBHelper {

    Connection dbConn = null;
    String DBName = "Link_DB_Student_631406010109";

    private Connection OpenConn(String sUser, String sPwd) {
        try {
            String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String sDBUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=" + DBName;
            Class.forName(sDriverName);
            dbConn = DriverManager.getConnection(sDBUrl, sUser, sPwd);
            System.out.println("连接正常开启！");
        } catch (Exception ex) {
            System.err.println("连接开启失败！");
            System.err.println(ex.getMessage());
        }
        return dbConn;
    }

    protected Connection GetConnection() {
        OpenConn("sa", "123qwe");
        return dbConn;
    }

    protected void TestConn() {
        if (OpenConn("sa", "123qwe") == null) {
            System.err.println("数据库(" + DBName + "):无法正常连接！");
            System.exit(0);
        }
        System.out.println("数据库(" + DBName + ")可以正常连接！");
        Close();
    }

    protected void Close() {
        try {
            dbConn.close();
            dbConn = null;
            System.out.println("连接正常关闭！");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

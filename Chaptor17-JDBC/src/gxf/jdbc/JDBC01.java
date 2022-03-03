package gxf.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost/db01";

        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password", "hsp");

        Connection connect = driver.connect(url, properties);
        Statement statement = connect.createStatement();

        String sql = "insert into actor values(null, '吴', '男', '1970-11-11', '110')";
        statement.execute(sql);

        statement.close();
        connect.close();
    }
}

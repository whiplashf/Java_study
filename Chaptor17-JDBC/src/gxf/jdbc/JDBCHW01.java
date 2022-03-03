package gxf.jdbc;

import datasource.JDBCUtils;

import java.sql.*;

public class JDBCHW01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        String user = "root";
//        String pwd = "hsp";
//        String url = "jdbc:mysql://localhost:3306/db01";
//        Connection connection = DriverManager.getConnection(url, user, pwd);
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();
//        String sql01 = "create table news(id int, content varchar(64))";
//        String sql02 = "insert into news values(1, '我创建了网站')";
//        statement.execute(sql01);
//        statement.execute(sql02);

        String admin_name = "刘德华";
        String admin_pwd = "110";
//        String sql = "select * from actor";
        String sql = "select name , phone from actor where name ='"
                + admin_name + "' and phone = '" + admin_pwd + "'" ;
        ResultSet resultSet = statement.executeQuery(sql);
//        while(resultSet.next()){
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString(2);
//            System.out.println(id + "\t" + name);
//        }
        if(resultSet.next()){
            System.out.println("登陆成功！");
        }else {
            System.out.println("登陆失败。。。");
        }

        statement.close();
        connection.close();
    }
}

package com.tien.util;

import java.sql.*;

public class DatabaseConnection {
    private static Connection connection = null;
    
    //Thông tin kết nối
    private static final String URL = "jdbc:sqlserver://localhost:1433/CafeManagement;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "814362";
    
    private DatabaseConnection(){
        
    }
    
    public static Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }catch(SQLException e){
                System.err.println("Không thể kết nối cơ sở dữ liệu!");
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                System.err.println("Không thể đóng kết nối cơ sở dữ liệu!");
            }
        }
    }
}

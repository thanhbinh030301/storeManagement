/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyConnect {
    Connection connect = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    public static Connection getJDBCConection() {
        final String url = "jdbc:mysql://localhost:3306/storemanagementdb";
        final String user = "root";
        final String password = "332001";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } protected Statement getStatement() throws Exception {
//        kiểm tra stament đã đóng chưa
        if (this.statement == null) {
//            khởi tạo statement mới
            this.statement = getJDBCConection().createStatement();
        }
        else {
            this.statement.isClosed();
        }
        return this.statement;
    }
    
    //hàm thực thi các câu lệnh SQl 
    public ResultSet excuteQuery(String Query) throws Exception{
        try {
            // thực thi câu lệnh
            this.resultSet = getStatement().executeQuery(Query);
            
        } catch (Exception e) {
            throw new Exception("Error excuteQuery " + e.getMessage());
        }
        
        return this.resultSet;
    }
    
//    thực thi các Insert, Update, Delete
    public int executeUpdate(String Query) throws Exception {
        //khai báo biến int để lưu trữ kết quả torng quá trình thực thi
        int res = Integer.MIN_VALUE;
        
        try {
            //thực thi câu lệnh
            res = getStatement().executeUpdate(Query);
        } catch (Exception e) {
            throw new Exception("Error " + e.getMessage());
        }
        
        return res;
    }
    
    //hàm đóng kết nối
    public void Close() throws Exception {
        if (this.resultSet != null && this.resultSet.isClosed()) {
            this.resultSet.close();
            this.resultSet = null;
        }
        if (this.statement != null && this.statement.isClosed()) {
            this.statement.close();
            this.statement = null;
        }
        if (this.connect != null && this.connect.isClosed()) {
            this.connect.close();
            this.connect = null;
        }
    }
}


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
        final String password = "123456";
        
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
//    public static void main(String[] args) {
//        Connection conn = getJDBCConection();
//        if(conn!=null){
//            System.out.println("Ket noi database thanh cong");
//        }else {
//            System.out.println("Ket noi database that bai");
//        }
//    }
    

//    public static Connection conn = null;
//    private String severName;
//    private String dbName;
//    private String userName;
//    private String password;
//
//    public MyConnect() {
//        docFileText();
//
//        String strConnect = "jdbc:mysql://" + severName + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
//        Properties pro = new Properties();
//        pro.put("user", userName);
//        pro.put("password", password);
//        try {
//            com.mysql.jdbc.Driver driver = new Driver();
//            conn = driver.connect(strConnect, pro);
//        } catch (SQLException ex) {
//            new MyDialog("Không kết nối được tới CSDL!", MyDialog.ERROR_DIALOG);
//            System.exit(0);
//        }
//
//    }
//
//    private void docFileText() {
//        // Xử lý đọc file để lấy ra 4 tham số
//        severName = "";
//        dbName = "";
//        userName = "";
//        password = "";
//
//        try {
//            FileInputStream fis = new FileInputStream("ConnectVariable.txt");
//            InputStreamReader isr = new InputStreamReader(fis);
//            BufferedReader br = new BufferedReader(isr);
//
//            severName = br.readLine();
//            dbName = br.readLine();
//            userName = br.readLine();
//            password = br.readLine();
//
//            if (password == null) {
//                password = "";
//            }
//
//        } catch (Exception e) {
//        }
//    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnect {
    
    
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
    }
    public static void main(String[] args) {
        Connection conn = getJDBCConection();
        if(conn!=null){
            System.out.println("THanh cong");
        }else {
            System.out.println("That bai");
        }
    }
    

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


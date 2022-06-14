/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import StoreManagement.DTO.TaiKhoan;
import java.sql.Statement;

/**
 *
 * @author thanh
 */
public class TaiKhoanDAO {
    public TaiKhoan login(String userName, String password) {
        try {
            String sql = "SELECT * FROM taikhoan WHERE TenDangNhap=? AND MatKhau=?";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            pre.setString(1, userName);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            TaiKhoan tkLogin = new TaiKhoan();
            if (rs.next()) {     
                tkLogin.setMaNhanVien(rs.getString("MaNV"));
                tkLogin.setCapBac(rs.getInt("CAPBAC"));
                return tkLogin;
            }
            return null;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public boolean addTaiKhoan(String user, String pass, String maNV) {
        try {
            String sql = "INSERT INTO taikhoan(TenDangNhap, MatKhau, CapBac, MaNV) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, pass);
            pre.setInt(3, 2);
            pre.setString(4, maNV);
            pre.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean checkUserName(String user) {
        try {
            String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = '" + user + "'";
            Statement st = MyConnect.getJDBCConection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public String getUserById(String maNV) {
        try {
            String sql = "SELECT TenDangNhap FROM TaiKhoan WHERE MaNV= '" + maNV +"'";
            Statement st = MyConnect.getJDBCConection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "";
    }
    public boolean checkPass(String maNV, String oldPass) {
        try {
            String sql = "SELECT matkhau FROM TaiKhoan WHERE MaNV= '" + maNV +"'";
            Statement st = MyConnect.getJDBCConection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
               if(oldPass.equals(rs.getString(1))){
                   return true;
               }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public boolean updatePass(String maNV, String newPass){
        try {
            String sql = "Update TaiKhoan set matkhau = '" + newPass+"' WHERE MaNV= '" + maNV +"'";
            Statement st = MyConnect.getJDBCConection().createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import StoreManagement.DTO.TaiKhoan;

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
}

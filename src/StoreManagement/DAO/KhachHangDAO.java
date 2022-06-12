/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import StoreManagement.DTO.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thanh
 */
public class KhachHangDAO {
    public ArrayList<KhachHang> getListKhachHang() {
        try {
            String sql = "SELECT * FROM KHACHHANG WHERE TONTAI=1";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<KhachHang> dskh = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setGioiTinh(rs.getString(3));
                kh.setSoDT(rs.getString(4));
                kh.setTongChiTieu(rs.getFloat(5));
                kh.setTichDiem(rs.getFloat(6));

                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException e) {
        }

        return null;
    }
    public boolean addKH(String hoTen, String soDT, String gioiTinh) {
        try {
            String sql = "INSERT INTO KHACHHANG(HOTEN, GIOITINH, SODT) VALUES(?,?,?)";
            PreparedStatement prep = MyConnect.getJDBCConection().prepareStatement(sql);
            prep.setString(1, hoTen);
            prep.setString(2, gioiTinh);
            prep.setString(3, soDT);
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public KhachHang getKH(String maKH) {
        KhachHang kh = null;
        try {
            String sql = "SELECT * FROM khachhang WHERE MaKH=?";
            PreparedStatement prep = MyConnect.getJDBCConection().prepareStatement(sql);
            prep.setString(1, maKH);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setGioiTinh(rs.getString(3));
                kh.setSoDT(rs.getString(4));
                kh.setTongChiTieu(rs.getFloat(5));
                kh.setTichDiem(rs.getFloat(6));
            }
        } catch (SQLException ex) {
            return null;
        }
        return kh;
    }

    public boolean deleteKhachHang(String maKH) {
        try {
            String sql = "UPDATE KHACHHANG SET TONTAI=0 WHERE MAKH=?";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            pre.setString(1, maKH);
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }
    
    public boolean updateKhachHang(String maKH, KhachHang kh) {
        try {
            String sql = "UPDATE khachhang SET HOTen=?, GioiTinh=?, SODT=? WHERE MaKH=?";
            PreparedStatement prep = MyConnect.getJDBCConection().prepareStatement(sql);
            prep.setString(1, kh.getHoTen());
            prep.setString(2, kh.getGioiTinh());
            prep.setString(3, kh.getSoDT());
            prep.setString(4, maKH);
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

}


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
            String sql = "SELECT * FROM KHACHHANG";
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

//    public boolean deleteKhachHang(int maKH) {
//        boolean result = false;
//        try {
//            String sql = "UPDATE khachhang SET TinhTrang=0 WHERE MaKH=?";
//            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
//            prep.setInt(1, maKH);
//            result = prep.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            return false;
//        }
//        return result;
//    }

}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import StoreManagement.DTO.NhanVien;

/**
 *
 * @author thanh
 */
public class NhanVienDAO {
    public ArrayList<NhanVien> getListNhanVien() {
        try {
            String sql = "SELECT * FROM NhanVien";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<NhanVien> dssv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();

                nv.setMaNV(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setSoDT(rs.getString(4));

                dssv.add(nv);
            }
            return dssv;
        } catch (SQLException e) {
        }

        return null;
    }

    public NhanVien getNhanVien(String maNV) {
        NhanVien nv = null;
        try {
            String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            pre.setString(1, maNV);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setSoDT(rs.getString(4));
            }
        } catch (SQLException e) {
            return null;
        }

        return nv;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import StoreManagement.DTO.CTHD;
import StoreManagement.DTO.SanPham;
import StoreManagement.BUS.SanPhamBUS;


import java.sql.PreparedStatement;
/**
 *
 * @author thanh
 */
public class CTHDDAO {
    public ArrayList<CTHD> getListCTHoaDon() {
       ArrayList<CTHD> dscthd = new ArrayList<>();
       try {
           String sql = "SELECT * FROM cthd";
           Statement stmt = MyConnect.getJDBCConection().createStatement();
           ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()) {
               CTHD cthd = new CTHD();
               cthd.setMaHD(rs.getString(1));
               cthd.setMaSP(rs.getString(2));
               cthd.setSoLuong(rs.getInt(3));
               cthd.setDonGia(rs.getFloat(4));
               cthd.setThanhTien(rs.getFloat(5));
               dscthd.add(cthd);
           }
       } catch(SQLException ex) {
       }
       return dscthd;
    }
    public ArrayList<CTHD> getListCTHoaDonById(String maHD) {
        ArrayList<CTHD> dscthd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cthd WHERE MaHD=?";
            PreparedStatement prep = MyConnect.getJDBCConection().prepareStatement(sql);
            prep.setString(1, maHD);
            ResultSet rs = prep.executeQuery();
            while(rs.next()) {
                CTHD cthd = new CTHD();
                cthd.setMaHD(rs.getString(1));
                cthd.setMaSP(rs.getString(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getFloat(4));
                cthd.setThanhTien(rs.getFloat(5));
                dscthd.add(cthd);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dscthd;
    }
    public boolean addCTHD(CTHD cthd) {
        try {
            String sql = "INSERT INTO  CTHD(MAHD, MASP, SOLUONG) VALUES(?,?,?)";
            PreparedStatement prep = MyConnect.getJDBCConection().prepareStatement(sql);
            prep.setString(1, cthd.getMaHD());
            prep.setString(2, cthd.getMaSP());
            prep.setInt(3, cthd.getSoLuong());
            prep.executeUpdate();
            return true;
        } catch(SQLException ex) {
            return false;
        }
    }
    public ArrayList<SanPham> getTopSP() {
        try {
            String sql = "SELECT MaSP, DaBan FROM (SELECT MaSP, SUM(SoLuong) AS DaBan FROM cthd GROUP BY MaSP) temp ORDER BY DaBan DESC LIMIT 10";
            Statement st = MyConnect.getJDBCConection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<SanPham> dssp = new ArrayList<>();
            SanPhamBUS spBUS = new SanPhamBUS();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setSoLuong(rs.getInt(2));
                sp.setTenSP(spBUS.getSPById(rs.getString(1)).getTenSP());
                dssp.add(sp);
            }
            return dssp;
        } catch (Exception e) {
        }
        return null;
    }
}

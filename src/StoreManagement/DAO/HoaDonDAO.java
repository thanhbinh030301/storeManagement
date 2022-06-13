/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import StoreManagement.BUS.NhanVienBUS;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import StoreManagement.DTO.HoaDon;
import java.sql.PreparedStatement;
import java.util.Vector;

/**
 *
 * @author thanh
 */
public class HoaDonDAO {
    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM hoadon";
            Statement stmt = MyConnect.getJDBCConection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setNgayLap(rs.getDate(2));
                hd.setMaKH(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setTongTien(rs.getFloat(5));
                dshd.add(hd);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dshd;
    }
    public boolean addHD(HoaDon hd, float tichDiem) {
        try {
            String sqlKH = "UPDATE KhachHang SET TongChiTieu=TongChiTieu+" + hd.getTongTien() + ",TICHDIEM = TICHDIEM-"+ tichDiem+"WHERE MaKH=" + "'" + hd.getMaKH() + "'";
            Statement st = MyConnect.getJDBCConection().createStatement();
            st.executeUpdate(sqlKH);
            String sql = "INSERT INTO hoadon(NgayLap, MaKH, MaNV, TongTien) VALUES(?, ?, ?, ?)";
            PreparedStatement prep = MyConnect.getJDBCConection().prepareStatement(sql);
            prep. setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setString(2, hd.getMaKH() );
            prep.setString(3, hd.getMaNV());
            prep.setFloat(4, hd.getTongTien());
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public String getIdNewest() {
        try {
            String sql = "SELECT MAX(maHD) FROM hoadon";
            Statement st = MyConnect.getJDBCConection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
                return rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public Float getToltalByQuarter(int year, int quarter) {
        String start=String.valueOf(year)+String.format("%02d",(quarter-1)*3+1)+"01";
        String end=String.valueOf(year)+String.format("%02d",quarter*3)+"31";
        try {
            String sql ="SELECT SUM(TongTien) FROM hoadon WHERE NgayLap > " + start +" AND NgayLap < " +end;
            Statement st = MyConnect.getJDBCConection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (SQLException ex) {
        }
        return (float) 0;
    }
    public ArrayList<Vector> getDoanhSoNhanVien (int month){
        try{
            String sql = 
            "SELECT maNV, DoanhSo, soluong FROM (SELECT MaNV, sum(TONGTIEN) as Doanhso, count(makh) as SoLuong from hoadon where month(NGAYLAP)= "+month+" group by manv) temp";
            Statement st = MyConnect.getJDBCConection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            NhanVienBUS nvBUS = new NhanVienBUS();
            ArrayList<Vector> thongKeDoanhSo = new ArrayList();
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString(1));
                vec.add(nvBUS.getNhanVien(rs.getString(1)).getTen());
                vec.add(rs.getFloat(2));
                vec.add(rs.getInt(3));
                thongKeDoanhSo.add(vec);
            }
            return thongKeDoanhSo;
        }catch(Exception e){
            
        }
        return null;
    }
        
}

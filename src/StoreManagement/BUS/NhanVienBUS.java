/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;

import StoreManagement.DAO.NhanVienDAO;
import StoreManagement.DTO.NhanVien;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author thanh
 */
public class NhanVienBUS {
    private final NhanVienDAO nvDAO = new NhanVienDAO();
    private ArrayList<NhanVien> lstNhanVien = getListNhanVien();


    public ArrayList<NhanVien> getListNhanVien() {
        return nvDAO.getListNhanVien();
    }
    public NhanVien getNhanVien(String maNV){
        return nvDAO.getNhanVien(maNV);
    }
     public boolean addNV(String hoTen, String gioiTinh, String soDT ){
        if (hoTen.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (gioiTinh.equals("Chọn giới tính")) {
            JOptionPane.showMessageDialog(null, "Hãy chọn giới tính", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (soDT.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return nvDAO.addNhanVien(hoTen, gioiTinh, soDT);
    }
     
    public boolean updateNhanVien(String maNv, String hoTen, String gioiTinh, String soDT) {
        if (hoTen.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (gioiTinh.equals("Chọn giới tính")) {
            JOptionPane.showMessageDialog(null, "Hãy chọn giới tính", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (soDT.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        NhanVien nv = new NhanVien();
        nv.setMaNV(maNv);
        nv.setTen(hoTen);
        nv.setGioiTinh(gioiTinh);
        nv.setSoDT(soDT);
        boolean flag = nvDAO.updateNhanVien(nv);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return flag;
    }
    public boolean deleteNhanVien(String maNv) {
        try {
            int g = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (g == JOptionPane.YES_OPTION) {
                if (nvDAO.deleteNhanVien(maNv)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên!", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }
        return false;
    }
    public ArrayList<NhanVien> getListNVbyName(String name) {
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        for (NhanVien nv : lstNhanVien) {
            String tenNV = nv.getTen().toLowerCase();
            if (tenNV.contains(name.toLowerCase())) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }
}

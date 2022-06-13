/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;

import StoreManagement.DAO.KhachHangDAO;
import StoreManagement.DTO.KhachHang;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author thanh
 */
public class KhachHangBUS {
    private final KhachHangDAO khDAO = new KhachHangDAO();
    private ArrayList<KhachHang> lstKH = getListKhachHang();


    public ArrayList<KhachHang> getListKhachHang() {
        return khDAO.getListKhachHang();
    }
    public boolean addKH(String hoTen, String soDT, String gioiTinh ){
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
        if (!soDT.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return khDAO.addKH(hoTen, soDT, gioiTinh);
    }
    public KhachHang getKH(String maKH){
        return khDAO.getKH(maKH);
    }
    public boolean updateKH(String ma, String ten, String gioiTinh, String soDT) {
        if (ten.trim().equals("")) {
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
        if (!soDT.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        KhachHang kh = new KhachHang();
        kh.setHoTen(ten);
        kh.setGioiTinh(gioiTinh);
        kh.setSoDT(soDT);
        boolean flag = khDAO.updateKhachHang(ma, kh);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return flag;
    }
    public ArrayList<KhachHang> getListKHbyName(String name) {
        ArrayList<KhachHang> dskh = new ArrayList<>();
        for (KhachHang kh : lstKH) {
            String tenKH = kh.getHoTen().toLowerCase();
            if (tenKH.contains(name.toLowerCase())) {
                dskh.add(kh);
            }
        }
        return dskh;
    }
    public boolean deleteKhachHang(String maKh) {
        try {
            int g = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (g == JOptionPane.YES_OPTION) {
                if (khDAO.deleteKhachHang(maKh)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng!", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }
        return false;
    }
}

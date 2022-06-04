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
        return khDAO.addKH(hoTen, soDT, gioiTinh);
    }
}

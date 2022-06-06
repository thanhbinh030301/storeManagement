/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;

import StoreManagement.DAO.SanPhamDAO;
import StoreManagement.DTO.SanPham;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thanh
 */
public class SanPhamBUS {

    private SanPhamDAO spDAO = new SanPhamDAO();
    private ArrayList<SanPham> listSanPham = getListSanPham();

    public ArrayList<SanPham> getListSanPham() {
        return spDAO.getListSanPham();
    }
    
    public ArrayList<SanPham> getListSPbyName(String name) {
        ArrayList<SanPham> dssp = new ArrayList<>();
        for (SanPham sp : listSanPham) {
            String tenSP = sp.getTenSP().toLowerCase();
            if (tenSP.contains(name.toLowerCase())) {
                dssp.add(sp);
            }
        }
        return dssp;
    }
    public SanPham getSPById(String maSP){
        return spDAO.getSanPham(maSP);
    }
     public void updateQuantitySP(String ma, int soLuongMat) {
        spDAO.updateQuantitySP(ma, soLuongMat);
    }
     public boolean addSanPham(String name, String dvt, String price, String soLuong ) {

        if (name.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên SP không được để trống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (dvt.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền Đơn vị tính!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            float priceSP = Float.parseFloat(price);
            int soLuongSP = Integer.parseInt(soLuong);
            
            if(spDAO.addSanPham(name, dvt, priceSP, soLuongSP)){
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập số hợp lệ cho Đơn giá và Số lượng!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public boolean deleteSanPham(String maSP) {
         try {
            int g = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (g == JOptionPane.YES_OPTION) {
                if (spDAO.deleteSanPham(maSP)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean updateSanPham(String ma, String name, String dvt, String price ,String soLuong){
        if (name.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên SP không được để trống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
            }

            if (dvt.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền Đơn vị tính!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        try {        
            float priceSP = Float.parseFloat(price);
            int soLuongSP = Integer.parseInt(soLuong);
            
            SanPham sp = new SanPham();
            sp.setMaSP(ma);
            sp.setTenSP(name);
            sp.setDonViTinh(dvt);
            sp.setDonGia(priceSP);
            sp.setSoLuong(soLuongSP);


            if (spDAO.updateSanPham(sp)) {
                JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập số hợp lệ cho Đơn giá và Số lượng!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}

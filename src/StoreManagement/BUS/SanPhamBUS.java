/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;

import StoreManagement.DAO.SanPhamDAO;
import StoreManagement.DTO.SanPham;

import java.util.ArrayList;

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
    
     public ArrayList<SanPham> getSPbyName(String name) {
        ArrayList<SanPham> dssp = new ArrayList<>();
        for (SanPham sp : listSanPham) {
            String tenSP = sp.getTenSP().toLowerCase();
            if (tenSP.toLowerCase().contains(name.toLowerCase())) {
                dssp.add(sp);
            }
        }
        return dssp;
    }
     public void updateQuantitySP(String ma, int soLuongMat) {
        spDAO.updateQuantitySP(ma, soLuongMat);
    }
}

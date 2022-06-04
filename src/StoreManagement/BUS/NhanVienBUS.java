/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;

import StoreManagement.DAO.NhanVienDAO;
import StoreManagement.DTO.NhanVien;
import java.util.ArrayList;


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
}

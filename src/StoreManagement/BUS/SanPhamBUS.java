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


    public ArrayList<SanPham> getListSanPham() {
        return spDAO.getListSanPham();
    }
    
}

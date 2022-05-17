/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import StoreManagement.DTO.SanPham;


import java.util.ArrayList;

/**
 *
 * @author thanh
 */
public class SanPhamDAO {
        
    SanPham sp1 = new SanPham(1, "banh", 20, "cai", 3000);
    SanPham sp2 = new SanPham(2, "keo", 10, "cai", 3000);
    SanPham sp3 = new SanPham(3, "nuoc ngot", 30, "chai", 3000);
    SanPham sp4 = new SanPham(4, "muoi", 30, "kg", 4000);
    SanPham sp5 = new SanPham(5, "duong", 40, "kg", 3000);
    SanPham sp6 = new SanPham(6, "rau", 50, "kg", 1000);
    SanPham sp7 = new SanPham(7, "oi", 30, "kg", 3000);
    SanPham sp8 = new SanPham(8, "man", 70, "kg", 2000);

     public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> dssp = new ArrayList<>();
        dssp.add(sp1);
        dssp.add(sp2);
        dssp.add(sp3);
        dssp.add(sp4);
        dssp.add(sp5);
        dssp.add(sp6);
        dssp.add(sp7);
        dssp.add(sp8);
        return dssp;
    }
}

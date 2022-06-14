/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;

import StoreManagement.DAO.CTHDDAO;
import java.util.ArrayList;
import StoreManagement.DTO.CTHD;
import StoreManagement.DTO.SanPham;


/**
 *
 * @author thanh
 */
public class CTHDBUS {
    private ArrayList<CTHD> listCTHD;
    private CTHDDAO cthdDAO = new CTHDDAO();
    private HoaDonBUS hdBUS = new HoaDonBUS();



    public ArrayList<CTHD> getListCTHoaDon() {
        listCTHD = cthdDAO.getListCTHoaDon();
        return listCTHD;
    }

    public ArrayList<CTHD> getListCTHoaDonById(String maHD) {
        return cthdDAO.getListCTHoaDonById(maHD);
    }
     public void addCTHD(String maSP, int soLuong) {
        String maHD = hdBUS.getIdNewest();

        CTHD cthd = new CTHD();

        cthd.setMaHD(maHD);
        cthd.setMaSP(maSP);
        cthd.setSoLuong(soLuong);

        cthdDAO.addCTHD(cthd);
    }
    public ArrayList<SanPham> getTopSP(int month, int year){
         return cthdDAO.getTopSP(month, year);
     }
}

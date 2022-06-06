/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;

import StoreManagement.DTO.HoaDon;
import StoreManagement.DAO.HoaDonDAO;
import java.util.ArrayList;

/**
 *
 * @author thanh
 */
public class HoaDonBUS {
    private ArrayList<HoaDon> listHoaDon;
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon = hoaDonDAO.getListHoaDon();
        return listHoaDon;
    }
    public void luuHoaDon(String maKH, String maNV, Float tongTien, float tichDiem) {
        HoaDon hd = new HoaDon();
        hd.setMaNV(maNV);
        hd.setMaKH(maKH);
        hd.setTongTien(tongTien);

        hoaDonDAO.addHD(hd, tichDiem);
    }
    public String getIdNewest() {
        return hoaDonDAO.getIdNewest();
    }
    public Float getTotalByQuarter(int year, int quarter){
        return hoaDonDAO.getToltalByQuarter(year, quarter);
    }
}


package StoreManagement.DTO;


import java.util.Date;

public class HoaDon {
    private float maHD;
    private float maKH;
    private float maNV;
    private Date ngayLap;
    private int tongTien;

    public HoaDon() {
    }

    public HoaDon(float maHD, float maKH, float maNV, Date ngayLap, int tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public float getMaHD() {
        return maHD;
    }

    public void setMaHD(float maHD) {
        this.maHD = maHD;
    }

    public float getMaKH() {
        return maKH;
    }

    public void setMaKH(float maKH) {
        this.maKH = maKH;
    }

    public float getMaNV() {
        return maNV;
    }

    public void setMaNV(float maNV) {
        this.maNV = maNV;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

}

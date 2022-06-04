
package StoreManagement.DTO;



public class KhachHang {
    private String maKH;
    private String hoTen;
    private String gioiTinh;
    private float tongChiTieu;
    private float tichDiem;
    private String soDT;

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoTen, String gioiTinh, String soDT, float tongChiTieu, float tichDiem) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.tichDiem = tichDiem;
        this.gioiTinh = gioiTinh;
        this.tongChiTieu = tongChiTieu;
        this.soDT = soDT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public float getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(float tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }
    
    public float getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(float tichDiem) {
        this.tichDiem = tichDiem;
    }
    public String getSoDT() {
        return soDT;
    }
    public void setSoDT(String soDT){
        this.soDT=soDT;
    }


}

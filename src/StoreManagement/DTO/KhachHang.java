
package StoreManagement.DTO;



public class KhachHang {
    private String maKH;
    private String ho;
    private String ten;
    private String gioiTinh;
    private float tongChiTieu;
    private int khuyenMai;

    public KhachHang() {
    }

    public KhachHang(String maKH, String ho, String ten, String gioiTinh, float tongChiTieu, int khuyenMai) {
        this.maKH = maKH;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tongChiTieu = tongChiTieu;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
    
    public int getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(int khuyenMai) {
        this.khuyenMai = khuyenMai;
    }


}

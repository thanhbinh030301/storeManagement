package StoreManagement.GUI;

//import QuanLyPizza.BUS.CTHoaDonBUS;
//import QuanLyPizza.BUS.HoaDonBUS;
//import MyCustom.MyDialog;

import StoreManagement.DTO.NhanVien;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import StoreManagement.BUS.CTHDBUS;
import StoreManagement.BUS.HoaDonBUS;



public class XuatHoaDon extends JDialog {

    private HoaDonBUS hoaDonBUS = new HoaDonBUS();
    private CTHDBUS cthdBUS = new CTHDBUS();

    public XuatHoaDon() {
        checkBanHang = false;
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("image/logo-icon.png");
        this.setIconImage(icon);
    }

    private ArrayList<Vector> dsGioHang;
    private float tongTien;
    private float tichDiem = 0;
    private float thanhTien = tongTien;
    private String nameNV;
    ListKH lstKH = new ListKH();
    public static boolean checkBanHang = false;


    public XuatHoaDon(ArrayList<Vector> dsGioHang, float tongTien, NhanVien nhanVien) {
        this();
        this.tongTien = tongTien;
        this.dsGioHang = dsGioHang;
        this.nameNV = nhanVien.getTen();
        DecimalFormat dcf = new DecimalFormat("###,### VND");
        txtTongTien.setText(dcf.format(tongTien));
        
    }
    private void loadQr(){
        
    }
    private void xuLyHienThiHoaDon() {
        if(tongTien - tichDiem < 0){
            thanhTien = 0;
            tichDiem = tongTien;
        }else{
            thanhTien = tongTien - tichDiem;
        }
        txtHoaDon.setContentType("text/html");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DecimalFormat dcf = new DecimalFormat("###,### VND");

        String hd = "<style> "
                + "table {"
                + "border: 1px solid;"
                + "border-bottom: none"
                + "}"
                + "tr {"
                + "border-bottom: 1px solid;"
                + "}"
                + "td {"
                + "padding: 8px;"
                + "} "
                + "th {"
                + "font-size:16pt"
                + "}"
                + "</style>";
        hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
        hd += "Nhân viên: " + nameNV + "<br/>";
        hd += "Ngày lập: " + dtf.format(now) + "<br/>";
        hd += "Khách hàng: " + txtTenKhach.getText() + "<br/>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        hd += "<div style='text-align:center'>";
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
                + "<th>Mã SP</th>"
                + "<th>Tên SP</th>"
                + "<th>Số lượng</th>"
                + "<th>Đơn giá</th>"
                + "<th>Thành tiền</th>"
                + "</tr>";
        for (Vector vec : dsGioHang) {
            hd += "<tr>";
            hd += "<td style='text-align:center;'>" + vec.get(0) + "</td>";
            hd += "<td style='text-align:left;'>" + vec.get(1) + "</td>";
            hd += "<td style='text-align:center;'>" + vec.get(2) + "</td>";
            hd += "<td style='text-align:center;'>" + vec.get(3) + "</td>";
            hd += "<td style='text-align:center;'>" + vec.get(4) + "</td>";
            hd += "</tr>";
        }
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Tổng cộng</td>";
        hd += "<td style='text-align:center;'>" + dcf.format(tongTien) + "</td>";
        hd += "</tr>";
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Khuyến mãi</td>";
        hd += "<td style='text-align:center;'>" + dcf.format(tichDiem) + "</td>";
        hd += "</tr>";
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
        hd += "<td style='text-align:center;'>" + dcf.format(thanhTien) + "</td>";
        hd += "</tr>";
        hd += "</table>";
        hd += "</div>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        txtHoaDon.setText(hd);
        hoaDonBUS.luuHoaDon(lstKH.khachHangSelected.getMaKH(), Home.nv.getMaNV(), thanhTien, tichDiem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHoaDon = new javax.swing.JEditorPane();
        txtTenKhach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTichDiem = new javax.swing.JTextField();
        chkTichDiem = new javax.swing.JCheckBox();
        btnSelectKH = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbPurchaseStyle = new javax.swing.JComboBox<>();

        jLabel5.setText("jLabel5");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 100, 100));
        jLabel1.setText("Chi tiết hoá đơn");
        jPanel1.add(jLabel1);

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setPreferredSize(new java.awt.Dimension(128, 45));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel2.add(btnThanhToan);

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrint.setText("In hóa đơn");
        btnPrint.setEnabled(false);
        btnPrint.setPreferredSize(new java.awt.Dimension(128, 45));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrint);

        txtHoaDon.setEditable(false);
        jScrollPane1.setViewportView(txtHoaDon);

        txtTenKhach.setEditable(false);
        txtTenKhach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Khách hàng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tổng tiền");

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Sử dụng điểm");

        txtTichDiem.setEditable(false);
        txtTichDiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        chkTichDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTichDiemActionPerformed(evt);
            }
        });

        btnSelectKH.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnSelectKH.setText("...");
        btnSelectKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectKHActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Thanh toán");

        cmbPurchaseStyle.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cmbPurchaseStyle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Ví điện tử" }));
        cmbPurchaseStyle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPurchaseStyleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addComponent(txtTenKhach)
                    .addComponent(txtTichDiem)
                    .addComponent(cmbPurchaseStyle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkTichDiem)
                    .addComponent(btnSelectKH))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSelectKH))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTichDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkTichDiem))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbPurchaseStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectKHActionPerformed
        // TODO add your handling code here:
        lstKH.setVisible(true);
        if (lstKH.khachHangSelected != null) {
            txtTenKhach.setText(lstKH.khachHangSelected.getMaKH() + " - " + lstKH.khachHangSelected.getHoTen());
            DecimalFormat dcf = new DecimalFormat("###,### VND");
            txtTichDiem.setText(dcf.format(lstKH.khachHangSelected.getTichDiem()));
        }
    }//GEN-LAST:event_btnSelectKHActionPerformed

    private void chkTichDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTichDiemActionPerformed
        // TODO add your handling code here:
        DecimalFormat dcf = new DecimalFormat("###,### VND");
        if(chkTichDiem.isSelected()){
            this.tichDiem = lstKH.khachHangSelected.getTichDiem();
            if(tongTien - tichDiem < 0){
                thanhTien = 0;
                tichDiem = tongTien;
            }else{
                thanhTien = tongTien - tichDiem;
            }
            this.thanhTien = this.tongTien - this.tichDiem;
            
        }else{
             this.tichDiem = 0;
             this.thanhTien = this.tongTien;
        }
        txtTongTien.setText(dcf.format(thanhTien));
    }//GEN-LAST:event_chkTichDiemActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (txtTenKhach.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Chọn khách hàng","Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        xuLyHienThiHoaDon();
        for (Vector vec : dsGioHang) {
            String maSP = vec.get(0).toString();
            int soLuong = Integer.parseInt(vec.get(2).toString());
            cthdBUS.addCTHD(maSP, soLuong);
        }

        PnHoaDon.loadDataTblHD();
        PnKhachHang.loadDataTblKH();
        checkBanHang = true;
        btnPrint.setEnabled(true);
        btnThanhToan.setEnabled(false);
        chkTichDiem.setEnabled(false);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void cmbPurchaseStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPurchaseStyleActionPerformed
        // TODO add your handling code here:

        txtHoaDon.setContentType("text/html");

        if(cmbPurchaseStyle.getSelectedIndex()==0){
            txtHoaDon.setText("");
        }else{
            String hdString="<div style='text-align:center;'>"
                + "<h1>Quét mã để thanh toán</h1>";
                hdString+="<img style='text-align:center;' src='https://upload.wikimedia.org/wikipedia/commons/d/d7/Commons_QR_code.png'></img></div>";
            txtHoaDon.setText(hdString);
        }
    }//GEN-LAST:event_cmbPurchaseStyleActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSelectKH;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JCheckBox chkTichDiem;
    private javax.swing.JComboBox<String> cmbPurchaseStyle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane txtHoaDon;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JTextField txtTichDiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}

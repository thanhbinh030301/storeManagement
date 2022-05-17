package StoreManagement.GUI;

import MyCustom.MyDialog;
import MyCustom.MyTable;
import StoreManagement.DTO.SanPham;

import StoreManagement.BUS.SanPhamBUS;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;

public class PnBanHang extends JPanel {

    private SanPhamBUS spBUS = new SanPhamBUS();
   
    final Color colorPanel = new Color(247, 247, 247);
    CardLayout cardBanHangGroup = new CardLayout();
    JPanel pnCardTabBanHang;
    MyTable tblBanHang, tblGioHang;
    DefaultTableModel dtmSanPhamBan, dtmGioHang;
    JTextField txtMaSPBanHang, txtTenSPBanHang, txtDonGiaBanHang;
    JSpinner spnSoLuongBanHang;
    JButton btnThemVaoGio, btnXoaSPGioHang, btnXuatHoaDonSP, btnTimKiem;

    JList<String> listHoaDon;
    JTable tblCTHoaDon;
    DefaultTableModel dtmCTHoaDon;
    JButton btnReset, btnResetCTHoaDon, btnResetHoaDon;

    public PnBanHang() {
//        changLNF("Windows");
        addControlsBanHang();
        addEventsBanHang();
    }

    private void addControlsBanHang() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        Font font = new Font("", Font.PLAIN, 20);

        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);

        int w = 1030;
        int h = 844;


        //====================Bảng hàng hoá====================
   
        JPanel pnTableBanHang = new JPanel();
        pnTableBanHang.setLayout(new BorderLayout());

        JPanel pnTitleBanHang = new JPanel();
        JLabel lblTitleBanHang = new JLabel("Danh sách sản phẩm");
        lblTitleBanHang.setFont(new Font("Arial", Font.BOLD, 28));
        btnReset = new JButton(new ImageIcon("image/Refresh-icon.png"));
        btnReset.setFocusPainted(false);
        btnReset.setPreferredSize(new Dimension(40, 40));
        pnTitleBanHang.add(lblTitleBanHang);
        pnTitleBanHang.add(btnReset);
        pnTableBanHang.add(pnTitleBanHang, BorderLayout.NORTH);

        dtmSanPhamBan = new DefaultTableModel();
        dtmSanPhamBan.addColumn("Mã SP");
        dtmSanPhamBan.addColumn("Tên SP");
        dtmSanPhamBan.addColumn("Đơn giá");
        dtmSanPhamBan.addColumn("Còn lại");
        dtmSanPhamBan.addColumn("Đơn vị tính");
        tblBanHang = new MyTable(dtmSanPhamBan);

        tblBanHang.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblBanHang.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblBanHang.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblBanHang.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        TableColumnModel columnModelBanHang = tblBanHang.getColumnModel();
        columnModelBanHang.getColumn(0).setPreferredWidth(77);
        columnModelBanHang.getColumn(1).setPreferredWidth(282);
        columnModelBanHang.getColumn(2).setPreferredWidth(82);
        columnModelBanHang.getColumn(3).setPreferredWidth(85);
        columnModelBanHang.getColumn(4).setPreferredWidth(138);
        loadDataTableSanPhamBan();

        JScrollPane scrTblBanHang = new JScrollPane(tblBanHang);
        
        pnTableBanHang.add(scrTblBanHang, BorderLayout.CENTER);

        //====================Thông tin giỏ hàng====================
        JPanel pnTableGioHang = new JPanel();
        pnTableGioHang.setLayout(new BorderLayout());

        JLabel lblTitleGioHang = new JLabel("Giỏ hàng");
        lblTitleGioHang.setFont(new Font("Arial", Font.BOLD, 28));
        pnTableGioHang.add(lblTitleGioHang, BorderLayout.NORTH);

        dtmGioHang = new DefaultTableModel();
        dtmGioHang.addColumn("Mã SP");
        dtmGioHang.addColumn("Tên SP");
        dtmGioHang.addColumn("Số lượng");
        dtmGioHang.addColumn("Đơn giá");
        dtmGioHang.addColumn("Thành tiền");

        tblGioHang = new MyTable(dtmGioHang);

        tblGioHang.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblGioHang.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblGioHang.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblGioHang.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        TableColumnModel columnModelGioHang = tblGioHang.getColumnModel();
        columnModelGioHang.getColumn(0).setPreferredWidth(81);
        columnModelGioHang.getColumn(1).setPreferredWidth(279);
        columnModelGioHang.getColumn(2).setPreferredWidth(111);
        columnModelGioHang.getColumn(3).setPreferredWidth(101);
        columnModelGioHang.getColumn(4).setPreferredWidth(100);
        
        

        JScrollPane scrTblGioHang = new JScrollPane(tblGioHang);
        pnTableGioHang.add(scrTblGioHang, BorderLayout.CENTER);

        //====================Thông tin bán hàng====================
        JPanel pnThongTinBanHang = new JPanel();
        pnThongTinBanHang.setLayout(new BoxLayout(pnThongTinBanHang, BoxLayout.Y_AXIS));

        JPanel pnTitleThongTin = new JPanel();
        JLabel lblTitleThongTin = new JLabel("Chi tiết sản phẩm", JLabel.LEFT);
        lblTitleThongTin.setFont(new Font("Arial", Font.BOLD, 28));
        pnTitleThongTin.add(lblTitleThongTin);
        pnThongTinBanHang.add(pnTitleThongTin);


        JPanel pnMaSP = new JPanel();
        JLabel lblMa = new JLabel("Mã SP");
        lblMa.setFont(font);
        txtMaSPBanHang = new JTextField(15);
        txtMaSPBanHang.setFont(font);
        pnMaSP.add(lblMa);
        pnMaSP.add(txtMaSPBanHang);
        pnThongTinBanHang.add(pnMaSP);

        JPanel pnTenSP = new JPanel();
        JLabel lblTen = new JLabel("Tên SP");
        lblTen.setFont(font);
        txtTenSPBanHang = new JTextField(15);
        txtTenSPBanHang.setFont(font);
        txtTenSPBanHang.setEditable(true);
        pnTenSP.add(lblTen);
        pnTenSP.add(txtTenSPBanHang);
        pnThongTinBanHang.add(pnTenSP);

        JPanel pnDonGiaSP = new JPanel();
        JLabel lblDonGia = new JLabel("Đơn giá");
        lblDonGia.setFont(font);
        txtDonGiaBanHang = new JTextField(15);
        txtDonGiaBanHang.setFont(font);
        pnDonGiaSP.add(lblDonGia);
        pnDonGiaSP.add(txtDonGiaBanHang);
        pnThongTinBanHang.add(pnDonGiaSP);

        JPanel pnSoLuongSP = new JPanel();
        JLabel lblSoLuong = new JLabel("Số lượng");
        lblSoLuong.setFont(font);
        spnSoLuongBanHang = new JSpinner();
        spnSoLuongBanHang.setFont(font);
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 1, 100, 1);
        spnSoLuongBanHang.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) spnSoLuongBanHang.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(true);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);

        pnSoLuongSP.add(lblSoLuong);
        pnSoLuongSP.add(spnSoLuongBanHang);
        pnThongTinBanHang.add(pnSoLuongSP);

        

        Dimension sizeLabel = lblSoLuong.getPreferredSize();

        lblMa.setPreferredSize(sizeLabel);
        lblTen.setPreferredSize(sizeLabel);
        lblDonGia.setPreferredSize(sizeLabel);
        lblSoLuong.setPreferredSize(sizeLabel);
        spnSoLuongBanHang.setPreferredSize(txtMaSPBanHang.getPreferredSize());
        

        txtMaSPBanHang.setEditable(true);
        txtDonGiaBanHang.setEditable(true);
        
        
        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);

        JPanel pnButtonBan = new JPanel();
        JPanel pnButtonBanHang = new JPanel();

        
        btnXoaSPGioHang = new JButton("Xoá");
        btnXuatHoaDonSP = new JButton("Xuất hoá đơn");
        btnThemVaoGio = new JButton("Thêm vào giỏ");
        btnTimKiem = new JButton("Tìm kiếm");
        
        btnXoaSPGioHang.setFont(fontButton);
        btnXuatHoaDonSP.setFont(fontButton);
        btnThemVaoGio.setFont(fontButton);
        btnTimKiem.setFont(fontButton);
        
        btnXoaSPGioHang.setIcon(new ImageIcon("image/delete-icon.png"));
        btnThemVaoGio.setIcon(new ImageIcon("image/add-icon.png"));
        btnTimKiem.setIcon(new ImageIcon("image/Search-icon.png"));
        
        Dimension btnSize = btnTimKiem.getPreferredSize();
        btnXoaSPGioHang.setPreferredSize(btnSize);
        btnThemVaoGio.setPreferredSize(btnSize);
        btnXuatHoaDonSP.setPreferredSize(btnSize);

        pnButtonBan.add(btnThemVaoGio);
        pnButtonBan.add(btnTimKiem);
        pnButtonBanHang.add(btnXoaSPGioHang);
        pnButtonBanHang.add(btnXuatHoaDonSP);

        pnThongTinBanHang.add(pnButtonBan);

        JPanel pnTemp = new JPanel();
        pnTemp.setPreferredSize(new Dimension((int) pnThongTinBanHang.getPreferredSize().getWidth(), 250));

        


        //=======================================================
        JPanel pnCenter = new JPanel();

        JPanel pnLeftBanHang = new JPanel();
        pnLeftBanHang.setLayout(new BoxLayout(pnLeftBanHang, BoxLayout.Y_AXIS));
        pnLeftBanHang.setPreferredSize(new Dimension(618, h - 41));
        pnTableBanHang.setPreferredSize(new Dimension(618, (h - 41) / 2));
        pnLeftBanHang.add(pnTableBanHang);
        pnLeftBanHang.add(pnTableGioHang);
        pnCenter.add(pnLeftBanHang);

        JPanel pnRightBanHang = new JPanel();
        pnRightBanHang.setLayout(new BoxLayout(pnRightBanHang, BoxLayout.Y_AXIS));

        pnRightBanHang.add(pnThongTinBanHang);
        pnThongTinBanHang.setPreferredSize(new Dimension((int) pnRightBanHang.getPreferredSize().getWidth(),
                (int) pnTableBanHang.getPreferredSize().getHeight()));

        pnRightBanHang.add(pnTemp);
        pnRightBanHang.add(pnButtonBanHang);
        pnCenter.add(pnRightBanHang);

        pnCardTabBanHang = new JPanel(cardBanHangGroup);
        pnCardTabBanHang.setPreferredSize(new Dimension(w, (int) (h - 100)));
        JPanel pnCTBanHang = new JPanel();
        pnCTBanHang.setLayout(new BorderLayout());
        pnCTBanHang.add(pnCenter, BorderLayout.CENTER);
        pnCardTabBanHang.add(pnCTBanHang, "1");
        
        this.add(pnCardTabBanHang);
    }

    private void addEventsBanHang() {
        tblBanHang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyClickTblBanHang();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btnThemVaoGio.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyThemVaoGioHang();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        btnXuatHoaDonSP.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyXuatHoaDonBanHang();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        
    }
    private void loadDataTableSanPhamBan() {
        dtmSanPhamBan.setRowCount(0);
        ArrayList<SanPham> dssp = null;

        
            dssp = spBUS.getListSanPham();

        for (SanPham sp : dssp) {
            Vector vec = new Vector();
            vec.add(sp.getMaSP());
            vec.add(sp.getTenSP());
            vec.add(sp.getDonGia());
            vec.add(sp.getSoLuong());
            vec.add(sp.getDonViTinh());
            dtmSanPhamBan.addRow(vec);
        }
    }
    private void xuLyClickTblBanHang() {
        int row = tblBanHang.getSelectedRow();
        if (row > -1) {
            String ma = tblBanHang.getValueAt(row, 0) + "";
            String ten = tblBanHang.getValueAt(row, 1) + "";
            String donGia = tblBanHang.getValueAt(row, 2) + "";
            int soLuong = Integer.parseInt(tblBanHang.getValueAt(row, 3) + "");
            if (soLuong < 1) {
                MyDialog dlg = new MyDialog("Sản phẩm đã hết hàng", MyDialog.ERROR_DIALOG);
                return;
            }

            SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 1, soLuong, 1);
            spnSoLuongBanHang.setModel(modeSpinner);
            JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) spnSoLuongBanHang.getEditor()).getTextField();
            ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
            txtSpinner.setEditable(false);
            txtSpinner.setHorizontalAlignment(JTextField.LEFT);

            txtMaSPBanHang.setText(ma);
            txtTenSPBanHang.setText(ten);
            txtDonGiaBanHang.setText(donGia);
        }
    }
    private void xuLyThemVaoGioHang() {
        int row = tblBanHang.getSelectedRow();
        if (row < 0) {
            return;
        }

        String ma = txtMaSPBanHang.getText();
        String ten = txtTenSPBanHang.getText();
        String donGia = txtDonGiaBanHang.getText();
        int soLuong = Integer.parseInt(spnSoLuongBanHang.getValue() + "");
        int soLuongConLai = Integer.parseInt(tblBanHang.getValueAt(tblBanHang.getSelectedRow(), 3) + "");

        if (soLuong > soLuongConLai || soLuongConLai <= 0) {
            new MyDialog("Sản phẩm đã hết hàng", MyDialog.ERROR_DIALOG);
            return;
        }

        txtMaSPBanHang.setText("");
        txtTenSPBanHang.setText("");
        txtDonGiaBanHang.setText("");
        spnSoLuongBanHang.setValue(0);

        if (ma.trim().equalsIgnoreCase(""))
            return;
        int key = Integer.parseInt(ma);
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            int maTbl = Integer.parseInt(tblGioHang.getValueAt(i, 0) + "");
            if (maTbl == key) {
                int soLuongAdd = Integer.parseInt(tblGioHang.getValueAt(i, 2) + "");
                soLuongAdd += soLuong;
                donGia = donGia.replace(",", "");
                int donGiaSP = Integer.parseInt(donGia);

                tblGioHang.setValueAt(soLuongAdd, i, 2);
                tblGioHang.setValueAt(soLuong * donGiaSP, i, 4);

                // cập nhật lại số lượng trong db
//                spBUS.capNhatSoLuongSP(key, -soLuong);
//                spBUS.docListSanPham();
                loadDataTableSanPhamBan();
                return;
            }
        }

        Vector vec = new Vector();
        vec.add(ma);
        vec.add(ten);
        vec.add(soLuong);
        vec.add(donGia);
        donGia = donGia.replace(",", "");
        int donGiaSP = Integer.parseInt(donGia);
        vec.add(soLuong * donGiaSP);
        // cập nhật lại số lượng trong db
//        spBUS.capNhatSoLuongSP(key, -soLuong);
//        spBUS.docListSanPham();
        loadDataTableSanPhamBan();
        dtmGioHang.addRow(vec);
    }
    private void xuLyXuatHoaDonBanHang() {
        ArrayList<Vector> dsGioHang = new ArrayList<>();
        int row = tblGioHang.getRowCount();
        if (row == 0) return;
        int tongTien = 0;
        for (int i = 0; i < row; i++) {
            Vector vec = new Vector();
            vec.add(tblGioHang.getValueAt(i, 0));
            vec.add(tblGioHang.getValueAt(i, 1));
            vec.add(tblGioHang.getValueAt(i, 2));
            vec.add(tblGioHang.getValueAt(i, 3));
            vec.add(tblGioHang.getValueAt(i, 4));
            tongTien += Integer.parseInt((tblGioHang.getValueAt(i, 4) + "").replace(",", ""));
            dsGioHang.add(vec);
        }
        Object [] nv = {"01","Le Van a"};
        XuatHoaDon hoaDonUI = new XuatHoaDon(dsGioHang, tongTien, "Le van a");
        hoaDonUI.setVisible(true);
        if (hoaDonUI.checkBanHang) {
            dtmGioHang.setRowCount(0);
        }
    }

}

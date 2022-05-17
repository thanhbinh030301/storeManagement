package StoreManagement.GUI;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PnKhachHang extends JPanel {

    public PnKhachHang() {
        addControls();
        addEvents();
    }


    final Color colorPanel = new Color(247, 247, 247);
    JButton btnReset;
    JTextField txtMa, txtHo, txtTen, txtTongChiTieu, txtTukhoa, txtMaxChiTieu, txtMinchiTieu;
    JComboBox<String> cmbGioiTinh;
    JButton btnThem, btnSua, btnXoa, btnTim;
    JTable tblKhachHang;
    DefaultTableModel dtmKhachHang;

    private void addControls() {
        Font font = new Font("Tahoma", Font.PLAIN, 20);

        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);
        int w = 1030;
        int h = 844;

        /*
        =========================================================================
                                    PANEL KHÁCH HÀNG
        =========================================================================
         */
        JPanel pnKhachHang = new JPanel();
        pnKhachHang.setLayout(new BoxLayout(pnKhachHang, BoxLayout.Y_AXIS));

        JPanel pnTopKH = new JPanel();
        pnTopKH.setLayout(new BoxLayout(pnTopKH, BoxLayout.Y_AXIS));

        JPanel pnTitle = new JPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ KHÁCH HÀNG</h1></html>");
        btnReset = new JButton(new ImageIcon("image/Refresh-icon.png"));
        btnReset.setPreferredSize(new Dimension(40, 40));
        pnTitle.add(lblTitle);
        pnTitle.add(btnReset);
        pnTopKH.add(pnTitle);

        //======PANEL TEXT FIELD=======
        JPanel pnTextField = new JPanel();
        pnTextField.setLayout(new BoxLayout(pnTextField, BoxLayout.Y_AXIS));

        JLabel lblMa, lblHo, lblTen, lblGioiTinh, lblTongChiTieu;
        lblMa = new JLabel("Mã Khách hàng");
        lblHo = new JLabel("Họ đệm");
        lblTen = new JLabel("Tên");
        lblGioiTinh = new JLabel("Giới tính");
        lblTongChiTieu = new JLabel("Tổng chi tiêu");

        lblMa.setFont(font);
        lblHo.setFont(font);
        lblTen.setFont(font);
        lblGioiTinh.setFont(font);
        lblTongChiTieu.setFont(font);

        txtMa = new JTextField(20);
        txtMa.setEditable(false);
        txtHo = new JTextField(20);
        txtTen = new JTextField(20);
        txtTongChiTieu = new JTextField(20);
        txtTongChiTieu.setEditable(false);
        cmbGioiTinh = new JComboBox<>();
        cmbGioiTinh.addItem("Chọn giới tính");
        cmbGioiTinh.addItem("Nam");
        cmbGioiTinh.addItem("Nữ");

        txtMa.setFont(font);
        txtHo.setFont(font);
        txtTen.setFont(font);
        txtTongChiTieu.setFont(font);
        cmbGioiTinh.setFont(font);

        JPanel pnMa = new JPanel();
        pnMa.add(lblMa);
        pnMa.add(txtMa);
        pnTextField.add(pnMa);

        JPanel pnHo = new JPanel();
        pnHo.add(lblHo);
        pnHo.add(txtHo);
        pnTextField.add(pnHo);

        JPanel pnTen = new JPanel();
        pnTen.add(lblTen);
        pnTen.add(txtTen);
        pnTextField.add(pnTen);

        JPanel pnGioiTinh = new JPanel();
        pnGioiTinh.add(lblGioiTinh);
        pnGioiTinh.add(cmbGioiTinh);
        pnTextField.add(pnGioiTinh);

        JPanel pnTongChiTieu = new JPanel();
        pnTongChiTieu.add(lblTongChiTieu);
        pnTongChiTieu.add(txtTongChiTieu);
        pnTextField.add(pnTongChiTieu);

        Dimension lblSize = lblMa.getPreferredSize();
        lblMa.setPreferredSize(lblSize);
        lblHo.setPreferredSize(lblSize);
        lblTen.setPreferredSize(lblSize);
        lblGioiTinh.setPreferredSize(lblSize);
        lblTongChiTieu.setPreferredSize(lblSize);
        cmbGioiTinh.setPreferredSize(txtHo.getPreferredSize());

        pnTopKH.add(pnTextField);
        pnKhachHang.add(pnTopKH);

        //===============PANEL BUTTON=============
        JPanel pnButton = new JPanel();
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Lưu");
        btnXoa = new JButton("Xoá");

        btnThem.setIcon(new ImageIcon("image/add-icon.png"));
        btnSua.setIcon(new ImageIcon("image/Pencil-icon.png"));
        btnXoa.setIcon(new ImageIcon("image/delete-icon.png"));
        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);

        btnThem.setFont(fontButton);
        btnSua.setFont(fontButton);
        btnXoa.setFont(fontButton);
        pnKhachHang.add(pnButton);

        pnButton.add(btnThem);
        pnButton.add(btnSua);
        pnButton.add(btnXoa);

        btnThem.setIcon(new ImageIcon("image/add-icon.png"));
        btnSua.setIcon(new ImageIcon("image/Pencil-icon.png"));
        btnXoa.setIcon(new ImageIcon("image/delete-icon.png"));
        Dimension btnSize = btnThem.getPreferredSize();
        btnThem.setPreferredSize(btnSize);
        btnSua.setPreferredSize(btnSize);
        btnXoa.setPreferredSize(btnSize);

        //====PANEL SEARCH=====
        JPanel pnTimKiem = new JPanel();
        JLabel lblTimKiem = new JLabel("Từ khoá tìm");
        lblTimKiem.setFont(font);
        txtTukhoa = new JTextField(20);
        txtTukhoa.setFont(font);
        pnTimKiem.add(lblTimKiem);
        pnTimKiem.add(txtTukhoa);
        pnKhachHang.add(pnTimKiem);

        JPanel pnTimGioiHan = new JPanel();
        JLabel lblMin = new JLabel("Chi tiêu từ:");
        JLabel lblMax = new JLabel("đến:");
        lblMin.setFont(font);
        lblMax.setFont(font);
        txtMinchiTieu = new JTextField(5);
        txtMinchiTieu.setHorizontalAlignment(JTextField.CENTER);
        txtMaxChiTieu = new JTextField(5);
        txtMaxChiTieu.setHorizontalAlignment(JTextField.CENTER);
        txtMinchiTieu.setFont(font);
        txtMaxChiTieu.setFont(font);
        btnTim = new JButton(new ImageIcon("image/Search-icon.png"));
        btnTim = new JButton(new ImageIcon("image/Search-icon.png"));
        pnTimGioiHan.add(lblMin);
        pnTimGioiHan.add(txtMinchiTieu);
        pnTimGioiHan.add(lblMax);
        pnTimGioiHan.add(txtMaxChiTieu);
        pnTimGioiHan.add(btnTim);
        pnKhachHang.add(pnTimGioiHan);
        //=========================TABLE=====================
        dtmKhachHang = new DefaultTableModel();
        dtmKhachHang.addColumn("Mã KH");
        dtmKhachHang.addColumn("Họ đệm");
        dtmKhachHang.addColumn("Tên");
        dtmKhachHang.addColumn("Giới tính");
        dtmKhachHang.addColumn("Tổng chi tiêu");

        tblKhachHang = new JTable(dtmKhachHang);

        JScrollPane scrtblKhachHang = new JScrollPane(tblKhachHang);

        this.add(pnKhachHang, BorderLayout.NORTH);
        this.add(scrtblKhachHang, BorderLayout.CENTER);


    }

    private void addEvents() {
        
    }
       
}

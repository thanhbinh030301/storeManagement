package StoreManagement.GUI;

//import StoreManagement.BUS.PhanQuyenBUS;
//import StoreManagement.DTO.PhanQuyen;


import StoreManagement.BUS.NhanVienBUS;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import StoreManagement.DTO.NhanVien;

public class Home extends JFrame {

    public Home() {
        this.setTitle("Phần mềm quản lý cửa hàng");
        this.setSize(1280, 900);
        Image icon = Toolkit.getDefaultToolkit().getImage("image/logo-icon.png");
        this.setIconImage(icon);
        addControls();
        addEvents();
    }

    public void showWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    JPanel pnMenuLeft, pnCard, pnBanHang, pnSanPham, pnNhanVien, pnKhachHang, pnThongKe, pnHoaDon;
    PnBanHang banHangPanel;
    PnSanPham sanPhamPanel;
    PnNhanVien nhanVienPanel;
    PnKhachHang khachHangPanel;
    PnThongKe thongKePanel;
    PnHoaDon hoaDonPanel;

    JLabel lblBanHang, lblNhapHang, lblSanPham, lblNhanVien, lblKhachHang, lblThongKe, lblHoaDon;
    final Color clLeftItem = new Color(63, 74, 89);
    final Color clLeftItemHover = new Color(225, 100, 100);
    final Color clLeftItemSelected = new Color(225, 100, 99);
    ArrayList<JLabel> listMenuLeft;
    CardLayout cardMenuLeftGroup = new CardLayout();
    Login login = new Login();
    public static NhanVien nv = null;


    private void addControls() {
        int width = this.getWidth();
        int height = this.getHeight();

        Container con = getContentPane();

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        
        /*
        ============================================================
                                SIDE BAR MENU
        ============================================================
         */
        pnMenuLeft = new JPanel();
        pnMenuLeft.setPreferredSize(new Dimension(250, height));
        pnMenuLeft.setBackground(clLeftItem);
        pnMenuLeft.setLayout(new BoxLayout(pnMenuLeft, BoxLayout.Y_AXIS));

        JLabel lblAvatar = new JLabel(new ImageIcon("image/ManagerUI/avatar.png"), JLabel.CENTER);
        lblAvatar.setPreferredSize(new Dimension(250, 210));
        
        //hien thi nhan vien
        NhanVienBUS nvBUS = new NhanVienBUS();
        String maNV = login.tkLogin.getMaNhanVien();
        nv = nvBUS.getNhanVien(maNV);
        
        JLabel lblMaNhanVien = new JLabel("ID: " + nv.getMaNV());
        JLabel lblTenNhanVien = new JLabel("Tên: " + nv.getTen());
        Font font = new Font("Arial", Font.BOLD, 20);
        lblMaNhanVien.setFont(font);
        lblTenNhanVien.setFont(font);
        lblMaNhanVien.setForeground(clLeftItemSelected);
        lblTenNhanVien.setForeground(clLeftItemSelected);
        
        
        lblMaNhanVien.setPreferredSize(new Dimension(250, 40));
        lblTenNhanVien.setPreferredSize(new Dimension(250, 40));

        
        pnMenuLeft.add(lblMaNhanVien);
        pnMenuLeft.add(lblTenNhanVien);
        pnMenuLeft.add(lblAvatar);
        lblBanHang = new JLabel(new ImageIcon("image/ManagerUI/lblBanHang.png"));
        lblNhapHang = new JLabel(new ImageIcon("image/ManagerUI/lblNhapHang.png"));
        lblSanPham = new JLabel(new ImageIcon("image/ManagerUI/lblSanPham.png"));
        lblNhanVien = new JLabel(new ImageIcon("image/ManagerUI/lblNhanVien.png"));
        lblKhachHang = new JLabel(new ImageIcon("image/ManagerUI/lblKhachHang.png"));
        lblThongKe = new JLabel(new ImageIcon("image/ManagerUI/lblThongKe.png"));
        lblHoaDon = new JLabel(new ImageIcon("image/ManagerUI/lblHoaDon.png"));

        listMenuLeft = new ArrayList<>();
        listMenuLeft.add(lblBanHang);
        listMenuLeft.add(lblHoaDon);
        listMenuLeft.add(lblSanPham);
        listMenuLeft.add(lblNhanVien);
        listMenuLeft.add(lblKhachHang);
        listMenuLeft.add(lblNhapHang);
        listMenuLeft.add(lblThongKe);

        for (JLabel lbl : listMenuLeft) {
            lbl.setVisible(false);
            lbl.setPreferredSize(new Dimension(250, 65));
            lbl.setOpaque(true);
            lbl.setBackground(clLeftItem);
            lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pnMenuLeft.add(lbl);
        }

        lblBanHang.setBackground(clLeftItemSelected);
        lblBanHang.setVisible(true);
        lblHoaDon.setVisible(true);

        pnMain.add(pnMenuLeft, BorderLayout.WEST);

        /*
        ============================================================
                                CARD PANEL           
        ============================================================
         */
        pnCard = new JPanel(cardMenuLeftGroup);

        pnBanHang = new JPanel();
        pnSanPham = new JPanel();
        pnNhanVien = new JPanel();
        pnKhachHang = new JPanel();
        pnThongKe = new JPanel();
        pnHoaDon = new JPanel();

        pnCard.add(pnBanHang, "1");
        pnCard.add(pnHoaDon, "2");
        pnCard.add(pnSanPham, "3");
        pnCard.add(pnNhanVien, "4");
        pnCard.add(pnKhachHang, "5");
        pnCard.add(pnThongKe, "6");
        
        //Panel bán hàng
        banHangPanel = new PnBanHang();
        pnBanHang.setLayout(new BorderLayout());
        pnBanHang.add(banHangPanel, BorderLayout.CENTER);
        //Panel hoa don
        hoaDonPanel = new PnHoaDon();
        pnHoaDon.setLayout(new BorderLayout());
        pnHoaDon.add(hoaDonPanel, BorderLayout.CENTER);

        //======XỬ LÝ PHÂN QUYỀN=======
//        PhanQuyen quyen = PhanQuyenBUS.quyenTK;

        if (Login.tkLogin.getCapBac()==2) {
            sanPhamPanel = new PnSanPham();
            pnSanPham.setLayout(new BorderLayout());
            pnSanPham.add(sanPhamPanel, BorderLayout.CENTER);
            lblSanPham.setVisible(true);
        }

        if (Login.tkLogin.getCapBac()==2) {
            nhanVienPanel = new PnNhanVien();
            pnNhanVien.setLayout(new BorderLayout());
            pnNhanVien.add(nhanVienPanel, BorderLayout.CENTER);
            lblNhanVien.setVisible(true);
        }

        if (Login.tkLogin.getCapBac()==2) {
            khachHangPanel = new PnKhachHang();
            pnKhachHang.setLayout(new BorderLayout());
            pnKhachHang.add(khachHangPanel, BorderLayout.CENTER);
            lblKhachHang.setVisible(true);
        }

        if (Login.tkLogin.getCapBac()==2) {
            thongKePanel = new PnThongKe();
            pnThongKe.setLayout(new BorderLayout());
            pnThongKe.add(thongKePanel, BorderLayout.CENTER);
            lblThongKe.setVisible(true);
        }
        pnMain.add(pnCard);
        /*
        ============================================================
                                CARD PANEL           
        ============================================================
         */
        con.add(pnMain);
    }

    int xMouse, yMouse;

    private void addEvents() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                moverFrame(e.getXOnScreen(), e.getYOnScreen());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });

        for (JLabel lbl : listMenuLeft) {
            lbl.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JLabel lblDisable : listMenuLeft) {
                        lblDisable.setBackground(clLeftItem);
                    }
                    lbl.setBackground(clLeftItemSelected);

                    // Xử lý lật trang theo menu
                    String cardName = "";
                    if (lbl == lblBanHang) {
                        cardName = "1";
                    }else if (lbl == lblHoaDon) {
                        cardName = "2";
                    }else if (lbl == lblSanPham) {
                        cardName = "3";
                    } else if (lbl == lblNhanVien) {
                        cardName = "4";
                    } else if (lbl == lblKhachHang) {
                        cardName = "5";
                    } else {
                        cardName = "6";
                    }
                    cardMenuLeftGroup.show(pnCard, cardName);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (lbl.getBackground().equals(clLeftItem)) {
                        lbl.setBackground(clLeftItemHover);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (lbl.getBackground().equals(clLeftItemHover)) {
                        lbl.setBackground(clLeftItem);
                    }
                }
            });
        }

    }

    private void moverFrame(int x, int y) {
        this.setLocation(x - xMouse, y - yMouse);
    }

    private void thuNhoFrame() {
        this.setState(Frame.ICONIFIED);
    }

    private void thoatChuongTrinh() {
        this.dispose();
        System.exit(0);
    }

}

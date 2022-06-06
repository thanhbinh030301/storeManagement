/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;
import StoreManagement.DAO.TaiKhoanDAO;
import StoreManagement.DTO.TaiKhoan;
import javax.swing.JOptionPane;
/**
 *
 * @author thanh
 */
public class TaiKhoanBUS {
    TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    public TaiKhoan login(String userName, String password){
        if (userName.trim().equals("")||password.trim().equals("")) {
            return null;
        }
        return tkDAO.login(userName, password);
    }
    public boolean checkUserName(String user) {
        return tkDAO.checkUserName(user);
    }

    public boolean addTaiKhoan (String userName, String passWord, String maNV) {
        if (userName.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để rỗng!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (checkUserName(userName)) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        boolean flag = tkDAO.addTaiKhoan(userName, passWord, maNV);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Cấp tài khoản thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cấp tài khoản thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return flag;
    }
    public String getUserById(String maNv){
        return tkDAO.getUserById(maNv);
    }
}

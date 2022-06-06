/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.BUS;
import StoreManagement.DAO.TaiKhoanDAO;
import StoreManagement.DTO.TaiKhoan;
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
}

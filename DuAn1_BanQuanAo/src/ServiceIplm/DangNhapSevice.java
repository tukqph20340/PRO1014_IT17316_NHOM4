/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.DangNhapMoDel;
import Repository.DangNhapRepository;
import ServiceITF.DangNhapITF;

/**
 *
 * @author fptshop
 */
public class DangNhapSevice implements DangNhapITF{
private DangNhapRepository dn = new DangNhapRepository();
    @Override
    public boolean XacThucMatKhau(String TaiKhoan, String MatKhau) {
        DangNhapMoDel dn1 = dn.XacThucTaiKhoan(TaiKhoan);
        if (dn1 != null) {
            return dn1.getMatKhau().equalsIgnoreCase(MatKhau);
        }
        return false;
    }
    
}

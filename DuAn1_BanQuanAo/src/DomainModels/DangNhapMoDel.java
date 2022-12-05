/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author fptshop
 */
public class DangNhapMoDel {
    private String TaiKhoan;
    private String MatKhau;

    public DangNhapMoDel() {
    }

    public DangNhapMoDel(String TaiKhoan, String MatKhau) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    @Override
    public String toString() {
        return "DangNhap{" + "TaiKhoan=" + TaiKhoan + ", MatKhau=" + MatKhau + '}';
    }
    
    
}

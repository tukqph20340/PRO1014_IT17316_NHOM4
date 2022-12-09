/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.logging.Logger;

/**
 *
 * @author fptshop
 */
public class DangNhapMoDel {
    private String TaiKhoan;
    private String MatKhau;
    private String MaNv;
    private String HoVaTen;
    public DangNhapMoDel() {
    }

    public DangNhapMoDel(String TaiKhoan, String MatKhau, String MaNv, String HoVaTen) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.MaNv = MaNv;
        this.HoVaTen = HoVaTen;
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

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    @Override
    public String toString() {
        return "DangNhapMoDel{" + "TaiKhoan=" + TaiKhoan + ", MatKhau=" + MatKhau + ", MaNv=" + MaNv + ", HoVaTen=" + HoVaTen + '}';
    }
  
   

   
}

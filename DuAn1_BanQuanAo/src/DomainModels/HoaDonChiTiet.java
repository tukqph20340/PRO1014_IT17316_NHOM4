/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author fptshop
 */
public class HoaDonChiTiet {

    private String MaHD;
    private String MaSP;
    private String SoLuong;
    private String TongTien;
    private String TienKhachDua;
    private String TienThua;
    private String TrangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHD, String MaSP, String SoLuong, String TongTien, String TienKhachDua, String TienThua, String TrangThai) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.TienKhachDua = TienKhachDua;
        this.TienThua = TienThua;
        this.TrangThai = TrangThai;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

    public String getTienKhachDua() {
        return TienKhachDua;
    }

    public void setTienKhachDua(String TienKhachDua) {
        this.TienKhachDua = TienKhachDua;
    }

    public String getTienThua() {
        return TienThua;
    }

    public void setTienThua(String TienThua) {
        this.TienThua = TienThua;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "MaHD=" + MaHD + ", MaSP=" + MaSP + ", SoLuong=" + SoLuong + ", TongTien=" + TongTien + ", TienKhachDua=" + TienKhachDua + ", TienThua=" + TienThua + ", TrangThai=" + TrangThai + '}';
    }
    
}

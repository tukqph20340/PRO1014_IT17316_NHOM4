/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

/**
 *
 * @author vitam
 */
public class hoaDonCt_Views {
     private String MaHD;
    private String MaSP;
    private int SoLuong;
    private int tongTien;
    private int tienkhachDua;
    private int tienThua;
    private String trangThai;

    public hoaDonCt_Views() {
    }

    public hoaDonCt_Views(String MaHD, String MaSP, int SoLuong, int tongTien, int tienkhachDua, int tienThua, String trangThai) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.tongTien = tongTien;
        this.tienkhachDua = tienkhachDua;
        this.tienThua = tienThua;
        this.trangThai = trangThai;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTienkhachDua() {
        return tienkhachDua;
    }

    public void setTienkhachDua(int tienkhachDua) {
        this.tienkhachDua = tienkhachDua;
    }

    public int getTienThua() {
        return tienThua;
    }

    public void setTienThua(int tienThua) {
        this.tienThua = tienThua;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author fptshop
 */
public class ThanhToan {

    private String MaHD;
    private String MaKH;
    private String MaND;
    private String NgayTao;
    private String NgayHuy;
    private String NgayThanhToan;
    private String TrangThai;
      private String MaHDCT;
    private String MaSP;
    private String SoLuong;
    private String TongTien;
    private String TienKhachDua;
    private String TienThua;
    private String TrangThaiCT;

    public ThanhToan() {
    }

    public ThanhToan(String MaHD, String MaKH, String MaND, String NgayTao, String NgayHuy, String NgayThanhToan, String TrangThai, String MaHDCT, String MaSP, String SoLuong, String TongTien, String TienKhachDua, String TienThua, String TrangThaiCT) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaND = MaND;
        this.NgayTao = NgayTao;
        this.NgayHuy = NgayHuy;
        this.NgayThanhToan = NgayThanhToan;
        this.TrangThai = TrangThai;
        this.MaHDCT = MaHDCT;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.TienKhachDua = TienKhachDua;
        this.TienThua = TienThua;
        this.TrangThaiCT = TrangThaiCT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgayHuy() {
        return NgayHuy;
    }

    public void setNgayHuy(String NgayHuy) {
        this.NgayHuy = NgayHuy;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(String MaHDCT) {
        this.MaHDCT = MaHDCT;
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

    public String getTrangThaiCT() {
        return TrangThaiCT;
    }

    public void setTrangThaiCT(String TrangThaiCT) {
        this.TrangThaiCT = TrangThaiCT;
    }

    @Override
    public String toString() {
        return "ThanhToan{" + "MaHD=" + MaHD + ", MaKH=" + MaKH + ", MaND=" + MaND + ", NgayTao=" + NgayTao + ", NgayHuy=" + NgayHuy + ", NgayThanhToan=" + NgayThanhToan + ", TrangThai=" + TrangThai + ", MaHDCT=" + MaHDCT + ", MaSP=" + MaSP + ", SoLuong=" + SoLuong + ", TongTien=" + TongTien + ", TienKhachDua=" + TienKhachDua + ", TienThua=" + TienThua + ", TrangThaiCT=" + TrangThaiCT + '}';
    }


}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author fptshop
 */
public class HoaDon {

    private String MaHD;
    private String MaKH;
    private String MaND;
    private String NgayTao;
    private String NgayHuy;
    private String NgayThanhToan;
    private String TrangThai;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaKH, String MaND, String NgayTao, String NgayHuy, String NgayThanhToan, String TrangThai) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaND = MaND;
        this.NgayTao = NgayTao;
        this.NgayHuy = NgayHuy;
        this.NgayThanhToan = NgayThanhToan;
        this.TrangThai = TrangThai;
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

    @Override
    public String toString() {
        return "HoaDon{" + "MaHD=" + MaHD + ", MaKH=" + MaKH + ", MaND=" + MaND + ", NgayTao=" + NgayTao + ", NgayHuy=" + NgayHuy + ", NgayThanhToan=" + NgayThanhToan + ", TrangThai=" + TrangThai + '}';
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author DELL
 */
public class HoaDon {

    private String maHD;
    private String maKH;
    private String maND;
    private String tenND;
    private String ngayTao;
    private String ngayHuy;
    private String ngayThanhToan;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maKH, String maND, String tenND, String ngayTao, String ngayHuy, String ngayThanhToan, String trangThai) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maND = maND;
        this.tenND = tenND;
        this.ngayTao = ngayTao;
        this.ngayHuy = ngayHuy;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayHuy() {
        return ngayHuy;
    }

    public void setNgayHuy(String ngayHuy) {
        this.ngayHuy = ngayHuy;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author DELL
 */
public class SanPham {

    String maSP;
    String maCH;
    String maNCC;
    String tenMau;
    String tenSize;
    String tenDanhMuc;
    String tenChatLieu;
    String tenKieuDang;
    String tenSP;
    String ngaySX;
    int giaNhap;
    int giaBan;
    int soLuong;
    String trangThai;

    public SanPham() {
    }

    public SanPham(String maSP, String maCH, String maNCC, String tenMau, String tenSize, String tenDanhMuc, String tenChatLieu, String tenKieuDang, String tenSP, String ngaySX, int giaNhap, int giaBan, int soLuong, String trangThai) {
        this.maSP = maSP;
        this.maCH = maCH;
        this.maNCC = maNCC;
        this.tenMau = tenMau;
        this.tenSize = tenSize;
        this.tenDanhMuc = tenDanhMuc;
        this.tenChatLieu = tenChatLieu;
        this.tenKieuDang = tenKieuDang;
        this.tenSP = tenSP;
        this.ngaySX = ngaySX;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getTenKieuDang() {
        return tenKieuDang;
    }

    public void setTenKieuDang(String tenKieuDang) {
        this.tenKieuDang = tenKieuDang;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(String ngaySX) {
        this.ngaySX = ngaySX;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", maCH=" + maCH + ", maNCC=" + maNCC + ", tenMau=" + tenMau + ", tenSize=" + tenSize + ", tenDanhMuc=" + tenDanhMuc + ", tenChatLieu=" + tenChatLieu + ", tenKieuDang=" + tenKieuDang + ", tenSP=" + tenSP + ", ngaySX=" + ngaySX + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", trangThai=" + trangThai + '}';
    }

    public String htTrangThai() {
        if (soLuong > 0) {
            setTrangThai("Còn Hàng");
        } else {
            setTrangThai("Hết Hàng");
        }
        return getTrangThai();
    }

}

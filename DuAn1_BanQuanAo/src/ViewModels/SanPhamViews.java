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
public class SanPhamViews {
    private String MaSP;
    private String TenSP;
    private String DanhMuc;
    private String Mau;
    private String size;
    private String chatLieu;
    private String kieuDang;
    private int giaBan;
    private int soLuong;

    public SanPhamViews() {
    }

    public SanPhamViews(String MaSP, String TenSP, String DanhMuc, String Mau, String size, String chatLieu, String kieuDang, int giaBan, int soLuong) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DanhMuc = DanhMuc;
        this.Mau = Mau;
        this.size = size;
        this.chatLieu = chatLieu;
        this.kieuDang = kieuDang;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }



    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getDanhMuc() {
        return DanhMuc;
    }

    public void setDanhMuc(String DanhMuc) {
        this.DanhMuc = DanhMuc;
    }

    public String getMau() {
        return Mau;
    }

    public void setMau(String Mau) {
        this.Mau = Mau;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public float getGiaBan() {
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
    public Object[] data(){
        return new Object[]{
        MaSP,TenSP,DanhMuc,Mau,size,chatLieu,kieuDang,giaBan,soLuong
        };
    }

    @Override
    public String toString() {
        return "SanPhamViews{" + "MaSP=" + MaSP + ", TenSP=" + TenSP + ", DanhMuc=" + DanhMuc + ", Mau=" + Mau + ", size=" + size + ", chatLieu=" + chatLieu + ", kieuDang=" + kieuDang + ", giaBan=" + giaBan + ", soLuong=" + soLuong + '}';
    }
    
}

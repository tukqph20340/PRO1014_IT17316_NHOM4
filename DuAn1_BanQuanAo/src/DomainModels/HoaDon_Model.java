/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModels;

/**
 *
 * @author vitam
 */
public class HoaDon_Model {
    private String MaHD;
    private String MaKH;
    private String MaND;
    private String NgayTao;
    private String ngayHuy;
    private String NgayThanhToan;
    private int trangThai;

    public HoaDon_Model() {
    }

    public HoaDon_Model(String MaHD, String MaKH, String MaND, String NgayTao, String ngayHuy, String NgayThanhToan, int trangThai) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaND = MaND;
        this.NgayTao = NgayTao;
        this.ngayHuy = ngayHuy;
        this.NgayThanhToan = NgayThanhToan;
        this.trangThai = trangThai;
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
        return ngayHuy;
    }

    public void setNgayHuy(String ngayHuy) {
        this.ngayHuy = ngayHuy;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    public String trangThaiHD(){
        if(this.trangThai==0){
            return "Chưa Thanh Toán";
        }
        return "";
    }
    public Object[] data(){
        return new Object[]{MaHD,MaKH,MaND,NgayTao,ngayHuy,NgayThanhToan,trangThai};
    }
}

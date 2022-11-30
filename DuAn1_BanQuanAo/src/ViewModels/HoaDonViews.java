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
public class HoaDonViews {
    private String MaHD;
    private String MaKH;
    private String tenKH;
    private String NgayTao;

    public HoaDonViews() {
    }

    public HoaDonViews(String MaHD, String MaKH, String tenKH, String NgayTao) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.tenKH = tenKH;
        this.NgayTao = NgayTao;
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

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
    public Object[] data(){
        return new Object[]{MaHD,MaKH,tenKH,NgayTao};
    }
}

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
public class NhanVien_Views {
     private String MaND;
    private String MaCH;
    private String HoVaTen;
    private String gioiTinh;
    private String ChucVu;
    private String Sdt;
    private String diaChi;
    private String usename;
    private String password;
    private String ngaysinh;

    public NhanVien_Views() {
    }

    public NhanVien_Views(String MaND, String MaCH, String HoVaTen, String gioiTinh, String ChucVu, String Sdt, String diaChi, String usename, String password, String ngaysinh) {
        this.MaND = MaND;
        this.MaCH = MaCH;
        this.HoVaTen = HoVaTen;
        this.gioiTinh = gioiTinh;
        this.ChucVu = ChucVu;
        this.Sdt = Sdt;
        this.diaChi = diaChi;
        this.usename = usename;
        this.password = password;
        this.ngaysinh = ngaysinh;
    }
    

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getMaCH() {
        return MaCH;
    }

    public void setMaCH(String MaCH) {
        this.MaCH = MaCH;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Override
    public String toString() {
        return "NhanVien_Model{" + "MaND=" + MaND + ", MaCH=" + MaCH + ", HoVaTen=" + HoVaTen + ", gioiTinh=" + gioiTinh + ", ChucVu=" + ChucVu + ", Sdt=" + Sdt + ", diaChi=" + diaChi + ", usename=" + usename + ", password=" + password + ", ngaysinh=" + ngaysinh + '}';
    }
    
}

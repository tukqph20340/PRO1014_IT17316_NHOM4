/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author fptshop
 */
public class KhachHangView {
    private String MaKH;
    private String HoVaTen ;
    private String Sdt;
    private String NgaySinh;
    private String ThanhPho;

    public KhachHangView() {
    }

    public KhachHangView(String MaKH, String HoVaTen, String Sdt, String NgaySinh, String ThanhPho) {
        this.MaKH = MaKH;
        this.HoVaTen = HoVaTen;
        this.Sdt = Sdt;
        this.NgaySinh = NgaySinh;
        this.ThanhPho = ThanhPho;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String ThanhPho) {
        this.ThanhPho = ThanhPho;
    }

    @Override
    public String toString() {
        return "KhachHangView{" + "MaKH=" + MaKH + ", HoVaTen=" + HoVaTen + ", Sdt=" + Sdt + ", NgaySinh=" + NgaySinh + ", ThanhPho=" + ThanhPho + '}';
    }
     

}
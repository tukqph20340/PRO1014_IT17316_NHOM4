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
public class KieuDangViews {
    private String MaKD;
    private String tenKD;

    public KieuDangViews() {
    }

    public KieuDangViews(String MaKD, String tenKD) {
        this.MaKD = MaKD;
        this.tenKD = tenKD;
    }

    public String getMaKD() {
        return MaKD;
    }

    public void setMaKD(String MaKD) {
        this.MaKD = MaKD;
    }

    public String getTenKD() {
        return tenKD;
    }

    public void setTenKD(String tenKD) {
        this.tenKD = tenKD;
    }
    
}

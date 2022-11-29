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
public class KieuDang_ViewModel {
       private String MaKD;
    private String TenKieuDang;

    public KieuDang_ViewModel() {
    }

    public KieuDang_ViewModel(String MaKD, String TenKieuDang) {
        this.MaKD = MaKD;
        this.TenKieuDang = TenKieuDang;
    }

    public String getMaKD() {
        return MaKD;
    }

    public void setMaKD(String MaKD) {
        this.MaKD = MaKD;
    }

    public String getTenKieuDang() {
        return TenKieuDang;
    }

    public void setTenKieuDang(String TenKieuDang) {
        this.TenKieuDang = TenKieuDang;
    }
    public Object[] data(){
        return new Object[]{MaKD,TenKieuDang};
    }
}

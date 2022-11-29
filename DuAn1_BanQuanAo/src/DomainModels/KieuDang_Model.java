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
public class KieuDang_Model {
    private String MaKD;
    private String TenKieuDang;

    public KieuDang_Model() {
    }

    public KieuDang_Model(String MaKD, String TenKieuDang) {
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

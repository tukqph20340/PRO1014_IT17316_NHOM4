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
    private String TenKD;

    public KieuDang_Model() {
    }

    public KieuDang_Model(String MaKD, String TenKD) {
        this.MaKD = MaKD;
        this.TenKD = TenKD;
    }

    public String getMaKD() {
        return MaKD;
    }

    public void setMaKD(String MaKD) {
        this.MaKD = MaKD;
    }

    public String getTenKD() {
        return TenKD;
    }

    public void setTenKD(String TenKD) {
        this.TenKD = TenKD;
    }
    public Object[] data(){
    return new Object[]{MaKD,TenKD};
}
}

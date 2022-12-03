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
public class DanhMuc_model {
    private String MaDM;
    private String TenDM;
    String a;

   
    public DanhMuc_model() {
    }

    public DanhMuc_model(String MaDM, String TenDM) {
        this.MaDM = MaDM;
        this.TenDM = TenDM;
    }

    public String getMaDM() {
        return MaDM;
    }

    public void setMaDM(String MaDM) {
        this.MaDM = MaDM;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }
    public Object[] data(){
        return new Object[]{MaDM,TenDM};
    }
}

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
public class DanhMucViews {
    private String MaDM;
    private String tenDM;

    public DanhMucViews() {
    }

    public DanhMucViews(String MaDM, String tenDM) {
        this.MaDM = MaDM;
        this.tenDM = tenDM;
    }

    public String getMaDM() {
        return MaDM;
    }

    public void setMaDM(String MaDM) {
        this.MaDM = MaDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }
    
}

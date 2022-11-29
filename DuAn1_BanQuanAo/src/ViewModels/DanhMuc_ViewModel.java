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
public class DanhMuc_ViewModel {
     private String MaDanhMuc;
    private String TendanhMuc;

    public DanhMuc_ViewModel() {
    }

    public DanhMuc_ViewModel(String MaDanhMuc, String TendanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
        this.TendanhMuc = TendanhMuc;
    }

    public String getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(String MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public String getTendanhMuc() {
        return TendanhMuc;
    }

    public void setTendanhMuc(String TendanhMuc) {
        this.TendanhMuc = TendanhMuc;
    }
    public Object[] data(){
        return new Object[]{MaDanhMuc,TendanhMuc};
    }
}

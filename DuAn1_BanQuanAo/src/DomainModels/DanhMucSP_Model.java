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
public class DanhMucSP_Model {

    private String MaDanhMuc;
    private String TendanhMuc;

    public DanhMucSP_Model() {
    }

    public DanhMucSP_Model(String MaDanhMuc, String TendanhMuc) {
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

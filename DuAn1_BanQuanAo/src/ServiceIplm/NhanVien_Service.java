/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import DomainModels.NhanVien_Model;
import Repository.NhanVien_Reposytory;
import ServiceITF.NhanVien_ITF;
import java.util.List;

/**
 *
 * @author vitam
 */
public class NhanVien_Service implements NhanVien_ITF{
    NhanVien_Reposytory nv1 = new NhanVien_Reposytory();

    @Override
    public List<NhanVien_Model> getallformNhanVien() {
        return nv1.getallformNhanVien();
    }

   

    @Override
    public String XoaNhanVien(String ma) {
       return nv1.XoaNhanVien(ma);
    }

    @Override
    public String SuaNhanVien(NhanVien_Model nv) {
        return nv1.SuaNhanVien(nv);
    }

    @Override
    public String addNhanVien(NhanVien_Model nv) {
       return nv1.addNhanVien(nv);
    }
    
}

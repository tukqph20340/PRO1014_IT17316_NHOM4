/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceITF;

import DomainModels.NhanVien_Model;
import java.util.List;

/**
 *
 * @author vitam
 */
public interface NhanVien_ITF {
     public List<NhanVien_Model> getallformNhanVien();
     public String addNhanVien(NhanVien_Model nv);
     public String XoaNhanVien(String ma);
             public String SuaNhanVien(NhanVien_Model nv);
}

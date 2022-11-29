/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceITF;

import DomainModels.DanhMucSP_Model;
import java.util.List;

/**
 *
 * @author vitam
 */
public interface DanhMucITF {
      public List<DanhMucSP_Model> getAllDanhMucSP();
      public List<DanhMucSP_Model> getAllForm();
     public String ADDDanhMucSP(DanhMucSP_Model dm);
      public String XoaDanhMucSP(String Ma);
      public String UpdateDanhMucSP(DanhMucSP_Model dm);
      
}

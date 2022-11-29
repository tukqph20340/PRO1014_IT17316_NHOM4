/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import DomainModels.DanhMucSP_Model;
import Repository.DanhMucSP_Reponsitory;
import ServiceITF.DanhMucITF;
import ViewModels.DanhMuc_ViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vitam
 */
public class DanhMuc_Service implements DanhMucITF{
    DanhMucSP_Reponsitory dmsp = new DanhMucSP_Reponsitory();
    @Override
    public List<DanhMucSP_Model> getAllDanhMucSP() {
        try {
            List<DanhMuc_ViewModel> listDM = new ArrayList<>();
            List<DanhMucSP_Model> dm = dmsp.getAllDanhMucSP();
            for (DanhMucSP_Model danhMucSP_Model : dm) {
                DanhMuc_ViewModel v = new DanhMuc_ViewModel(
                danhMucSP_Model.getMaDanhMuc(),
                danhMucSP_Model.getTendanhMuc()
                );
                listDM.add(v);
            }
            return dm;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi hiển thị");
        }
        return null;
    }
    

    @Override
    public String ADDDanhMucSP(DanhMucSP_Model dm) {
        try {
            return dmsp.ADDDanhMucSP(dm);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String XoaDanhMucSP(String Ma) {
        try {
            return dmsp.XoaDanhMucSP(Ma);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String UpdateDanhMucSP(DanhMucSP_Model dm) {
      try {
            return dmsp.UpdateDanhMucSP(dm);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<DanhMucSP_Model> getAllForm() {
        try {
            return dmsp.getAllDanhMucSP();
        } catch (Exception e) {
            return null;
        }
    }
    
}

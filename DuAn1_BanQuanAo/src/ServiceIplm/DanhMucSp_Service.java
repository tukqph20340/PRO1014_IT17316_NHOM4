/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import DomainModels.DanhMuc_model;
import Repository.DanhMucSP_Repository;
import ServiceITF.DanhMucITF;
import ViewModels.DanhMucViews;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitam
 */
public class DanhMucSp_Service implements DanhMucITF {

    DanhMucSP_Repository dm1 = new DanhMucSP_Repository();

    @Override
    public List<DanhMuc_model> getAllformDM() {
        try {
            List<DanhMucViews> listDM = new ArrayList<>();
            List<DanhMuc_model> dm = dm1.getAllformDM();
            for (DanhMuc_model danhMuc_model : dm) {
                DanhMucViews view = new DanhMucViews(
                        danhMuc_model.getMaDM(),
                        danhMuc_model.getTenDM()
                );
                listDM.add(view);
            }
            return dm;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DanhMuc_model> getAllform() {
        try {
            return dm1.getAllformDM();
        } catch (Exception e) {
            return null;
        }
        }

    @Override
    public String addForm(DanhMuc_model model) {
         try {
            return dm1.addForm(model);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String DeleteForm(String ma) {
        try {
            return dm1.DeleteForm(ma);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String UpdateForm(DanhMuc_model model) {
        try {
            return dm1.UpdateForm(model);
        } catch (Exception e) {
            return null;
        }
    }

}

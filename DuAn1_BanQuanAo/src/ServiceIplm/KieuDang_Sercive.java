/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import DomainModels.KieuDang_Model;
import Repository.KieuDang_Res;
import ServiceITF.KieuDangITF;
import ViewModels.KieuDangViews;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitam
 */
public class KieuDang_Sercive implements KieuDangITF {

    KieuDang_Res res = new KieuDang_Res();

    @Override
    public List<KieuDang_Model> getAllformDM() {
        try {
            List<KieuDangViews> list = new ArrayList<>();
            List<KieuDang_Model> ml = res.getAllformDM();
            for (KieuDang_Model kieuDang_Model : ml) {
                KieuDangViews view = new KieuDangViews(
                        kieuDang_Model.getMaKD(),
                        kieuDang_Model.getTenKD()
                );
                list.add(view);
            }
            return ml;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<KieuDang_Model> getAllform() {
        try {
            return res.getAllformDM();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String addForm(KieuDang_Model model) {
        try {
            return res.addForm(model);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String DeleteForm(String ma) {
       try {
            return res.DeleteForm(ma);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String UpdateForm(KieuDang_Model model) {
         try {
            return res.UpdateForm(model);
        } catch (Exception e) {
            return null;
        }
    }

}

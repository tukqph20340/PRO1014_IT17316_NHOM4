/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import DomainModels.KieuDang_Model;
import DomainModels.KieuDang_Model;
import Repository.KieuDang_Reponsitory;
import ServiceITF.KieuDangITF;
import ViewModels.KieuDang_ViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vitam
 */
public class KieuDang_Service implements KieuDangITF {

    KieuDang_Reponsitory kd1 = new KieuDang_Reponsitory();

    @Override
    public List<KieuDang_Model> getAllFormKieuDang() {
        try {
            List<KieuDang_ViewModel> listKD = new ArrayList<>();
            List<KieuDang_Model> dm = kd1.getAllFormKieuDang();
            for (KieuDang_Model kieuDang_Model : dm) {
                KieuDang_ViewModel v = new KieuDang_ViewModel(
                        kieuDang_Model.getMaKD(),
                        kieuDang_Model.getTenKieuDang()
                );
                listKD.add(v);
            }

            return dm;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi hiển thị");
        }
        return null;
    }

    @Override
    public String ADDDKieuDang(KieuDang_Model kd) {
        try {
            return kd1.ADDDKieuDang(kd);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String XoaKieuDang(String Ma) {
        try {
            return kd1.XoaKieuDang(Ma);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String UpdateKieuDang(KieuDang_Model dm) {
        try {
            return kd1.UpdateKieuDang(dm);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KieuDang_Model> getAllFormKD() {
        try {
            return kd1.getAllFormKieuDang();
        } catch (Exception e) {
            return null;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceITF;

import DomainModels.KieuDang_Model;
import java.util.List;

/**
 *
 * @author vitam
 */
public interface KieuDangITF {

    public List<KieuDang_Model> getAllFormKieuDang();
    
    public List<KieuDang_Model> getAllFormKD();

    public String ADDDKieuDang(KieuDang_Model kd);

    public String XoaKieuDang(String Ma);

    public String UpdateKieuDang(KieuDang_Model dm);
}

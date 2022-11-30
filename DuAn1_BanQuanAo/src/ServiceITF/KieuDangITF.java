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

    public List<KieuDang_Model> getAllformDM();

    public List<KieuDang_Model> getAllform();

    public String addForm(KieuDang_Model model);

    public String DeleteForm(String ma);

    public String UpdateForm(KieuDang_Model model);
}

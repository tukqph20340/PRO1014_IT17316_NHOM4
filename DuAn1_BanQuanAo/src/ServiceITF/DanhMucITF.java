/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceITF;

import DomainModels.DanhMuc_model;
import java.util.List;

/**
 *
 * @author vitam
 */
public interface DanhMucITF {

    public List<DanhMuc_model> getAllformDM();

    public List<DanhMuc_model> getAllform();

    public String addForm(DanhMuc_model model);

    public String DeleteForm(String ma);

    public String UpdateForm(DanhMuc_model model);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceITF;

import DomainModels.NhaCungCap_Model;
import Repository.NhaCungCap_Repository;
import java.util.List;

/**
 *
 * @author vitam
 */
public interface nhacungcap_ITF {
    public List<NhaCungCap_Model> getallFormNhaCC();
    public String addNCC(NhaCungCap_Model nc);
    public String DeleteNCC(NhaCungCap_Model nc);
    public String updateNCC(NhaCungCap_Model nc);
    
}

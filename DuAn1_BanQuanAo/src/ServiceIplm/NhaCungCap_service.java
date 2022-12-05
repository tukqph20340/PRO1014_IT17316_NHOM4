/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import DomainModels.NhaCungCap_Model;
import Repository.NhaCungCap_Repository;
import ServiceITF.nhacungcap_ITF;
import java.util.List;

/**
 *
 * @author vitam
 */
public class NhaCungCap_service implements nhacungcap_ITF{
    NhaCungCap_Repository ncc = new NhaCungCap_Repository();

    public NhaCungCap_service() {
    }

    @Override
    public List<NhaCungCap_Model> getallFormNhaCC() {
        return ncc.getallFormNhaCC();
    }

    @Override
    public String addNCC(NhaCungCap_Model nc) {
        return ncc.addNCC(nc);
    }

    @Override
    public String DeleteNCC(NhaCungCap_Model nc) {
       return ncc.DeleteNCC(nc);
    }

    @Override
    public String updateNCC(NhaCungCap_Model nc) {
       return ncc.updateNCC(nc);
    }
}

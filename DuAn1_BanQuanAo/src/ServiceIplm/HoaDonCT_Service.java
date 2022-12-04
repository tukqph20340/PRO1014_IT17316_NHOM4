/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import DomainModels.HoaDonCT_Model;
import Repository.HoaDonChiTiet_Repository;
import ServiceITF.hoaDonCT_ITF;
import java.util.List;

/**
 *
 * @author vitam
 */
public class HoaDonCT_Service implements hoaDonCT_ITF{
    HoaDonChiTiet_Repository hdct = new HoaDonChiTiet_Repository();
    @Override
    public List<HoaDonCT_Model> getAllFormHDCT() {
        return hdct.getAllFormHDCT();
    }


    
}

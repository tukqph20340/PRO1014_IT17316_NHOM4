/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import Repository.HoaDon_Respository;
import ServiceITF.HoaDonITF;
import ViewModels.HoaDonViews;
import java.util.List;

/**
 *
 * @author vitam
 */
public class HoaDon_Service implements HoaDonITF{
    HoaDon_Respository hd = new HoaDon_Respository();
    @Override
    public List<HoaDonViews> getAllFormHoaDon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDonViews> getAllForm() {
        try {
            return hd.getAllFormHoaDon();
        } catch (Exception e) {
            return null;
        }
    }
    
}

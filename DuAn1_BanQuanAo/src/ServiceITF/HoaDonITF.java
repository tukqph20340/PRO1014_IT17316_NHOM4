/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceITF;

import ViewModels.HoaDonViews;
import java.util.List;

/**
 *
 * @author vitam
 */
public interface HoaDonITF {
    public List<HoaDonViews> getAllFormHoaDon();
    public List<HoaDonViews> getAllForm();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceITF;

import ViewModels.SanPhamViews;
import java.util.List;

/**
 *
 * @author vitam
 */
public interface SanPhamITFinBanHang {
    public List<SanPhamViews> getAllSanPhamInBanHang();
    public List<SanPhamViews> getAllSanPham();
    public List<SanPhamViews> seachname(String name);
}
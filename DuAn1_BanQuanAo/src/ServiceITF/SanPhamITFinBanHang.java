/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceITF;

import DomainModels.SanPham;
import ViewModels.SanPhamViews;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitam
 */
public interface SanPhamITFinBanHang {

    public List<SanPhamViews> getAllSanPhamInBanHang();

    public List<SanPhamViews> getAllSanPham();

    public List<SanPhamViews> seachname(String name);

    public List<SanPhamViews> LocMau(String name);

    public List<SanPhamViews> LocSize(String name);

    public List<SanPhamViews> LocChatLieu(String name);

    public List<SanPhamViews> LocDanhMuc(String name);

    public List<SanPhamViews> LocKieuDang(String name);
    
    ArrayList<SanPham> getListTimKiem(String ma);
}

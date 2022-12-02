/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIplm;

import DomainModels.SanPham;
import Repository.SanPhaminBanHang_Repository;
import ServiceITF.SanPhamITFinBanHang;
import ViewModels.SanPhamViews;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitam
 */
public class SanPhamInBanHang_Service implements SanPhamITFinBanHang {

    SanPhaminBanHang_Repository sp = new SanPhaminBanHang_Repository();

//    @Override
//    public List<SanPhamViews> getAllSanPhamInBanHang() {
//        try {
//            List<SanPhamViews> a = sp.getAllSanPhamInBanHang();
//            List<SanPham> list = new ArrayList<>();
//            for (SanPham sanPham : list) {
//                SanPhamViews view = new SanPhamViews(
//                        sanPham.getMaSP(),
//                        sanPham.getMaSP(),
//                        sanPham.getTenSP(),
//                        sanPham.getTenDanhMuc(),
//                        sanPham.getTenMau(),
//                        sanPham.getTenSize(),
//                        sanPham.getTenChatLieu(),
//                        sanPham.getTenKieuDang(),
//                        sanPham.getGiaBan(),
//                        sanPham.getSoLuong()
//                );
//                a.add(view);
//            }
//            return a;
//        } catch (Exception e) {
//        }
//        return null;
//    }

    @Override
    public List<SanPhamViews> getAllSanPham() {
        try {
            return sp.getAllSanPhamInBanHang();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SanPhamViews> getAllSanPhamInBanHang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SanPhamViews> seachname(String name) {
       List<SanPhamViews> seachList= sp.seachname(name);
       return seachList;
    }

    @Override
    public List<SanPhamViews> LocMau(String name) {
        return sp.LocMau(name);
    }

    @Override
    public List<SanPhamViews> LocSize(String name) {
        return sp.LocSize(name);
    }

}

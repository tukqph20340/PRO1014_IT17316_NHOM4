/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Repository.ThemSuaThanhToanHoaDon;
import ServiceITF.ThemSuaThanhToanHoaDonINT;
import java.util.List;

/**
 *
 * @author fptshop
 */
public class ThemSuaThanhToanHoaDonImt implements ThemSuaThanhToanHoaDonINT{
    private ThemSuaThanhToanHoaDon list = new ThemSuaThanhToanHoaDon();

    @Override
    public List<HoaDon> insert(String MaHD, String MaKH, String MaND, String NgayTao,String TrangThai) {
        try {
            return list.insert(MaHD, MaKH, MaND, NgayTao, TrangThai);
        } catch (Exception e) {
            return null;
        }
    }

   

    @Override
    public List<HoaDonChiTiet> delete() {
        try {
            return list.delete();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoaDon> HuyHoaDon(String MaHD,String trangthai) {
         try {
            return list.HuyHoaDon(MaHD, trangthai);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<HoaDonChiTiet> ThanhToanHoaDonChiTiet(String MaHD,String trangthai) {
          try {
            return list.ThanhToanHoaDonChiTiet(MaHD, trangthai);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<HoaDon> ThanhToanHoa(String MaHD,String trangthai) {
         try {
            return list.ThanhToanHoaDon(MaHD, trangthai);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoaDonChiTiet> insertGH(String MaHD, String MaSP,  String TongTien, String TienKhachDua, String TienThua,String TrangThai) {
           try {
            return list.insertGH(MaHD, MaSP, TongTien, TienKhachDua, TienThua,TrangThai);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoaDonChiTiet> Huy(String MaHD,String trangthai) {
           try {
            return list.Huy(MaHD, trangthai);
        } catch (Exception e) {
            return null;
        }
    }
    
}

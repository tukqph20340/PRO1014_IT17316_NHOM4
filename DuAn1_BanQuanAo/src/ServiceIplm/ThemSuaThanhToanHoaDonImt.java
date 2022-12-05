/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.ThanhToan;

import Repository.ThemSuaThanhToanHoaDon;
import ServiceITF.ThemSuaThanhToanHoaDonINT;
import java.util.List;

/**
 *
 * @author fptshop
 */
public class ThemSuaThanhToanHoaDonImt implements ThemSuaThanhToanHoaDonINT {

    private ThemSuaThanhToanHoaDon list = new ThemSuaThanhToanHoaDon();

    @Override
    public List<ThanhToan> insert(String MaHD, String MaKH, String MaND, String NgayTao, String TrangThai) {
        try {
            return list.insert(MaHD, MaKH, MaND, NgayTao, TrangThai);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThanhToan> select(String ma2) {
        try {
            return list.select(ma2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThanhToan> HuyHoaDon(String MaHD, String NgayHuy, String TrangThai) {
        try {
            return list.HuyHoaDon(MaHD, NgayHuy, TrangThai);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThanhToan> ThanhToanHoaDonChiTiet(String MaHD, String tong, String tienkhachdua, String Tienthua, String TrangThai) {
        try {
            return list.ThanhToanHoaDonChiTiet(MaHD, tong, tienkhachdua, Tienthua, TrangThai);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThanhToan> ThanhToanHoa(String MaHD, String NgayHuy, String TrangThai) {
        try {
            return list.ThanhToanHoaDon(MaHD, NgayHuy, TrangThai);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThanhToan> insertGH(String MaHD, String MaSP, String SoLuong, String TongTien, String TienKhachDua, String TienThua, String TrangThai) {
        try {
            return list.insertGH(MaHD, MaSP, SoLuong, TongTien, TienKhachDua, TienThua, TrangThai);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThanhToan> Huy(String MaHD, String trangthai) {
        try {
            return list.Huy(MaHD, trangthai);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThanhToan> select() {
        try {
            return list.select();
        } catch (Exception e) {
            return null;
        }

    }
}

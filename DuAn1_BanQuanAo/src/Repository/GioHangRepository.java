/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChatLieu;
import DomainModels.GioHang;
import DomainModels.SanPham;
import Untility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class GioHangRepository {

    private DBConnection db;

    public ArrayList<GioHang> getListGH(String ma) {
        ArrayList<GioHang> list = new ArrayList<>();
        String sql = "select HoaDonChiTiet.MaSP, TenSP, HoaDonChiTiet.SoLuong, GiaBan from HoaDonChiTiet \n"
                + "join SanPham on HoaDonChiTiet.MaSP=SanPham.MaSP \n"
                + "join HoaDon on HoaDonChiTiet.MaHD=HoaDon.MaHD \n"
                + "where HoaDon.MaHD=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHang x = new GioHang();
                x.setMaSP(rs.getString(1));
                x.setTenSP(rs.getString(2));
                x.setSoLuong(rs.getInt(3));
                x.setDonGia(rs.getInt(4));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
public ArrayList<GioHang> getListGH() {
        ArrayList<GioHang> list = new ArrayList<>();
        String sql = "select HoaDonChiTiet.MaSP, TenSP, HoaDonChiTiet.SoLuong, GiaBan from HoaDonChiTiet \n"
                + "join SanPham on HoaDonChiTiet.MaSP=SanPham.MaSP \n"
                + "join HoaDon on HoaDonChiTiet.MaHD=HoaDon.MaHD ";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHang x = new GioHang();
                x.setMaSP(rs.getString(1));
                x.setTenSP(rs.getString(2));
                x.setSoLuong(rs.getInt(3));
                x.setDonGia(rs.getInt(4));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean tangHD(String ma, String maHD) {
        String sql = "update HoaDonChiTiet set SoLuong=SoLuong+1 where MaSP=? and MaHD=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.setObject(2, maHD);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean giamHD(String ma, String maHD) {
        String sql = "update HoaDonChiTiet set SoLuong=SoLuong-1 where MaSP=? and MaHD=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.setObject(2, maHD);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean tangSP(String ma) {
        String sql = "update SanPham set SoLuong=SoLuong+1 where MaSP=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean giamSP(String ma) {
        String sql = "update SanPham set SoLuong=SoLuong-1 where MaSP=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(String ma, String maHD) {
        String sql = "delete from HoaDonChiTiet where MaSP=? and MaHD=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.setObject(2, maHD);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean tangSoLuongSP(int so, String ma) {
        String sql = "update SanPham set SoLuong=Soluong+? where MaSP=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, so);
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean tangSoLuongGH(String ma, int so, String maHD) {
        String sql = "update HoaDonChiTiet set SoLuong=Soluong+? where MaSP=? and MaHD=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, so);
            ps.setObject(2, ma);
            ps.setObject(3, maHD);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean giamSoLuongSP(int so, String ma) {
        String sql = "update SanPham set SoLuong=Soluong-? where MaSP=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, so);
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean giamSoLuongGH(String ma, int so, String maHD) {
        String sql = "update HoaDonChiTiet set SoLuong=Soluong-? where MaSP=? and MaHD=?";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, so);
            ps.setObject(2, ma);
            ps.setObject(3, maHD);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themGH(GioHang x, int so) {
        String sql = "insert into HoaDonChiTiet (MaHD,MaSP,SoLuong) values (?,?,?)        ";
        try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, x.getMaHD());
            ps.setObject(2, x.getMaSP());
            ps.setObject(3, so);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}

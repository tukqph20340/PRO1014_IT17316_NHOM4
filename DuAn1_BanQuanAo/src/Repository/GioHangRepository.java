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
        String sql = "select HoaDonChiTiet.MaSP, TenSP, HoaDonChiTiet.SoLuong, TongTien, GiaBan from HoaDonChiTiet \n"
                + "join SanPham on HoaDonChiTiet.MaSP=SanPham.MaSP \n"
                + "join HoaDon on HoaDonChiTiet.MaHD=HoaDon.MaHD \n"
                + "where HoaDon.MaHD=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHang x = new GioHang();
                x.setMaSP(rs.getString(1));
                x.setTenSP(rs.getString(2));
                x.setSoLuong(Integer.parseInt(rs.getString(3)));
                x.setTongTien(Integer.parseInt(rs.getString(4)));
                x.setDonGia(Integer.parseInt(rs.getString(5)));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<GioHang> getListGH_SP(String ma){
        ArrayList<GioHang> list = new ArrayList<>();
        String sql = "select HoaDonChiTiet.MaSP, TenSP, HoaDonChiTiet.SoLuong, TongTien, GiaBan from HoaDonChiTiet \n"
                + "join SanPham on HoaDonChiTiet.MaSP=SanPham.MaSP \n"
                + "where SanPham.MaSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHang x = new GioHang();
                x.setMaSP(rs.getString(1));
                x.setTenSP(rs.getString(2));
                x.setSoLuong(Integer.parseInt(rs.getString(3)));
                x.setTongTien(Integer.parseInt(rs.getString(4)));
                x.setDonGia(Integer.parseInt(rs.getString(5)));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean tangHD(String ma){
        String sql="update HoaDonChiTiet set SoLuong=SoLuong+1 where MaSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean giamHD(String ma){
        String sql="update HoaDonChiTiet set SoLuong=SoLuong-1 where MaSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean tangSP(String ma){
        String sql="update SanPham set SoLuong=SoLuong+1 where MaSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean giamSP(String ma){
        String sql="update SanPham set SoLuong=SoLuong-1 where MaSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoa(String ma){
        String sql="delete from HoaDonChiTiet where MaSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDon;
import DomainModels.SanPham;
import Untility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDonRepository {

    private DBConnection db;

    public ArrayList<HoaDon> getListHD() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select MaHD, HoaDon.MaKH ,MaND, HoVaTen, NgayTao,NgayHuy,NgayThanhToan, TrangThai\n"
                + "from HoaDon join KhachHang on HoaDon.MaKH=KhachHang.MaKH";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                HoaDon x = new HoaDon();
                x.setMaHD(rs.getString(1));
                x.setMaKH(rs.getString(2));
                x.setMaND(rs.getString(3));
                x.setTenND(rs.getNString(4));
                x.setNgayTao(rs.getString(5));
                x.setNgayHuy(rs.getString(6));
                x.setNgayThanhToan(rs.getString(7));
                x.setTrangThai(rs.getString(8));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> getListLocHD(String tt) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select MaHD,HoaDon.MaKH,MaND, HoVaTen, NgayTao,NgayHuy,NgayThanhToan,TrangThai\n"
                + "from HoaDon join KhachHang on HoaDon.MaKH=KhachHang.MaKH where TrangThai=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon x = new HoaDon();
                x.setMaHD(rs.getString(1));
                x.setMaKH(rs.getString(2));
                x.setMaND(rs.getString(3));
                x.setTenND(rs.getNString(4));
                x.setNgayTao(rs.getString(5));
                x.setNgayHuy(rs.getString(6));
                x.setNgayThanhToan(rs.getString(7));
                x.setTrangThai(rs.getString(8));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> getListTimHD(String ma) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select MaHD, HoaDon.MaKH,MaND, HoVaTen, NgayTao, NgayHuy, NgayThanhToan, TrangThai\n"
                + "from HoaDon join KhachHang on HoaDon.MaKH=KhachHang.MaKH where MaHD=? or HoVaTen=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon x = new HoaDon();
                x.setMaHD(rs.getString(1));
                x.setMaKH(rs.getString(2));
                x.setMaND(rs.getString(3));
                x.setTenND(rs.getNString(4));
                x.setNgayTao(rs.getString(5));
                x.setNgayHuy(rs.getString(6));
                x.setNgayThanhToan(rs.getString(7));
                x.setTrangThai(rs.getString(8));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

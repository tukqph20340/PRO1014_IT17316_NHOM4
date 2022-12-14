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
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class HoaDonRepository {

    private DBConnection db;

    public ArrayList<HoaDon> getListHD() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select MaHD, KhachHang.HoVaTen, NguoiDung.HoVaTen, NgayTao,NgayHuy,NgayThanhToan,TrangThai\n"
                + " from HoaDon join KhachHang on HoaDon.MaKH=KhachHang.MaKH"
                + " join NguoiDung on HoaDon.MaND=NguoiDung.MaND";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                HoaDon x = new HoaDon();
                x.setMaHD(rs.getString(1));
                x.setMaKH(rs.getString(2));
                x.setMaND(rs.getString(3));
                x.setNgayTao(rs.getString(4));
                x.setNgayHuy(rs.getString(5));
                x.setNgayThanhToan(rs.getString(6));
                x.setTrangThai(rs.getString(7));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> getListLocHD(String tt) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select MaHD, KhachHang.HoVaTen, NguoiDung.HoVaTen, NgayTao,NgayHuy,NgayThanhToan,TrangThai\n"
                + " from HoaDon join KhachHang on HoaDon.MaKH=KhachHang.MaKH"
                + " join NguoiDung on HoaDon.MaND=NguoiDung.MaND where TrangThai=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon x = new HoaDon();
                x.setMaHD(rs.getString(1));
                x.setMaKH(rs.getString(2));
                x.setMaND(rs.getString(3));
                x.setNgayTao(rs.getString(4));
                x.setNgayHuy(rs.getString(5));
                x.setNgayThanhToan(rs.getString(6));
                x.setTrangThai(rs.getString(7));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> getListTimHD(String ma) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select MaHD, KhachHang.HoVaTen, NguoiDung.HoVaTen, NgayTao,NgayHuy,NgayThanhToan,TrangThai\n"
                + " from HoaDon join KhachHang on HoaDon.MaKH=KhachHang.MaKH"
                + " join NguoiDung on HoaDon.MaND=NguoiDung.MaND where MaHD=? or KhachHang.HoVaTen=? or NguoiDung.HoVaTen=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ps.setObject(3, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon x = new HoaDon();
                x.setMaHD(rs.getString(1));
                x.setMaKH(rs.getString(2));
                x.setMaND(rs.getString(3));
                x.setNgayTao(rs.getString(4));
                x.setNgayHuy(rs.getString(5));
                x.setNgayThanhToan(rs.getString(6));
                x.setTrangThai(rs.getString(7));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> getListTimNgayHD(String min, String max) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select MaHD, KhachHang.HoVaTen, NguoiDung.HoVaTen, NgayTao,NgayHuy,NgayThanhToan,TrangThai\n"
                + " from HoaDon join KhachHang on HoaDon.MaKH=KhachHang.MaKH\n"
                + " join NguoiDung on HoaDon.MaND=NguoiDung.MaND where NgayTao between ? and ?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, min);
            ps.setObject(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon x = new HoaDon();
                x.setMaHD(rs.getString(1));
                x.setMaKH(rs.getString(2));
                x.setMaND(rs.getString(3));
                x.setNgayTao(rs.getString(4));
                x.setNgayHuy(rs.getString(5));
                x.setNgayThanhToan(rs.getString(6));
                x.setTrangThai(rs.getString(7));
                list.add(x);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "vui lòng nhập đúng ngày");
        }
        return list;
    }
}

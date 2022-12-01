/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fptshop
 */
public class ThemSuaThanhToanHoaDon {

    /**
     *
     * @author DELL
     */
    public List<HoaDon> insert(String MaHD, String MaKH, String MaND, String NgayTao, String TrangThai) {
        ArrayList<HoaDon> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "insert  HoaDon(MaHD,MaKH,MaND,NgayTao,TrangThai) values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, MaHD);
            st.setString(2, MaKH);
            st.setString(3, MaND);
            st.setString(4, NgayTao);
            st.setString(5, TrangThai);
            st.executeUpdate();
            HoaDon cl = new HoaDon();
            cl.setMaHD(MaKH);
            cl.setMaKH(MaKH);
            cl.setMaND(MaND);
            cl.setNgayTao(NgayTao);
            cl.setTrangThai(TrangThai);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
        return listcl;
    }

    public List<HoaDonChiTiet> insertGH(String MaHD, String MaSP, String TongTien, String TienKhachDua, String TienThua, String TrangThai) {
        ArrayList<HoaDonChiTiet> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "insert  HoaDonChiTiet(MaHD,MaSP,TongTien,TienKhachDua,TienThua,TrangThai) values(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, MaHD);
            st.setString(2, MaSP);
            st.setString(3, TongTien);
            st.setString(4, TienKhachDua);
            st.setString(5, TienThua);
            st.setString(6, TrangThai);
            st.executeUpdate();
            HoaDonChiTiet cl = new HoaDonChiTiet();
            cl.setMaHD(MaHD);
            cl.setMaSP(MaSP);
            cl.setTongTien(TongTien);
            cl.setTienKhachDua(TienKhachDua);
            cl.setTienThua(TienThua);
            cl.setTrangThai(TrangThai);
            st.close();
            con.close();
        } catch (Exception e) {
        }
        return listcl;
    }

    public List<HoaDon> HuyHoaDon(String MaHD, String TrangThai) {
        ArrayList<HoaDon> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "UPDATE  HoaDon SET TrangThai=? where MaHD=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(2, MaHD);
            st.setString(1, TrangThai);
            st.executeUpdate();
            HoaDon cl = new HoaDon();
            cl.setMaHD(MaHD);
            cl.setTrangThai(TrangThai);
            listcl.add(cl);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hủy Thất Bại ");
        }
        return listcl;
    }

    public List<HoaDonChiTiet> Huy(String MaHD, String TrangThai) {
        ArrayList<HoaDonChiTiet> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "UPDATE  HoaDonChiTiet SET TrangThai=? where MaHD=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(2, MaHD);
            st.setString(1, TrangThai);
            st.executeUpdate();
            HoaDonChiTiet cl = new HoaDonChiTiet();
            cl.setMaHD(MaHD);
            cl.setTrangThai(TrangThai);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Hủy  thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hủy Thất Bại ");
        }
        return listcl;
    }

    public List<HoaDonChiTiet> ThanhToanHoaDonChiTiet(String MaHD,String tong,String tienkhachdua,String Tienthua,String TrangThai) {
        ArrayList<HoaDonChiTiet> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "UPDATE  HoaDonChiTiet SET TongTien=?,TienKhachDua=?,TienThua=?,  TrangThai=? where MaHD=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(5, MaHD);
            st.setString(1, tong);
            st.setString(2, tienkhachdua);
            st.setString(3, Tienthua);
            st.setString(4, TrangThai);
            st.executeUpdate();
            HoaDonChiTiet cl = new HoaDonChiTiet();
            cl.setMaHD(MaHD);
             cl.setTongTien(tong);
             cl.setTienKhachDua(tienkhachdua);
             cl.setTienThua(Tienthua);
            cl.setTrangThai(TrangThai);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Hủy  thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hủy Thất Bại Toán thất bại");
        }
        return listcl;
    }

    public List<HoaDon> ThanhToanHoaDon(String MaHD,String TrangThai) {
        ArrayList<HoaDon> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "UPDATE  HoaDon SET TrangThai=? where MaHD=?";
            PreparedStatement st = con.prepareStatement(sql);
             st.setString(2, MaHD);
            st.setString(1, TrangThai);
            st.executeUpdate();
            HoaDon cl = new HoaDon();
            cl.setMaHD(MaHD);
            cl.setTrangThai(TrangThai);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Hủy  thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hủy Thất Bại Toán thất bại");
        }
        return listcl;
    }

    public List<HoaDonChiTiet> delete() {
        ArrayList<HoaDonChiTiet> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "delete from  HoaDonChiTiet ";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
            HoaDonChiTiet cl = new HoaDonChiTiet();
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "tạo mới  thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "tạo mới  thất bại");
        }
        return listcl;
    }

}

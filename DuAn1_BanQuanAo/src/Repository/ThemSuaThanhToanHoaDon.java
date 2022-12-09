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
    public List<ThanhToan> insert(String MaKH, String MaND, String NgayTao, String TrangThai) {
        ArrayList<ThanhToan> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "insert  HoaDon(MaKH,MaND,NgayTao,TrangThai) values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, MaKH);
            st.setString(2, MaND);
            st.setString(3, NgayTao);
            st.setString(4, TrangThai);
            st.executeUpdate();
            ThanhToan cl = new ThanhToan();
            cl.setMaKH(MaKH);
            cl.setMaND(MaND);
            cl.setNgayTao(NgayTao);
            cl.setTrangThai(TrangThai);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mã Đã Tồn Tại , Thất Bại");
        }
        return listcl;
    }

    public List<ThanhToan> insertGH(String MaHD, String MaSP, String SoLuong, String TongTien, String TienKhachDua, String TienThua, String TrangThai) {
        ArrayList<ThanhToan> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "insert  HoaDonChiTiet(MaHD,MaSP,SoLuong,TongTien,TienKhachDua,TienThua,TrangThai) values(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, MaHD);
            st.setString(2, MaSP);
            st.setString(3, SoLuong);
            st.setString(4, TongTien);
            st.setString(5, TienKhachDua);
            st.setString(6, TienThua);
            st.setString(7, TrangThai);
            st.executeUpdate();
            ThanhToan cl = new ThanhToan();
            cl.setMaHDCT(MaHD);
            cl.setMaSP(MaSP);
            cl.setSoLuong(SoLuong);
            cl.setTongTien(TongTien);
            cl.setTienKhachDua(TienKhachDua);
            cl.setTienThua(TienThua);
            cl.setTrangThaiCT(TrangThai);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại1");
        }
        return listcl;
    }

    public List<ThanhToan> HuyHoaDon(String MaHD, String NgayHuy, String TrangThai) {
        ArrayList<ThanhToan> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "UPDATE  HoaDon SET NgayHuy =? , TrangThai=? where MaHD=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(3, MaHD);
            st.setString(1, NgayHuy);
            st.setString(2, TrangThai);
            st.executeUpdate();
            ThanhToan cl = new ThanhToan();
            cl.setMaHD(MaHD);
            cl.setNgayHuy(NgayHuy);
            cl.setTrangThai(TrangThai);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Hủy Hóa Đơn Thành Công ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hủy Thất Bại ");
        }
        return listcl;
    }

    public List<ThanhToan> Huy(String MaHD, String TrangThai) {
        ArrayList<ThanhToan> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "UPDATE  HoaDonChiTiet SET TrangThai=? where MaHD=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(2, MaHD);
            st.setString(1, TrangThai);
            st.executeUpdate();
            ThanhToan cl = new ThanhToan();
            cl.setMaHDCT(MaHD);
            cl.setTrangThaiCT(TrangThai);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Hủy  thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hủy Thất Bại ");
        }
        return listcl;
    }

    public List<ThanhToan> ThanhToanHoaDonChiTiet(String MaHD, String tong, String tienkhachdua, String Tienthua, String TrangThai) {
        ArrayList<ThanhToan> listcl = new ArrayList<>();
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
            ThanhToan cl = new ThanhToan();
            cl.setMaHDCT(MaHD);
            cl.setTongTien(tong);
            cl.setTienKhachDua(tienkhachdua);
            cl.setTienThua(Tienthua);
            cl.setTrangThaiCT(TrangThai);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Hủy  thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hủy Thất Bại Toán thất bại");
        }
        return listcl;
    }

    public List<ThanhToan> ThanhToanHoaDon(String MaHD, String NgayHuy, String TrangThai) {
        ArrayList<ThanhToan> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "UPDATE  HoaDon SET NgayThanhToan =? , TrangThai=? where MaHD=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(3, MaHD);
            st.setString(1, NgayHuy);
            st.setString(2, TrangThai);
            st.executeUpdate();
            ThanhToan cl = new ThanhToan();
            cl.setMaHD(MaHD);
            cl.setNgayHuy(NgayHuy);
            cl.setTrangThai(TrangThai);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Thanh Toán  thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thanh Toán  thất bại");
        }
        return listcl;
    }

    public List<ThanhToan> select(String ma2) {
        ArrayList<ThanhToan> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "select MaHD ,MaKH, MaND,NgayTao , TrangThai from  HoaDon WHERE MaHD=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaHD");
                String MaKH = rs.getString("MaKH");
                String MaND = rs.getString("MaND");
                String NgayTao = rs.getString("NgayTao");   
                String TrangThai = rs.getString("TrangThai");
                ThanhToan cl = new ThanhToan();
                cl.setMaHDCT(ma);
                cl.setMaKH(MaKH);
                cl.setMaND(MaND);
                cl.setNgayTao(NgayTao);
                  cl.setTrangThai(TrangThai);
                listcl.add(cl);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " ko tìm thấy thất bại");
        }
        return listcl;
    }

    public List<ThanhToan> select() {
        ArrayList<ThanhToan> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "select HoaDon.MaHD ,HoaDon.MaKH, HoaDon.MaND,HoaDon.NgayTao ,HoaDonChiTiet.TongTien ,HoaDon.TrangThai from  HoaDonChiTiet inner join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD   ";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaHD");
                String MaKH = rs.getString("MaKH");
                String MaND = rs.getString("MaND");
                String NgayTao = rs.getString("NgayTao");
                String TongTien = rs.getString("TongTien");
                String TrangThai = rs.getString("TrangThai");
                ThanhToan cl = new ThanhToan();
                cl.setMaHDCT(ma);
                cl.setMaKH(MaKH);
                cl.setMaND(MaND);
                cl.setNgayTao(NgayTao);
                cl.setTongTien(TongTien);
                cl.setTrangThai(TrangThai);
                listcl.add(cl);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " ko tìm thấy thất bại");
        }
        return listcl;

    }

}

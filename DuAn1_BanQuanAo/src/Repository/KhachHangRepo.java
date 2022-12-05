/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhachHangMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fptshop
 */
public class KhachHangRepo {

    public List<KhachHangMode> select() {
        ArrayList<KhachHangMode> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "select * from KhachHang";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaKH");
                String ten = rs.getString("HoVaTen");
                String sdt = rs.getString("Sdt");
                String ngaysinh = rs.getString("NgaySinh");
                String thanhpho = rs.getString("ThanhPho");
                KhachHangMode cl = new KhachHangMode();
                cl.setMaKH(ma);
                cl.setHoVaTen(ten);
                cl.setSdt(sdt);
                cl.setNgaySinh(ngaysinh);
                cl.setThanhPho(thanhpho);
                listcl.add(cl);
            }
        } catch (Exception e) {

        }
        return listcl;
    }
     public List<KhachHangMode> select1(String ma1) {
        ArrayList<KhachHangMode> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "select * from KhachHang where MaKH=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaKH");
                String ten = rs.getString("HoVaTen");
                String sdt = rs.getString("Sdt");
                String ngaysinh = rs.getString("NgaySinh");
                String thanhpho = rs.getString("ThanhPho");
                KhachHangMode cl = new KhachHangMode();
                cl.setMaKH(ma);
                cl.setHoVaTen(ten);
                cl.setSdt(sdt);
                cl.setNgaySinh(ngaysinh);
                cl.setThanhPho(thanhpho);
                listcl.add(cl);
            }
        } catch (Exception e) {

        }
        return listcl;
    }

    public List<KhachHangMode> insert(String ma, String ten, String sdt, String ngaysinh, String thanhpho) {
        ArrayList<KhachHangMode> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "insert KhachHang values (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma);
            st.setString(2, ten);
            st.setString(3, sdt);
            st.setString(4, ngaysinh);
            st.setString(5, thanhpho);
            st.executeUpdate();
            KhachHangMode cl = new KhachHangMode();
            cl.setMaKH(ma);
            cl.setHoVaTen(ten);
            cl.setSdt(sdt);
            cl.setNgaySinh(ngaysinh);
            cl.setThanhPho(thanhpho);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "thêm thất bại ");

        }
        return listcl;
    }

    public List<KhachHangMode> update(String ma, String ten, String sdt, String ngaysinh, String thanhpho) {
        ArrayList<KhachHangMode> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "update KhachHang set HoVaTen=? , Sdt=?, NgaySinh=?,ThanhPho=? where MaKH=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(5, ma);
            st.setString(1, ten);
            st.setString(2, sdt);
            st.setString(3, ngaysinh);
            st.setString(4, thanhpho);
            st.executeUpdate();
            KhachHangMode cl = new KhachHangMode();
            cl.setMaKH(ma);
            cl.setHoVaTen(ten);
            cl.setSdt(sdt);
            cl.setNgaySinh(ngaysinh);
            cl.setThanhPho(thanhpho);
            st.close();
            con.close();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sửa thất bại");

        }
        return listcl;
    }

    public List<KhachHangMode> delete(String ma) {
        ArrayList<KhachHangMode> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "delete from KhachHang where MaKH=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma);
            st.executeUpdate();
            KhachHangMode cl = new KhachHangMode();
            cl.setMaKH(ma);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "xóa thật bại");
        }
        return listcl;
    }
}
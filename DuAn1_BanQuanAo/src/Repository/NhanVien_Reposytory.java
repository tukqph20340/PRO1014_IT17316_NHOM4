/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.NhanVien_Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitam
 */
public class NhanVien_Reposytory {

    DBConnect conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<NhanVien_Model> list = null;

    public NhanVien_Reposytory() {
        conn = new DBConnect();
    }

    public List<NhanVien_Model> getallformNhanVien() {
        String select = "SELECT [MaND]\n"
                + "      ,[MaCH]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[ChucVu]\n"
                + "      ,[Sdt]\n"
                + "      ,[DiaChi]\n"
                + "      ,[username]\n"
                + "      ,[pasword]\n"
                + "      ,[NgaySinh]\n"
                + "  FROM [dbo].[NguoiDung]";
        list = new ArrayList<NhanVien_Model>();
        try {
            pst = conn.openDBConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new NhanVien_Model(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_Reposytory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public String addNhanVien(NhanVien_Model nv){
        String add="INSERT INTO NguoiDung (MaCH,HoVaTen,GioiTinh,ChucVu,Sdt,DiaChi,username,pasword,NgaySinh) values(?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.openDBConnection().prepareStatement(add);
//            pst.setString(1, nv.getMaND());
            pst.setString(1, nv.getMaCH());
            pst.setString(2, nv.getHoVaTen());
            pst.setString(3, nv.getGioiTinh());
            pst.setString(4, nv.getChucVu());
            pst.setString(5, nv.getSdt());
            pst.setString(6, nv.getDiaChi());
            pst.setString(7, nv.getUsename());
            pst.setString(8, nv.getPassword());
            pst.setString(9, nv.getNgaysinh());
            pst.executeUpdate();
            return "Add thành công";
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_Reposytory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thất Bại";
    }
    public String XoaNhanVien(String ma){
        String add="DELETE from NguoiDung where MaND=?";
        try {
            pst = conn.openDBConnection().prepareStatement(add);
            pst.setString(1, ma);
            pst.executeUpdate();
            return "Xóa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_Reposytory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thất Bại";
    }
    public String SuaNhanVien(NhanVien_Model nv){
        String add="Update NguoiDung set MaCH=?,HoVaTen=?,GioiTinh=?,ChucVu=?,Sdt=?,DiaChi=?,username=?,pasword=?,NgaySinh=? where MaND=?";
        try {
            pst = conn.openDBConnection().prepareStatement(add);
            pst.setString(1, nv.getMaCH());
            pst.setString(2, nv.getHoVaTen());
            pst.setString(3, nv.getGioiTinh());
            pst.setString(4, nv.getChucVu());
            pst.setString(5, nv.getSdt());
            pst.setString(6, nv.getDiaChi());
            pst.setString(7, nv.getUsename());
            pst.setString(8, nv.getPassword());
            pst.setString(9, nv.getNgaysinh());
             pst.setString(10, nv.getMaND());
            pst.executeUpdate();
            return "Sửa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_Reposytory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thất Bại";
    }
    public static void main(String[] args) {
        System.out.println(new NhanVien_Reposytory());
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import ViewModels.SanPhamViews;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitam
 */
public class SanPhaminBanHang_Repository {

    DBConnect conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<SanPhamViews> list = null;

    public SanPhaminBanHang_Repository() {
        conn = new DBConnect();
    }

    public List<SanPhamViews> getAllSanPhamInBanHang() {
        String select = "SELECT MaSP,TenSP,a.DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,GiaBan,SoLuong From SanPham \n"
                + "join DanhMucSP a on a.MaDM = SanPham.MaDM\n"
                + "join Mau on Mau.MaMau = SanPham.MaMau\n"
                + "join Size on Size.Ma = SanPham.MaSize\n"
                + "join ChatLieu on ChatLieu.MaCL = SanPham.MaCL\n"
                + "join KieuDang on KieuDang.MaKD = SanPham.MaKD ";

        list = new ArrayList<>();
        try {
            pst =DBConnect.getConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new SanPhamViews(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));

            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhaminBanHang_Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<SanPhamViews> FindSanPhamInBanHang(String name) {
        String find = "SELECT MaSP,TenSP,a.DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,GiaBan,SoLuong From SanPham \n"
                + "join DanhMucSP a on a.MaDM = SanPham.MaDM\n"
                + "join Mau on Mau.MaMau = SanPham.MaMau\n"
                + "join Size on Size.Ma = SanPham.MaSize\n"
                + "join ChatLieu on ChatLieu.MaCL = SanPham.MaCL\n"
                + "join KieuDang on KieuDang.MaKD = SanPham.MaKD "
                + "where TenSP=?";

//        list = new ArrayList<>();
        try {
            pst = DBConnect.getConnection().prepareStatement(find);
//            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new SanPhamViews(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhaminBanHang_Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<SanPhamViews> seachname(String name) {
        String find = "SELECT       dbo.SanPham.MaSP, dbo.SanPham.TenSP, dbo.DanhMucSP.DanhMucSanPham, dbo.Mau.TenMau, dbo.Size.Ten, dbo.ChatLieu.TenChatLieu, dbo.KieuDang.TenKieuDang, dbo.SanPham.GiaBan, dbo.SanPham.SoLuong\n"
                + "FROM            dbo.SanPham INNER JOIN\n"
                + "                         dbo.Size ON dbo.SanPham.MaSize = dbo.Size.Ma INNER JOIN\n"
                + "                         dbo.KieuDang ON dbo.SanPham.MaKD = dbo.KieuDang.MaKD INNER JOIN\n"
                + "                         dbo.DanhMucSP ON dbo.SanPham.MaDM = dbo.DanhMucSP.MaDM INNER JOIN\n"
                + "                         dbo.Mau ON dbo.SanPham.MaMau = dbo.Mau.MaMau INNER JOIN\n"
                + "                         dbo.ChatLieu ON dbo.SanPham.MaCL = dbo.ChatLieu.MaCL"
                + "  where TenSP=?";
        try (Connection con =DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(find)) {
            List<SanPhamViews> listall = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listall.add(new SanPhamViews(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
            return listall;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<SanPhamViews> LocMau(String name) {
        String find1 = "SELECT       dbo.SanPham.MaSP, dbo.SanPham.TenSP, dbo.DanhMucSP.DanhMucSanPham, dbo.Mau.TenMau, dbo.Size.Ten, dbo.ChatLieu.TenChatLieu, dbo.KieuDang.TenKieuDang, dbo.SanPham.GiaBan, dbo.SanPham.SoLuong\n"
                + "FROM            dbo.SanPham INNER JOIN\n"
                + "                         dbo.Size ON dbo.SanPham.MaSize = dbo.Size.Ma INNER JOIN\n"
                + "                         dbo.KieuDang ON dbo.SanPham.MaKD = dbo.KieuDang.MaKD INNER JOIN\n"
                + "                         dbo.DanhMucSP ON dbo.SanPham.MaDM = dbo.DanhMucSP.MaDM INNER JOIN\n"
                + "                         dbo.Mau ON dbo.SanPham.MaMau = dbo.Mau.MaMau INNER JOIN\n"
                + "                         dbo.ChatLieu ON dbo.SanPham.MaCL = dbo.ChatLieu.MaCL"
                + "  where TenMau=?";
        try (Connection con = conn.openDBConnection();
                PreparedStatement ps = con.prepareStatement(find1)) {
            List<SanPhamViews> listall = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listall.add(new SanPhamViews(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
            return listall;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<SanPhamViews> LocSize(String name) {
        String find2 = "SELECT       dbo.SanPham.MaSP, dbo.SanPham.TenSP, dbo.DanhMucSP.DanhMucSanPham, dbo.Mau.TenMau, dbo.Size.Ten, dbo.ChatLieu.TenChatLieu, dbo.KieuDang.TenKieuDang, dbo.SanPham.GiaBan, dbo.SanPham.SoLuong\n"
                + "FROM            dbo.SanPham INNER JOIN\n"
                + "                         dbo.Size ON dbo.SanPham.MaSize = dbo.Size.Ma INNER JOIN\n"
                + "                         dbo.KieuDang ON dbo.SanPham.MaKD = dbo.KieuDang.MaKD INNER JOIN\n"
                + "                         dbo.DanhMucSP ON dbo.SanPham.MaDM = dbo.DanhMucSP.MaDM INNER JOIN\n"
                + "                         dbo.Mau ON dbo.SanPham.MaMau = dbo.Mau.MaMau INNER JOIN\n"
                + "                         dbo.ChatLieu ON dbo.SanPham.MaCL = dbo.ChatLieu.MaCL"
                + "  where Ten=?";
        try (Connection con = conn.openDBConnection();
                PreparedStatement ps = con.prepareStatement(find2)) {
            List<SanPhamViews> listall = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listall.add(new SanPhamViews(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
            return listall;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        new SanPhaminBanHang_Repository().getAllSanPhamInBanHang().forEach(s -> System.out.println(s.toString()));
//        System.out.println(new SanPhaminBanHang_Repository().LocMau("Đỏ"));
        System.out.println(new SanPhaminBanHang_Repository().LocSize("XL"));
    }

}

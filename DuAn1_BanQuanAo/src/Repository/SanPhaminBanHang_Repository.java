/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.SanPham;
import Untility.DBConnection;
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

    private DBConnection db;

    public List<SanPhamViews> getAllSanPhamInBanHang() {
        String select = "SELECT MaSP,TenSP,a.DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,GiaBan,SoLuong From SanPham \n"
                + "join DanhMucSP a on a.MaDM = SanPham.MaDM\n"
                + "join Mau on Mau.MaMau = SanPham.MaMau\n"
                + "join Size on Size.Ma = SanPham.MaSize\n"
                + "join ChatLieu on ChatLieu.MaCL = SanPham.MaCL\n"
                + "join KieuDang on KieuDang.MaKD = SanPham.MaKD ";

        list = new ArrayList<>();
        try {
            pst = conn.openDBConnection().prepareStatement(select);
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
            pst = conn.openDBConnection().prepareStatement(find);
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
        try ( Connection con = conn.openDBConnection();  PreparedStatement ps = con.prepareStatement(find)) {
            List<SanPhamViews> listall = new ArrayList<>();
            ps.setObject(1, name);
//            ps.setObject(2, Ma);
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
        try ( Connection con = conn.openDBConnection();  PreparedStatement ps = con.prepareStatement(find1)) {
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
        try ( Connection con = conn.openDBConnection();  PreparedStatement ps = con.prepareStatement(find2)) {
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

    public List<SanPhamViews> LocDanhMuc(String name) {
        String find1 = "SELECT       dbo.SanPham.MaSP, dbo.SanPham.TenSP, dbo.DanhMucSP.DanhMucSanPham, dbo.Mau.TenMau, dbo.Size.Ten, dbo.ChatLieu.TenChatLieu, dbo.KieuDang.TenKieuDang, dbo.SanPham.GiaBan, dbo.SanPham.SoLuong\n"
                + "FROM            dbo.SanPham INNER JOIN\n"
                + "                         dbo.Size ON dbo.SanPham.MaSize = dbo.Size.Ma INNER JOIN\n"
                + "                         dbo.KieuDang ON dbo.SanPham.MaKD = dbo.KieuDang.MaKD INNER JOIN\n"
                + "                         dbo.DanhMucSP ON dbo.SanPham.MaDM = dbo.DanhMucSP.MaDM INNER JOIN\n"
                + "                         dbo.Mau ON dbo.SanPham.MaMau = dbo.Mau.MaMau INNER JOIN\n"
                + "                         dbo.ChatLieu ON dbo.SanPham.MaCL = dbo.ChatLieu.MaCL"
                + "  where DanhMucSanPham=?";
        try ( Connection con = conn.openDBConnection();  PreparedStatement ps = con.prepareStatement(find1)) {
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

    public List<SanPhamViews> LocChatLieu(String name) {
        String find1 = "SELECT       dbo.SanPham.MaSP, dbo.SanPham.TenSP, dbo.DanhMucSP.DanhMucSanPham, dbo.Mau.TenMau, dbo.Size.Ten, dbo.ChatLieu.TenChatLieu, dbo.KieuDang.TenKieuDang, dbo.SanPham.GiaBan, dbo.SanPham.SoLuong\n"
                + "FROM            dbo.SanPham INNER JOIN\n"
                + "                         dbo.Size ON dbo.SanPham.MaSize = dbo.Size.Ma INNER JOIN\n"
                + "                         dbo.KieuDang ON dbo.SanPham.MaKD = dbo.KieuDang.MaKD INNER JOIN\n"
                + "                         dbo.DanhMucSP ON dbo.SanPham.MaDM = dbo.DanhMucSP.MaDM INNER JOIN\n"
                + "                         dbo.Mau ON dbo.SanPham.MaMau = dbo.Mau.MaMau INNER JOIN\n"
                + "                         dbo.ChatLieu ON dbo.SanPham.MaCL = dbo.ChatLieu.MaCL"
                + "  where TenChatLieu=?";
        try ( Connection con = conn.openDBConnection();  PreparedStatement ps = con.prepareStatement(find1)) {
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

    public List<SanPhamViews> LocKieuDang(String name) {
        String find1 = "SELECT       dbo.SanPham.MaSP, dbo.SanPham.TenSP, dbo.DanhMucSP.DanhMucSanPham, dbo.Mau.TenMau, dbo.Size.Ten, dbo.ChatLieu.TenChatLieu, dbo.KieuDang.TenKieuDang, dbo.SanPham.GiaBan, dbo.SanPham.SoLuong\n"
                + "FROM            dbo.SanPham INNER JOIN\n"
                + "                         dbo.Size ON dbo.SanPham.MaSize = dbo.Size.Ma INNER JOIN\n"
                + "                         dbo.KieuDang ON dbo.SanPham.MaKD = dbo.KieuDang.MaKD INNER JOIN\n"
                + "                         dbo.DanhMucSP ON dbo.SanPham.MaDM = dbo.DanhMucSP.MaDM INNER JOIN\n"
                + "                         dbo.Mau ON dbo.SanPham.MaMau = dbo.Mau.MaMau INNER JOIN\n"
                + "                         dbo.ChatLieu ON dbo.SanPham.MaCL = dbo.ChatLieu.MaCL"
                + "  where TenKieuDang=?";
        try ( Connection con = conn.openDBConnection();  PreparedStatement ps = con.prepareStatement(find1)) {
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

    public ArrayList<SanPham> getListTimKiem(String ma) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,TenSP,\n"
                + " DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,\n"
                + " GiaBan,SoLuong from SanPham\n"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD\n"
                + " where MaSP=? or TenSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setTenSP(rs.getString(2));
                x.setTenDanhMuc(rs.getString(3));
                x.setTenMau(rs.getString(4));
                x.setTenSize(rs.getString(5));
                x.setTenChatLieu(rs.getString(6));
                x.setTenKieuDang(rs.getString(7));
                x.setGiaBan(Integer.parseInt(rs.getString(8)));
                x.setSoLuong(Integer.parseInt(rs.getString(9)));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListLoc(String a, String b, String c, String d, String e) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "GiaBan,SoLuong from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD\n";
        if (!a.equals("Tất Cả") || !b.equals("Tất Cả") || !c.equals("Tất Cả") || !d.equals("Tất Cả") || !e.equals("Tất Cả")) {
            sql = sql + "Where ";
        }
        if (!a.equals("Tất Cả")) {
            sql = sql + "TenMau=N'" + a + "' ";
            if (!b.equals("Tất Cả") || !c.equals("Tất Cả") || !d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!b.equals("Tất Cả")) {
            sql = sql + "Ten=N'" + b + "' ";
            if (!c.equals("Tất Cả") || !d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!c.equals("Tất Cả")) {
            sql = sql + "DanhMucSanPham=N'" + c + "' ";
            if (!d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!d.equals("Tất Cả")) {
            sql = sql + "TenChatLieu=N'" + d + "' ";
            if (!e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!e.equals("Tất Cả")) {
            sql = sql + "TenKieuDang=N'" + e + "'";
        }
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setTenSP(rs.getString(2));
                x.setTenDanhMuc(rs.getString(3));
                x.setTenMau(rs.getString(4));
                x.setTenSize(rs.getString(5));
                x.setTenChatLieu(rs.getString(6));
                x.setTenKieuDang(rs.getString(7));
                x.setGiaBan(Integer.parseInt(rs.getString(8)));
                x.setSoLuong(Integer.parseInt(rs.getString(9)));
                list.add(x);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
//        new SanPhaminBanHang_Repository().getAllSanPhamInBanHang().forEach(s -> System.out.println(s.toString()));
//        System.out.println(new SanPhaminBanHang_Repository().LocMau("Đỏ"));
        System.out.println(new SanPhaminBanHang_Repository().seachname("Áo"));

    }

}

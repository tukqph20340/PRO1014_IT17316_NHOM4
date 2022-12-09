/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.*;
import Untility.DBConnection;
import com.sun.source.doctree.ThrowsTree;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class SanPhamRepository {

    private DBConnection db;

    public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,MaCH,MaNCC,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setMaCH(rs.getString(2));
                x.setMaNCC(rs.getString(3));
                x.setTenSP(rs.getString(4));
                x.setTenDanhMuc(rs.getString(5));
                x.setTenMau(rs.getString(6));
                x.setTenSize(rs.getString(7));
                x.setTenChatLieu(rs.getString(8));
                x.setTenKieuDang(rs.getString(9));
                x.setNgaySX(rs.getString(10));
                x.setGiaNhap(Integer.parseInt(rs.getString(11)));
                x.setGiaBan(Integer.parseInt(rs.getString(12)));
                x.setSoLuong(Integer.parseInt(rs.getString(13)));
                x.setTrangThai(rs.getString(14));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getListDanhMuc() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select DanhMucSanPham from DanhMucSP";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String x = rs.getString(1);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getListMauSac() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select TenMau from Mau";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String x = rs.getString(1);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getListSize() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select Ten from Size";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String x = rs.getString(1);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getListChatLieu() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select TenChatLieu from ChatLieu";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String x = rs.getString(1);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getListKieuDang() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select TenKieuDang from KieuDang";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String x = rs.getString(1);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean them(SanPham x) {
        String sql = "insert into SanPham (MaSP,MaCH,MaNCC,TenSP,MaDM,MaMau,MaSize,MaCL,MaKD,NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai) values\n"
                + "(?,?,?,?,"
                + "(select MaDM from DanhMucSP where DanhMucSanPham=?),\n"
                + "(select MaMau from Mau where TenMau=?),\n"
                + "(select Ma from Size where Ten=?),\n"
                + "(select MaCL from ChatLieu where TenChatLieu=?),\n"
                + "(select MaKD from KieuDang where TenKieuDang=?),\n"
                + "?,?,?,?,?)";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, x.getMaSP());
            ps.setObject(2, x.getMaCH());
            ps.setObject(3, x.getMaNCC());
            ps.setObject(4, x.getTenSP());
            ps.setObject(5, x.getTenDanhMuc());
            ps.setObject(6, x.getTenMau());
            ps.setObject(7, x.getTenSize());
            ps.setObject(8, x.getTenChatLieu());
            ps.setObject(9, x.getTenKieuDang());
            ps.setObject(10, x.getNgaySX());
            ps.setObject(11, x.getGiaNhap());
            ps.setObject(12, x.getGiaBan());
            ps.setObject(13, x.getSoLuong());
            ps.setObject(14, x.getTrangThai());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sua(SanPham x, String maSP) {
        String sql = "update SanPham set MaCH=?, MaNCC=?, TenSP=?,\n"
                + "MaDM=(select MaDM from DanhMucSP where DanhMucSanPham=?),\n"
                + "MaMau=(select MaMau from Mau where TenMau=?),\n"
                + "MaSize=(select Ma from Size where Ten=?),\n"
                + "MaCL=(select MaCL from ChatLieu where TenChatLieu=?),\n"
                + "MaKD=(select MaKD from KieuDang where TenKieuDang=?),\n"
                + "NgaySanXuat=?, GiaNhap=?, GiaBan=?, SoLuong=?\n"
                + "where MaSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, x.getMaCH());
            ps.setObject(2, x.getMaNCC());
            ps.setObject(3, x.getTenSP());
            ps.setObject(4, x.getTenDanhMuc());
            ps.setObject(5, x.getTenMau());
            ps.setObject(6, x.getTenSize());
            ps.setObject(7, x.getTenChatLieu());
            ps.setObject(8, x.getTenKieuDang());
            ps.setObject(9, x.getNgaySX());
            ps.setObject(10, x.getGiaNhap());
            ps.setObject(11, x.getGiaBan());
            ps.setObject(12, x.getSoLuong());
            ps.setObject(13, maSP);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(String maSP) {
        String sql = "delete SanPham where MaSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maSP);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPham> getListTimKiem(String ma) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,MaCH,MaNCC,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD"
                + " where MaSP=? or TenSP=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setMaCH(rs.getString(2));
                x.setMaNCC(rs.getString(3));
                x.setTenSP(rs.getString(4));
                x.setTenDanhMuc(rs.getString(5));
                x.setTenMau(rs.getString(6));
                x.setTenSize(rs.getString(7));
                x.setTenChatLieu(rs.getString(8));
                x.setTenKieuDang(rs.getString(9));
                x.setNgaySX(rs.getString(10));
                x.setGiaNhap(Integer.parseInt(rs.getString(11)));
                x.setGiaBan(Integer.parseInt(rs.getString(12)));
                x.setSoLuong(Integer.parseInt(rs.getString(13)));
                x.setTrangThai(rs.getString(14));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListLocMau(String mau) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,MaCH,MaNCC,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD"
                + " where TenMau=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, mau);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setMaCH(rs.getString(2));
                x.setMaNCC(rs.getString(3));
                x.setTenSP(rs.getString(4));
                x.setTenDanhMuc(rs.getString(5));
                x.setTenMau(rs.getString(6));
                x.setTenSize(rs.getString(7));
                x.setTenChatLieu(rs.getString(8));
                x.setTenKieuDang(rs.getString(9));
                x.setNgaySX(rs.getString(10));
                x.setGiaNhap(Integer.parseInt(rs.getString(11)));
                x.setGiaBan(Integer.parseInt(rs.getString(12)));
                x.setSoLuong(Integer.parseInt(rs.getString(13)));
                x.setTrangThai(rs.getString(14));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListLocSize(String size) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,MaCH,MaNCC,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD"
                + " where Ten=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, size);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setMaCH(rs.getString(2));
                x.setMaNCC(rs.getString(3));
                x.setTenSP(rs.getString(4));
                x.setTenDanhMuc(rs.getString(5));
                x.setTenMau(rs.getString(6));
                x.setTenSize(rs.getString(7));
                x.setTenChatLieu(rs.getString(8));
                x.setTenKieuDang(rs.getString(9));
                x.setNgaySX(rs.getString(10));
                x.setGiaNhap(Integer.parseInt(rs.getString(11)));
                x.setGiaBan(Integer.parseInt(rs.getString(12)));
                x.setSoLuong(Integer.parseInt(rs.getString(13)));
                x.setTrangThai(rs.getString(14));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListLocKieuDang(String a) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,MaCH,MaNCC,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD"
                + " where TenKieuDang=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setMaCH(rs.getString(2));
                x.setMaNCC(rs.getString(3));
                x.setTenSP(rs.getString(4));
                x.setTenDanhMuc(rs.getString(5));
                x.setTenMau(rs.getString(6));
                x.setTenSize(rs.getString(7));
                x.setTenChatLieu(rs.getString(8));
                x.setTenKieuDang(rs.getString(9));
                x.setNgaySX(rs.getString(10));
                x.setGiaNhap(Integer.parseInt(rs.getString(11)));
                x.setGiaBan(Integer.parseInt(rs.getString(12)));
                x.setSoLuong(Integer.parseInt(rs.getString(13)));
                x.setTrangThai(rs.getString(14));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListLocChatLieu(String a) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,MaCH,MaNCC,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD"
                + " where TenChatLieu=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setMaCH(rs.getString(2));
                x.setMaNCC(rs.getString(3));
                x.setTenSP(rs.getString(4));
                x.setTenDanhMuc(rs.getString(5));
                x.setTenMau(rs.getString(6));
                x.setTenSize(rs.getString(7));
                x.setTenChatLieu(rs.getString(8));
                x.setTenKieuDang(rs.getString(9));
                x.setNgaySX(rs.getString(10));
                x.setGiaNhap(Integer.parseInt(rs.getString(11)));
                x.setGiaBan(Integer.parseInt(rs.getString(12)));
                x.setSoLuong(Integer.parseInt(rs.getString(13)));
                x.setTrangThai(rs.getString(14));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListLocDanhMuc(String dm) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,MaCH,MaNCC,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD"
                + " where DanhMucSanPham=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, dm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setMaCH(rs.getString(2));
                x.setMaNCC(rs.getString(3));
                x.setTenSP(rs.getString(4));
                x.setTenDanhMuc(rs.getString(5));
                x.setTenMau(rs.getString(6));
                x.setTenSize(rs.getString(7));
                x.setTenChatLieu(rs.getString(8));
                x.setTenKieuDang(rs.getString(9));
                x.setNgaySX(rs.getString(10));
                x.setGiaNhap(Integer.parseInt(rs.getString(11)));
                x.setGiaBan(Integer.parseInt(rs.getString(12)));
                x.setSoLuong(Integer.parseInt(rs.getString(13)));
                x.setTrangThai(rs.getString(14));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListLoc(String a, String b, String c, String d, String e) {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select MaSP,MaCH,MaNCC,TenSP,"
                + "DanhMucSanPham,TenMau,Ten,TenChatLieu,TenKieuDang,"
                + "NgaySanXuat,GiaNhap,GiaBan,SoLuong,TrangThai from SanPham"
                + " join Mau on SanPham.MaMau=Mau.MaMau\n"
                + " join Size on SanPham.MaSize=Size.Ma\n"
                + " join DanhMucSP on SanPham.MaDM=DanhMucSP.MaDM\n"
                + " join ChatLieu on SanPham.MaCL=ChatLieu.MaCL\n"
                + " join KieuDang on SanPham.MaKD=KieuDang.MaKD\n";
        if (!a.equals("Tất Cả") || !b.equals("Tất Cả") || !c.equals("Tất Cả") || !d.equals("Tất Cả") || !e.equals("Tất Cả")) {
            sql = sql + "Where ";
        }
        if (!a.equals("Tất Cả")) {
            sql = sql + "TenMau=? ";
            if (!b.equals("Tất Cả") || !c.equals("Tất Cả") || !d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!b.equals("Tất Cả")) {
            sql = sql + "Ten=? ";
            if (!c.equals("Tất Cả") || !d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!c.equals("Tất Cả")) {
            sql = sql + "DanhMucSanPham=? ";
            if (!d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!d.equals("Tất Cả")) {
            sql = sql + "TenChatLieu=? ";
            if (!e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!e.equals("Tất Cả")) {
            sql = sql + "TenKieuDang=?";
        }
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, a);
            ps.setObject(2, b);
            ps.setObject(3, c);
            ps.setObject(4, d);
            ps.setObject(5, e);
//            ps.setObject(1, a);
//            ps.setObject(2, b);
//            ps.setObject(3, c);
//            ps.setObject(4, d);
//            ps.setObject(5, e);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString(1));
                x.setMaCH(rs.getString(2));
                x.setMaNCC(rs.getString(3));
                x.setTenSP(rs.getString(4));
                x.setTenDanhMuc(rs.getString(5));
                x.setTenMau(rs.getString(6));
                x.setTenSize(rs.getString(7));
                x.setTenChatLieu(rs.getString(8));
                x.setTenKieuDang(rs.getString(9));
                x.setNgaySX(rs.getString(10));
                x.setGiaNhap(Integer.parseInt(rs.getString(11)));
                x.setGiaBan(Integer.parseInt(rs.getString(12)));
                x.setSoLuong(Integer.parseInt(rs.getString(13)));
                x.setTrangThai(rs.getString(14));
                list.add(x);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}

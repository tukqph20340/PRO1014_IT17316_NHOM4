/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Repository;

/**
 *
 * @author DELL
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String a="Đỏ";
        String b="abc";
        String c="Áo";
        String d="Quần";
        String e="Tất Cả";
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
            sql = sql + "TenMau=N'"+a+"' ";
            if (!b.equals("Tất Cả") || !c.equals("Tất Cả") || !d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!b.equals("Tất Cả")) {
            sql = sql + "Ten=N'"+b+"' ";
            if (!c.equals("Tất Cả") || !d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!c.equals("Tất Cả")) {
            sql = sql + "DanhMucSanPham=N'"+c+"' ";
            if (!d.equals("Tất Cả") || !e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!d.equals("Tất Cả")) {
            sql = sql + "TenChatLieu=N'"+d+"' ";
            if (!e.equals("Tất Cả")) {
                sql = sql + "and ";
            }
        }
        if (!e.equals("Tất Cả")) {
            sql = sql + "TenKieuDang=N'"+e+"' ";
        }
        System.out.println(sql);
    }
    
}

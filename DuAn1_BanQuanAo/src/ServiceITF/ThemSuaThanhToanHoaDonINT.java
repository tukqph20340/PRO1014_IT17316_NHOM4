/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

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
public interface ThemSuaThanhToanHoaDonINT {

    public List<HoaDon> insert(String MaHD, String MaKH, String MaND, String NgayTao,String TrangThai);

    public List<HoaDonChiTiet> insertGH(String MaHD,String MaSP,  String TongTien, String TienKhachDua, String TienThua,String TrangThai);

    public List<HoaDonChiTiet> Huy(String MaHD,String TrangThai);

    public List<HoaDon> HuyHoaDon(String MaHD,String TrangThai);

    public List<HoaDonChiTiet> ThanhToanHoaDonChiTiet(String MaHD,String TrangThai);

    public List<HoaDon> ThanhToanHoa(String MaHD,String TrangThai);

    public List<HoaDonChiTiet> delete();

}

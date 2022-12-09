/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceITF;

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

    public List<ThanhToan> insert(String MaKH, String MaND, String NgayTao, String TrangThai);

    public List<ThanhToan> insertGH(String MaHD, String MaSP, String SoLuong, String TongTien, String TienKhachDua, String TienThua, String TrangThai);

    public List<ThanhToan> Huy(String MaHD, String TrangThai);

    public List<ThanhToan> HuyHoaDon(String MaHD, String NgayHuy, String TrangThai);

    public List<ThanhToan> ThanhToanHoaDonChiTiet(String MaHD, String tong, String tienkhachdua, String Tienthua, String TrangThai);

    public List<ThanhToan> ThanhToanHoa(String MaHD, String NgayHuy, String TrangThai);

    public List<ThanhToan> select(String ma2);

    public List<ThanhToan> select();


}

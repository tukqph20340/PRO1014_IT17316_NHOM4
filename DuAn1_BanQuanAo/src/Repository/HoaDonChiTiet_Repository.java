/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.HoaDonCT_Model;
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
public class HoaDonChiTiet_Repository {

    DBConnect conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<HoaDonCT_Model> list = null;

    public HoaDonChiTiet_Repository() {
        conn = new DBConnect();
    }

    public List<HoaDonCT_Model> getAllFormHDCT() {
        String select = "SELECT [MaHD]\n"
                + "      ,[MaSP]\n"
                + "      ,[SoLuong]\n"
                + "      ,[TongTien]\n"
                + "      ,[TienKhachDua]\n"
                + "      ,[TienThua]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                ;
        list = new ArrayList<>();
        try {
            pst = conn.openDBConnection().prepareStatement(select);
//            pst.setObject(1, ma);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonCT_Model(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTiet_Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new HoaDonChiTiet_Repository().getAllFormHDCT());
    }

}

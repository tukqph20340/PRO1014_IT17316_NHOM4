/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import ViewModels.HoaDonViews;
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
public class HoaDon_Respository {

    DBConnect conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<HoaDonViews> list = null;

    public HoaDon_Respository() {
        conn = new DBConnect();
    }

    public List<HoaDonViews> getAllFormHoaDon() {
        String select = "Select MaHD,a.MaKH,HoVaTen,NgayTao From HoaDon \n"
                + "join KhachHang a on a.MaKH = HoaDon.MaKH\n"
                + "where TrangThai='Chua thanh toan'";
        list = new ArrayList<>();
        try {
            pst = conn.openDBConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonViews(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_Respository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return list;
    }
}

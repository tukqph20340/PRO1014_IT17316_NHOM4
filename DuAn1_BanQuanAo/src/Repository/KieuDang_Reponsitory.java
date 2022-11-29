/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;
import DomainModels.KieuDang_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vitam
 */
public class KieuDang_Reponsitory {
        DBConnection con;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<KieuDang_Model> list =null;

    public KieuDang_Reponsitory(){
        con = new DBConnection();
    }

    public List<KieuDang_Model> getAllFormKieuDang() {
        String select = "Select MaKD,TenKieuDang from KieuDang";
        list = new ArrayList<>();
        try {
            pst = con.openDBConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new KieuDang_Model(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Reponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String ADDDKieuDang(KieuDang_Model kd) {
        String select = "INSERT INTO KieuDang (MaKD,TenKieuDang) values(?,?)";
        try {
            pst = con.openDBConnection().prepareStatement(select);
            pst.setObject(1, kd.getMaKD());
            pst.setObject(2, kd.getTenKieuDang());
            pst.executeUpdate();
            return "ADD Thành Công";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Reponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thất Bại";
    }

    public String XoaKieuDang(String Ma) {
        String delete = "DELETE FROM KieuDang where MaKD=?";
        try {
            pst = con.openDBConnection().prepareStatement(delete);
            pst.setObject(1,Ma);
            pst.executeUpdate();
            return "Xóa Thành Công";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Reponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thất Bại";
    }

    public String UpdateKieuDang(KieuDang_Model dm) {
        String update = "Update KieuDang set TenKieuDang=? where MaKD =?";
        try {
            pst = con.openDBConnection().prepareStatement(update);
            pst.setObject(1, dm.getTenKieuDang());
            pst.setObject(2, dm.getMaKD());
            pst.executeUpdate();
            return "Sửa Thành Công";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Reponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thất Bại";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.KieuDang_Model;
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
public class KieuDang_Res {
    DBConnect conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<KieuDang_Model> list = null;

    public KieuDang_Res() {
        conn = new DBConnect();
    }

    public List<KieuDang_Model> getAllformDM(){
        String select = "Select MaKD,TenKieuDang from KieuDang";
        list = new ArrayList<>();
        try {
            pst = conn.openDBConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {                
                list.add(new KieuDang_Model(rs.getString(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KieuDang_Res.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return list;
    }
    public String addForm(KieuDang_Model model){
        String add="INSERT INTO KieuDang (MaKD,TenKieuDang) values(?,?)";
        try {
            pst = DBConnect.openDBConnection().prepareStatement(add);
            pst.setObject(1, model.getMaKD());
            pst.setObject(2, model.getTenKD());
            pst.executeUpdate();
            return"Add thành công";
        } catch (SQLException ex) {
            Logger.getLogger(KieuDang_Res.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"Thất Bại";
    }
      public String DeleteForm(String ma){
        String delete="DELETE FROM KieuDang where MaKD=?";
        try {
            pst = conn.openDBConnection().prepareStatement(delete);
            pst.setObject(1, ma);
            pst.executeUpdate();
            return"Xóa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(KieuDang_Res.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"Thất Bại";
    }
        public String UpdateForm(KieuDang_Model model){
        String update="Update KieuDang set TenKieuDang=? where MaKD =?";
        try {
            pst =conn.openDBConnection().prepareStatement(update);
            pst.setObject(1, model.getTenKD());
            pst.setObject(2, model.getMaKD());
            pst.executeUpdate();
            return"Update thành công";
        } catch (SQLException ex) {
            Logger.getLogger(KieuDang_Res.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"Thất Bại";
    }
}

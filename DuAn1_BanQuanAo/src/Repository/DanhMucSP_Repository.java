/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;
import DomainModels.DanhMuc_model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vitam
 */
public class DanhMucSP_Repository {
    DBConnect conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<DanhMuc_model> list = null;

    public DanhMucSP_Repository() {
        conn= new DBConnect();
    }
    public List<DanhMuc_model> getAllformDM(){
        String select = "Select MaDM,DanhMucSanPham from DanhMucSP";
        list = new ArrayList<>();
        try {
            pst =conn.openDBConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {                
                list.add(new DanhMuc_model(rs.getString(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Repository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return list;
    }
    public String addForm(DanhMuc_model model){
        String add="INSERT INTO DanhMucSP (MaDM,DanhMucSanPham) values(?,?)";
        try {
            pst = conn.openDBConnection().prepareStatement(add);
            pst.setObject(1, model.getMaDM());
            pst.setObject(2, model.getTenDM());
            pst.executeUpdate();
            return"Add thành công";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"Thất Bại";
    }
      public String DeleteForm(String ma){
        String delete="DELETE FROM DanhMucSP where MaDM=?";
        try {
            pst = conn.openDBConnection().prepareStatement(delete);
            pst.setObject(1, ma);
            pst.executeUpdate();
            return"Xóa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"Thất Bại";
    }
        public String UpdateForm(DanhMuc_model model){
        String update="Update DanhMucSP set DanhMucSanPham=? where MaDM =?";
        try {
            pst = conn.openDBConnection().prepareStatement(update);
            pst.setObject(1, model.getTenDM());
            pst.setObject(2, model.getMaDM());
            pst.executeUpdate();
            return"Update thành công";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"Thất Bại";
    }
    
}

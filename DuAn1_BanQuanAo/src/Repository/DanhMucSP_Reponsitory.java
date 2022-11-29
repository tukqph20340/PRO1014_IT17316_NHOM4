/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.DanhMucSP_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitam
 */
public class DanhMucSP_Reponsitory {

    DBConnection con;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<DanhMucSP_Model> list = null;

    public DanhMucSP_Reponsitory() {
        con = new DBConnection();
    }

    public List<DanhMucSP_Model> getAllDanhMucSP() {
        String select = "Select MaDM,DanhMucSanPham from DanhMucSP";
        list = new ArrayList<>();
        try {
            pst = con.openDBConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new DanhMucSP_Model(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Reponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String ADDDanhMucSP(DanhMucSP_Model dm) {
        String select = "INSERT INTO DanhMucSP (MaDM,DanhMucSanPham) values(?,?)";
        try {
            pst = con.openDBConnection().prepareStatement(select);
            pst.setObject(1, dm.getMaDanhMuc());
            pst.setObject(2, dm.getTendanhMuc());
            pst.executeUpdate();
            return "ADD Thành Công";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Reponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thất Bại";
    }

    public String XoaDanhMucSP(String Ma) {
        String delete = "DELETE FROM DanhMucSP where MaDM=?";
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

    public String UpdateDanhMucSP(DanhMucSP_Model dm) {
        String update = "Update DanhMucSP set DanhMucSanPham=? where MaDM =?";
        try {
            pst = con.openDBConnection().prepareStatement(update);
            pst.setObject(1, dm.getTendanhMuc());
            pst.setObject(2, dm.getMaDanhMuc());
            pst.executeUpdate();
            return "Sửa Thành Công";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSP_Reponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thất Bại";
    }

}

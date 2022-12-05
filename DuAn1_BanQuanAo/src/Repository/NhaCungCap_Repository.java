/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.NhaCungCap_Model;
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
public class NhaCungCap_Repository {
     DBConnect conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<NhaCungCap_Model> list = null;

    public NhaCungCap_Repository() {
        conn = new DBConnect();
        
    }
    public List<NhaCungCap_Model> getallFormNhaCC(){
        String select = "Select MaNCC,TenNCC,DiaChi,Sdt from NhaCungCap";
        list = new ArrayList<>();
         try {
             pst = conn.openDBConnection().prepareStatement(select);
             rs = pst.executeQuery();
             while (rs.next()) { 
                      list.add(new NhaCungCap_Model(
                              rs.getString(1),
                              rs.getString(2),
                              rs.getString(3),
                              rs.getString(4)));
             }
         } catch (SQLException ex) {
             Logger.getLogger(NhaCungCap_Repository.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;
        
    }
    public String addNCC(NhaCungCap_Model nc){
        String add = "INSERT INTO NhaCungCap (MaNCC,TenNCC,DiaChi,Sdt) values(?,?,?,?)";
        
         try {
             pst = conn.openDBConnection().prepareStatement(add);
             pst.setString(1, nc.getMaNCC());
             pst.setString(2, nc.getTenNCC());
             pst.setString(3, nc.getDiaChi());
             pst.setString(4, nc.getSdt());
             pst.executeUpdate();
             return"Add thành công";
         } catch (SQLException ex) {
             Logger.getLogger(NhaCungCap_Repository.class.getName()).log(Level.SEVERE, null, ex);
         }
        return"Thất Bại";
    }
    public String DeleteNCC(NhaCungCap_Model nc){
        String delete = "Delete from NhaCungCap where MaNCC=?";
        
         try {
             pst = conn.openDBConnection().prepareStatement(delete);
             pst.setString(1, nc.getMaNCC());
             pst.executeUpdate();
             return"Xóa thành công";
         } catch (SQLException ex) {
             Logger.getLogger(NhaCungCap_Repository.class.getName()).log(Level.SEVERE, null, ex);
         }
        return"Thất Bại";
    }
    public String updateNCC(NhaCungCap_Model nc){
        String add = "Update NhaCungCap set TenNCC=?,DiaChi=?,Sdt=? where MaNCC=?";
        
         try {
             pst = conn.openDBConnection().prepareStatement(add);
             
             pst.setString(1, nc.getTenNCC());
             pst.setString(2, nc.getDiaChi());
             pst.setString(3, nc.getSdt());
             pst.setString(4, nc.getMaNCC());
             pst.executeUpdate();
             return"update thành công";
         } catch (SQLException ex) {
             Logger.getLogger(NhaCungCap_Repository.class.getName()).log(Level.SEVERE, null, ex);
         }
        return"Thất Bại";
    }
    public static void main(String[] args) {
        System.out.println(new NhaCungCap_Repository().getallFormNhaCC());
    }
    
}

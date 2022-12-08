/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NhanVien_Model;
import Untility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class DoiMatKhauRepository {

    private DBConnection db;

    public boolean dmk(String mkm, String tk, String mkc) {
        String sql = "update NguoiDung set pasword=? where username=? and pasword=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mkm);
            ps.setObject(2, tk);
            ps.setObject(3, mkc);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}



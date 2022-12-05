/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.DangNhapMoDel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fptshop
 */
public class DangNhapRepository {

    public static List<DangNhapMoDel> DangNhap() {
        ArrayList<DangNhapMoDel> dn = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "select username , pasword from NguoiDung";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String tk = rs.getString("username");
                String mk = rs.getString("pasword");
                DangNhapMoDel dn1 = new DangNhapMoDel();
                dn1.setTaiKhoan(tk);
                dn1.setMatKhau(mk);
                dn.add(dn1);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "lỗi vui lòng nhập lại");
        }
        return dn;
    }
     public DangNhapMoDel XacThucTaiKhoan(String TaiKhoan){
         List<DangNhapMoDel> dn = DangNhap();
         for (DangNhapMoDel dangNhapMoDel : dn) {
             if (dangNhapMoDel.getTaiKhoan().equalsIgnoreCase(TaiKhoan)) {
                 return dangNhapMoDel;
             }
         }
         return null;
     } 
//     public static void main(String[] args) {
//         List<DangNhapMoDel> dn = DangNhap();
//         System.out.println(dn);
//    }
    
}

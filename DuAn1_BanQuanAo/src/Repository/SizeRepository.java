/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class SizeRepository {

    public List<Size> select() {
        ArrayList<Size> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "select * from Size";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                Size cl = new Size();
                cl.setMa(ma);
                cl.setTen(ten);
                listcl.add(cl);
            }
        } catch (Exception e) {

        }
        return listcl;
    }

    public List<Size> insert( String ten) {
        ArrayList<Size> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "insert Size(Ten) values (?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ten);
            st.executeUpdate();
            Size cl = new Size();
            cl.setTen(ten);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "thêm thất bại");

        }
        return listcl;
    }

    public List<Size> update(String ma, String ten) {
        ArrayList<Size> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "update Size set Ten=? where Ma=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(2, ma);
            st.setString(1, ten);
            st.executeUpdate();
            Size cl = new Size();
            cl.setMa(ma);
            cl.setTen(ten);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sửa thất bại");

        }
        return listcl;
    }

    public List<Size> delete(String ma) {
        ArrayList<Size> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "delete from Size where Ma=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma);
            st.executeUpdate();
            Size cl = new Size();
            cl.setMa(ma);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "xóa thất bại");

        }
        return listcl;
    }
}

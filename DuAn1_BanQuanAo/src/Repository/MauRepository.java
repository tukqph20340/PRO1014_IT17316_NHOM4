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
public class MauRepository {

    public List<Mau> select() {
        ArrayList<Mau> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "select * from Mau";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaMau");
                String ten = rs.getString("TenMau");
                Mau cl = new Mau();
                cl.setMa(ma);
                cl.setTen(ten);
                listcl.add(cl);
            }
        } catch (Exception e) {

        }
        return listcl;
    }

    public List<Mau> insert(String ten) {
        ArrayList<Mau> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "insert Mau(TenMau) values (?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ten);
            st.executeUpdate();
            Mau cl = new Mau();
            cl.setTen(ten);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "thêm thất bại ");

        }
        return listcl;
    }

    public List<Mau> update(String ma, String ten) {
        ArrayList<Mau> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "update Mau set TenMau=? where MaMau=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(2, ma);
            st.setString(1, ten);
            st.executeUpdate();
            Mau cl = new Mau();
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

    public List<Mau> delete(String ma) {
        ArrayList<Mau> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "delete from Mau where MaMau=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma);
            st.executeUpdate();
            Mau cl = new Mau();
            cl.setMa(ma);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "xóa thật bại");
        }
        return listcl;
    }
}

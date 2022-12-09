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
public class ChatLieuRepository {

    public List<ChatLieu> select() {
        ArrayList<ChatLieu> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "select * from ChatLieu";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaCL");
                String ten = rs.getString("TenChatLieu");
                ChatLieu cl = new ChatLieu();
                cl.setMa(ma);
                cl.setTen(ten);
                listcl.add(cl);
            }
        } catch (Exception e) {

        }
        return listcl;
    }

    public List<ChatLieu> insert(String ten) {
        ArrayList<ChatLieu> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "insert ChatLieu(TenChatLieu) values (?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ten);
            st.executeUpdate();
            ChatLieu cl = new ChatLieu();
            cl.setTen(ten);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
        return listcl;
    }

    public List<ChatLieu> update(String ma, String ten) {
        ArrayList<ChatLieu> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "update ChatLieu set TenChatLieu=? where MaCL=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(2, ma);
            st.setString(1, ten);
            st.executeUpdate();
            ChatLieu cl = new ChatLieu();
            cl.setMa(ma);
            cl.setTen(ten);
            listcl.add(cl);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sửa thất bại");

        }
        return listcl;
    }

    public List<ChatLieu> delete(String ma) {
        ArrayList<ChatLieu> listcl = new ArrayList<>();
        try {
            Connection con = DBConTextTu.getConnection();
            String sql = "delete from ChatLieu where MaCL=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma);
            st.executeUpdate();
            ChatLieu cl = new ChatLieu();
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

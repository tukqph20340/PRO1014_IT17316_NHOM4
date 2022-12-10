/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.CuaHang;
import DomainModels.SanPham;
import Untility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CuaHangRepository {

    DBConnection db;

    public ArrayList<CuaHang> getListCH() {
        ArrayList<CuaHang> list = new ArrayList<>();
        String sql = "select*from CuaHang";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                CuaHang x=new CuaHang();
                x.setMaCH(rs.getString(1));
                x.setTenCH(rs.getString(2));
                x.setDiaChi(rs.getString(3));
                x.setThanhPho(rs.getString(4));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<CuaHang> getListTim(String ma) {
        ArrayList<CuaHang> list = new ArrayList<>();
        String sql = "select * from CuaHang where MaCH=? or TenCH=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang x=new CuaHang();
                x.setMaCH(rs.getString(1));
                x.setTenCH(rs.getString(2));
                x.setDiaChi(rs.getString(3));
                x.setThanhPho(rs.getString(4));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }    
    
    public boolean them(CuaHang x) {
        String sql = "insert CuaHang (TenCH,DiaChi,ThanhPho) values (?,?,?)";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, x.getTenCH());
            ps.setObject(2, x.getDiaChi());
            ps.setObject(3, x.getThanhPho());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean thema(CuaHang x) {
        String sql = "insert into CuaHang (TenCH,DiaChi,ThanhPho) values (?,?,?)";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, x.getTenCH());
            ps.setObject(2, x.getDiaChi());
            ps.setObject(3, x.getThanhPho());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean sua(CuaHang x,String ma) {
        String sql = "update CuaHang set TenCH=?,DiaChi=?,ThanhPho=? where MaCH=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, x.getTenCH());
            ps.setObject(2, x.getDiaChi());
            ps.setObject(3, x.getThanhPho());
            ps.setObject(4, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoa(String ma) {
        String sql = "delete CuaHang where MaCH=?";
        try ( Connection con = db.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

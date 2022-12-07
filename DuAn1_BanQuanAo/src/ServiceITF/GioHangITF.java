/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

import DomainModels.GioHang;
import DomainModels.SanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface GioHangITF {

    public ArrayList<GioHang> getListGH(String ma);
    public ArrayList<GioHang> getListGH();
    public boolean tangHD(String ma, String maHD);

    public boolean giamHD(String ma, String maHD);

    public boolean tangSP(String ma);

    public boolean giamSP(String ma);

    public boolean xoa(String ma, String maHD);

    public boolean tangSoLuongGH(String ma, int so, String maHD);

    public boolean tangSoLuongSP(int so, String ma);

    public boolean themGH(GioHang x, int so);
    
    public boolean giamSoLuongGH(String ma, int so, String maHD);

    public boolean giamSoLuongSP(int so, String ma);
}

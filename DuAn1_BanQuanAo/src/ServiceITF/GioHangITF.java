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
    
    public ArrayList<GioHang> getListGH_SP(String ma);

    public boolean tangHD(String ma);

    public boolean giamHD(String ma);

    public boolean tangSP(String ma);

    public boolean giamSP(String ma);
    
    public boolean xoa(String ma);
}

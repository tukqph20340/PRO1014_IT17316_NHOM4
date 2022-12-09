/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

import DomainModels.SanPham;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface SanPhamITF {
    public ArrayList<SanPham> getListSanPham();
    
    public ArrayList<String> getListDanhMuc();
    
    public ArrayList<String> getListMauSac();
    
    public ArrayList<String> getListSize();
    
    public ArrayList<String> getListChatLieu();
    
    public ArrayList<String> getListKieuDang();
    
    public boolean them(SanPham x);
    
    public boolean sua(SanPham x,String maSP);
    
    public boolean xoa(String maSP);
    
    public ArrayList<SanPham> tim(String ma);
    
    public ArrayList<SanPham> locMau(String ma);
    
    public ArrayList<SanPham> locSize(String size);
    
    public ArrayList<SanPham> locChatLieu(String x);
    
    public ArrayList<SanPham> locDanhMuc(String x);
    
    public ArrayList<SanPham> locKieuDang(String x);
    
    public ArrayList<SanPham> getListLoc(String a,String b,String c,String d,String e);
}

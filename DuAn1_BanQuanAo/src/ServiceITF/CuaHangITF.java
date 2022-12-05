/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

import DomainModels.CuaHang;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface CuaHangITF {
    public ArrayList<CuaHang> getListCH();
    
    public boolean them(CuaHang x);
    
    public boolean sua(CuaHang x,String ma);
    
    public boolean xoa(String ma);
    
    public ArrayList<CuaHang> getListTim(String ma);
}

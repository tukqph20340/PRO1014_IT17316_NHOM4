/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

import DomainModels.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface HoaDonITFa {
    ArrayList<HoaDon> getListHD();
    
    ArrayList<HoaDon> getListLocHD(String tt);
    
    ArrayList<HoaDon> getListTimHD(String ma);
}

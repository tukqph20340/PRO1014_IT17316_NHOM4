/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.HoaDon;
import Repository.HoaDonRepository;
import ServiceITF.HoaDonITFa;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDonIplm implements HoaDonITFa {

    private HoaDonRepository x = new HoaDonRepository();

    @Override
    public ArrayList<HoaDon> getListHD() {
        return x.getListHD();
    }

    @Override
    public ArrayList<HoaDon> getListLocHD(String tt) {
        return x.getListLocHD(tt);
    }

    @Override
    public ArrayList<HoaDon> getListTimHD(String ma) {
        return x.getListTimHD(ma);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.GioHang;
import DomainModels.SanPham;
import Repository.GioHangRepository;
import ServiceITF.GioHangITF;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class GioHangIplm implements GioHangITF{
    private GioHangRepository repo =new GioHangRepository();
    public GioHangIplm() {
    }

    @Override
    public ArrayList<GioHang> getListGH(String ma) {
        return repo.getListGH(ma);
    }

    @Override
    public boolean tangHD(String ma) {
        return repo.tangHD(ma);
    }

    @Override
    public boolean giamHD(String ma) {
       return repo.giamHD(ma);
    }

    @Override
    public boolean tangSP(String ma) {
        return repo.tangSP(ma);
    }

    @Override
    public boolean giamSP(String ma) {
        return repo.giamSP(ma);
    }

    @Override
    public boolean xoa(String ma) {
        return repo.xoa(ma);
    }

    @Override
    public ArrayList<GioHang> getListGH_SP(String ma) {
        return repo.getListGH_SP(ma);
    }
    
}

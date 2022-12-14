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
    public boolean tangHD(String ma,String maHD) {
        return repo.tangHD(ma,maHD);
    }

    @Override
    public boolean giamHD(String ma,String maHD) {
       return repo.giamHD(ma,maHD);
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
    public boolean xoa(String ma,String maHD) {
        return repo.xoa(ma,maHD);
    }

    @Override
    public boolean tangSoLuongGH(String ma, int so, String maHD) {
        return repo.tangSoLuongGH(ma, so, maHD);
    }

    @Override
    public boolean tangSoLuongSP(int so,String ma) {
        return repo.tangSoLuongSP(so, ma);
    }

    @Override
    public boolean themGH(GioHang x, int so) {
        return repo.themGH(x, so);
    }

    @Override
    public ArrayList<GioHang> getListGH() {
        return repo.getListGH();
    }

    @Override
    public boolean giamSoLuongGH(String ma, int so, String maHD) {
        return repo.giamSoLuongGH(ma, so, maHD);
    }

    @Override
    public boolean giamSoLuongSP(int so, String ma) {
        return repo.giamSoLuongSP(so, ma);
    }
    
}

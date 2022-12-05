/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.CuaHang;
import Repository.CuaHangRepository;
import ServiceITF.CuaHangITF;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CuaHangIplm implements CuaHangITF {

    private CuaHangRepository repo = new CuaHangRepository();

    public CuaHangIplm() {
    }

    @Override
    public ArrayList<CuaHang> getListCH() {
        return repo.getListCH();
    }

    @Override
    public boolean them(CuaHang x) {
        return repo.them(x);
    }

    @Override
    public boolean sua(CuaHang x, String ma) {
        return repo.sua(x, ma);
    }

    @Override
    public boolean xoa(String ma) {
        return repo.xoa(ma);
    }

    @Override
    public ArrayList<CuaHang> getListTim(String ma) {
        return repo.getListTim(ma);
    }

}

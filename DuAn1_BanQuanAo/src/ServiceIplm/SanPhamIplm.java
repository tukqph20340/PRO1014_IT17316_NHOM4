/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.*;
import Repository.SanPhamRepository;
import ServiceITF.SanPhamITF;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class SanPhamIplm implements SanPhamITF {

    private SanPhamRepository repo = new SanPhamRepository();

    public SanPhamIplm() {
    }

    @Override
    public ArrayList<SanPham> getListSanPham() {
        return repo.getListSanPham();
    }

    @Override
    public ArrayList<String> getListDanhMuc() {
        return repo.getListDanhMuc();
    }

    @Override
    public ArrayList<String> getListMauSac() {
        return repo.getListMauSac();
    }

    @Override
    public ArrayList<String> getListSize() {
        return repo.getListSize();
    }

    @Override
    public ArrayList<String> getListChatLieu() {
        return repo.getListChatLieu();
    }

    @Override
    public ArrayList<String> getListKieuDang() {
        return repo.getListKieuDang();
    }

    @Override
    public boolean them(SanPham x) {
        return repo.them(x);
    }

    @Override
    public boolean sua(SanPham x, String maSP) {
        return repo.sua(x, maSP);
    }

    @Override
    public boolean xoa(String maSP) {
        return repo.xoa(maSP);
    }

    @Override
    public ArrayList<SanPham> tim(String ma) {
        return repo.getListTimKiem(ma);
    }

    @Override
    public ArrayList<SanPham> locMau(String ma) {
        return repo.getListLocMau(ma);
    }

    @Override
    public ArrayList<SanPham> locSize(String size) {
        return repo.getListLocSize(size);
    }

    /*@Override
    public ArrayList<SanPham> getListLoc(String a, String b, String c, String d, String e) {
        return repo.getListLoc(a, b, c, d, e);
    }*/

    @Override
    public ArrayList<SanPham> locChatLieu(String x) {
        return repo.getListLocChatLieu(x);
    }

    @Override
    public ArrayList<SanPham> locDanhMuc(String x) {
        return repo.getListLocDanhMuc(x);
    }

    @Override
    public ArrayList<SanPham> locKieuDang(String x) {
        return repo.getListLocKieuDang(x);
    }

}

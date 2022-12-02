/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.*;
import Repository.KhachHangRepo;
import Repository.MauRepository;
import ServiceITF.KhachHang;
import ViewModels.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class KhachHangSevice implements KhachHang{
    private KhachHangRepo list = new KhachHangRepo();

    @Override
    public List<KhachHangView> select() {
          List<KhachHangMode> size = list.select();
        List<KhachHangView> listcl = new ArrayList<>();
        for (KhachHangMode size1 : size) {
            KhachHangView e = new KhachHangView(
                    size1.getMaKH(),
                    size1.getHoVaTen(),
                    size1.getSdt(),
                    size1.getNgaySinh(),
                    size1.getThanhPho()
            );
            listcl.add(e);
        }
        return listcl;
    }
      public List<KhachHangMode> select1(String ma) {
        try {
            return list.select1(ma);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KhachHangMode> insert(String ma, String ten, String sdt, String ngaysinh, String thanhpho) {
        try {
            return list.insert(ma, ten, sdt, ngaysinh, thanhpho);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KhachHangMode> update(String ma, String ten, String sdt, String ngaysinh, String thanhpho) {
         try {
            return list.update(ma, ten, sdt, ngaysinh, thanhpho);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KhachHangMode> delete(String ma) {
         try {
            return list.delete(ma);
        } catch (Exception e) {
            return null;
        }
    }

   
}
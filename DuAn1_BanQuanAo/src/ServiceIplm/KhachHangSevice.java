/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.KhachHangMode;
import Repository.KhachHangRepo;
import ServiceITF.KhachHangIF;
import ViewModels.KhachHangView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fptshop
 */
public class KhachHangSevice implements KhachHangIF {

    private KhachHangRepo list = new KhachHangRepo();

    @Override
    public List<KhachHangView> select() {
        List<KhachHangMode> kh = list.select();
        List<KhachHangView> listq1 = new ArrayList<>();
        for (KhachHangMode khachHangMode : kh) {
            KhachHangView w = new KhachHangView(
                    khachHangMode.getMaKH(),
                    khachHangMode.getHoVaTen(),
                    khachHangMode.getSdt(),
                    khachHangMode.getNgaySinh(),
                    khachHangMode.getThanhPho()
            );
            listq1.add(w);
        }
        return listq1;
    }

    @Override
    public List<KhachHangMode> select1(String ma1) {
        try {
            return list.select1(ma1);
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

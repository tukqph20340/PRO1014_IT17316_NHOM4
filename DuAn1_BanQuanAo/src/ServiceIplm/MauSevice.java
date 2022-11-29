/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.*;
import Repository.MauRepository;
import ViewModels.MauView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class MauSevice {
    private MauRepository list = new MauRepository();

    public List<MauView> select() {
        List<Mau> size = list.select();
        List<MauView> listcl = new ArrayList<>();
        for (Mau size1 : size) {
            MauView v = new MauView(
                    size1.getMa(),
                    size1.getTen()
            );
            listcl.add(v);
        }
        return listcl;
    }

    public List<Mau> insert(String ma, String ten) {
        try {
            return list.insert(ma, ten);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Mau> update(String ma, String ten) {
        try {
            return list.update(ma, ten);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Mau> delete(String ma) {
        try {
            return list.delete(ma);
        } catch (Exception e) {
            return null;
        }
    }
}


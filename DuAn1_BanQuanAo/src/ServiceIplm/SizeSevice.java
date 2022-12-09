/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.*;
import Repository.SizeRepository;
import ServiceITF.SizeITF;
import ViewModels.SizeView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SizeSevice implements SizeITF {

    private SizeRepository list = new SizeRepository();

    @Override
    public List<SizeView> select() {
        List<Size> size = list.select();
        List<SizeView> listcl = new ArrayList<>();
        for (Size size1 : size) {
            SizeView v = new SizeView(
                    size1.getMa(),
                    size1.getTen()
            );
            listcl.add(v);
        }
        return listcl;
    }

    @Override
    public List<Size> insert( String ten) {
        try {
            return list.insert(ten);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Size> update(String ma, String ten) {
         try {
            return list.update(ma, ten);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Size> delete(String ma) {
        try {
            return list.delete(ma);
        } catch (Exception e) {
            return null;
        }
    }

}

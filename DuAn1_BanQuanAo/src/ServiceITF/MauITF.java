/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

import DomainModels.ChatLieu;
import Views.Mau;
import java.util.List;

/**
 *
 * @author fptshop
 */
public interface MauITF {

    public List<Mau> select();

    public List<Mau> insert( String ten);

    public List<Mau> update(String ma, String ten);

    public List<Mau> delete(String ma);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

import DomainModels.KhachHangMode;
import ViewModels.KhachHangView;
import java.util.List;

/**
 *
 * @author fptshop
 */
public interface KhachHangIF {

    public List<KhachHangView> select();

    public List<KhachHangMode> select1(String ma1);

    public List<KhachHangMode> insert(String ma, String ten, String sdt, String ngaysinh, String thanhpho);

    public List<KhachHangMode> update(String ma, String ten, String sdt, String ngaysinh, String thanhpho);

    public List<KhachHangMode> delete(String ma);
}

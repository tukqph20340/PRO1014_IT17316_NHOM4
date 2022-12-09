/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

import DomainModels.Size;
import ViewModels.SizeView;
import java.util.List;

/**
 *
 * @author fptshop
 */
public interface SizeITF {

    public List<SizeView> select();

    public List<Size> insert(String ten);

    public List<Size> update(String ma, String ten);

    public List<Size> delete(String ma);

}

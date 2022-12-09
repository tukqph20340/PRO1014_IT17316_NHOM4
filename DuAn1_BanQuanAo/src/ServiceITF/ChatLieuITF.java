/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceITF;

import DomainModels.*;
import java.util.List;

/**
 *
 * @author fptshop
 */
public interface ChatLieuITF {

    public List<ChatLieu> select();

    public List<ChatLieu> insert( String ten);

    public List<ChatLieu> update(String ma, String ten);

    public List<ChatLieu> delete(String ma);

}

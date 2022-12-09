/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import DomainModels.*;
import Repository.ChatLieuRepository;
import ViewModels.ChatLieuView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ChatLieuSevice {

    private ChatLieuRepository list = new ChatLieuRepository();

    public List<ChatLieuView> select() {
        List<ChatLieu> size = list.select();
        List<ChatLieuView> listcl = new ArrayList<>();
        for (ChatLieu size1 : size) {
            ChatLieuView v = new ChatLieuView(
                    size1.getMa(),
                    size1.getTen()
            );
            listcl.add(v);
        }
        return listcl;
    }

    public List<ChatLieu> insert( String ten) {
        try {
            return list.insert( ten);
        } catch (Exception e) {
            return null;
        }
    }

    public List<ChatLieu> update(String ma, String ten) {
        try {
            return list.update(ma, ten);
        } catch (Exception e) {
            return null;
        }
    }

    public List<ChatLieu> delete(String ma) {
        try {
            return list.delete(ma);
        } catch (Exception e) {
            return null;
        }
    }
}

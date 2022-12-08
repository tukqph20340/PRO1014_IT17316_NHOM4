/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIplm;

import Repository.DoiMatKhauRepository;
import ServiceITF.DoiMatKhauITF;

/**
 *
 * @author DELL
 */
public class DoiMatKhauIplm implements DoiMatKhauITF{
    private DoiMatKhauRepository x=new DoiMatKhauRepository();
    @Override
    public boolean dmk(String mkm, String tk, String mkc) {
        return x.dmk(mkm, tk, mkc);
    }
    
}

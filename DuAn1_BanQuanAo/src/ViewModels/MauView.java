/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.*;

/**
 *
 * @author DELL
 */
public class MauView {
    private String Ma;
    private String Ten;

    public MauView() {
    }

    public MauView(String Ma, String Ten) {
        this.Ma = Ma;
        this.Ten = Ten;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    @Override
    public String toString() {
        return "Size{" + "Ma=" + Ma + ", Ten=" + Ten + '}';
    }
    
}

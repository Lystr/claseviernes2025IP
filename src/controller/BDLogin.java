/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

/**
 *
 * @author louis
 */
public interface BDLogin {
    public Object checkUser(String name, String pass);    
    public Object getUser(String name, String pass);
}

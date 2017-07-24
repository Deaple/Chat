/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.redes2.chat;

/**
 *
 * @author isaac
 */
public class IniciaCliente {
    public static void main(String[] args){
        Cliente cliente = new Cliente();
        ClienteGUI guiLogin = new ClienteGUI(cliente);
        guiLogin.setVisible(true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.redes2.chat;

import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

/**
 *
 * @author isaac
 */
public class Cliente implements Runnable {
    private String nome;
    private Socket conexaoTCP;
    private DatagramSocket conexaoUDP;
    private DatagramPacket mensagemUDP;
    private int portaUDP = 9900;
    private int portaMulti = 9901;
    
    public Cliente(){
        
    }
    
    @Override
    public void run() {
        ChatGUI chatGUI = new ChatGUI();
        System.out.println("nome: "+this.nome);
        chatGUI.setVisible(true);
    }
    
    public Socket getConexaoTCP() {
        return conexaoTCP;
    }

    public void setConexaoTCP(Socket conexaoTCP) {
        this.conexaoTCP = conexaoTCP;
    }

    public DatagramSocket getConexaoUDP() {
        return conexaoUDP;
    }

    public void setConexaoUDP(DatagramSocket conexaoUDP) {
        this.conexaoUDP = conexaoUDP;
    }

    public DatagramPacket getMensagemUDP() {
        return mensagemUDP;
    }

    public void setMensagemUDP(DatagramPacket mensagemUDP) {
        this.mensagemUDP = mensagemUDP;
    }

    public int getPortaUDP() {
        return portaUDP;
    }

    public void setPortaUDP(int portaUDP) {
        this.portaUDP = portaUDP;
    }

    public int getPortaMulti() {
        return portaMulti;
    }

    public void setPortaMulti(int portaMulti) {
        this.portaMulti = portaMulti;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.redes2.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author isaac
 */
public class Servidor {
    private ServerSocket conexaoServidor;
    private int portaServidor;
    private String servidorHost;
    private List<Cliente> clientes;
    
    public Servidor(){
        portaServidor = 9977;
        clientes = new ArrayList<Cliente>();
    }
    
    public static void main(String[] args){
        Servidor servidor = new Servidor();
        try {
            servidor.escutarClientes();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    public void escutarClientes() throws IOException{
        conexaoServidor = new ServerSocket(portaServidor);
        String mensagem;
        while(true){
            System.out.println("Escutando em: "+portaServidor);
            
            Socket conexaoCliente = conexaoServidor.accept();
            if(conexaoCliente.isConnected()){
                System.out.println("conectado!");
                InputStreamReader dadosCliente = new InputStreamReader(conexaoCliente.getInputStream());
                BufferedReader valorCliente = new BufferedReader(dadosCliente);
                mensagem = valorCliente.readLine();
                //formata a saida
                if(mensagem.substring(0, 7).equals("CONECTA")){
                    System.out.println("add cli");
                    Cliente cli = new Cliente();
                    /* 0 - nome, 1 - porta UDP, 2 - porta Multicast */
                    cli.setNome(mensagem.substring(8).split(",")[0]);
                    cli.setPortaUDP(Integer.parseInt(mensagem.substring(8).split(",")[1]));
                    cli.setPortaMulti(Integer.parseInt(mensagem.substring(8).split(",")[2]));
                    cli.setConexaoTCP(conexaoCliente);
                    clientes.add(cli);
                    cli.run();
                    atualizaClientes();
                } else {
                    System.out.println("Mensagem: "+mensagem);
                }
            }
            
        }
    }
    
    public void atualizaClientes(){
        for(int i=0;i<clientes.size();i++){
            System.out.println("Cliente: "+clientes.get(i).getNome());
            
        }
    }
   
}

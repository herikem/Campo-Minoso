
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dark_
 */
public class Main {
    public static void main(String[]args) throws IOException, InterruptedException{
        Scanner scan = new Scanner(System.in);
        CampoMod campomod = new CampoMod();
        
	    String vet[];
	    int x,y;
	    String choice =null;
	    
	    do{
	        //CLS.superLimpador();
	        System.out.println("== CAMPO MINADO ==");
	        System.out.println("ESCOLHA SUA OPCAO: \n\n open <x> <y>        PARA MARCAR ABRIR UMA POSICAO\n mark <x> <y>        PARA MARCAR UMA POSICAO\n reset               PARA REINICIAR O JOGO\n exit                PARA SAIR\n ");
	        vet = scan.nextLine().split(" ");
	        choice = vet[0];

	        switch(choice){
	            case "open":
	                x = Integer.parseInt(vet[1]);
	                y = Integer.parseInt(vet[2]);
	                campomod.open(x,y);
	                break;
	                
	            case "mark":
	                x = Integer.parseInt(vet[1]);
	                y = Integer.parseInt(vet[2]);
	                campomod.mark(x,y);
	                break;
	                
	            case "reset":
	                campomod.reset();
	                break;
	                
	            case "exit":
	                break;
	            case "default":
	            	System.out.println("OPCAO INVALIDA");
	                break;
	        }
	        
	    }while(!"exit".equals(choice));    
    }
}
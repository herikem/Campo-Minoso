
//import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dark_
 */
public class ManipuladorArq {
	File arq = new File("save.game");
    private char[][] cmatriz = new char[12][12];
    private char[][] cmod = new char[12][12];
    public void saveGame(char[][] cmatriz, char[][] cmod) throws IOException{
    	FileWriter fw = null;
    	this.cmatriz = cmatriz;
    	this.cmod = cmod;
        try {
        	fw = new FileWriter(arq);
        	
        	for(int i = 0; i < 12; i++){
                for(int j = 0; j < 12; j++){
                	fw.write(this.cmod[i][j]);
                }
        	}
        	fw.write("\r\n");
        	for(int i = 0; i < 12; i++){
                for(int j = 0; j < 12; j++){
                	fw.write(this.cmatriz[i][j]);
                }
        	}    
        } catch (IOException ex) {
        	System.out.println("Nao foi possivel criar o fw");
        } finally {
        	try {
        		fw.close();
        	} catch (IOException ex) {
        		System.out.println("Nao foi possivel fechar o fw");
        	}
        }
    }
    
    public void loadGame() throws IOException{
    	FileReader fr = null;
    	try {
    		fr = new FileReader(arq);
    		int qtd;
    		char[] x1 = new char[144];
    		char[] x2 = new char[144];
    		int i1=0;int i2=0;int i3=0;
    		while((qtd=fr.read()) != -1){
    			if(i1<144) {
    				x1[i2] = (char)qtd;
    				i2++;
    			}
    			if(i1>145) {
    				x2[i3] = (char)qtd;
    				i3++;
    			}
    			i1++;
    		}
    		i1=0;
    		for(int i = 0; i < 12; i++){
                for(int j = 0; j < 12; j++){
                	this.cmod[i][j] = x1[i1];
                	i1++;
                }
    		}
    		i1=0;
    		for(int i = 0; i < 12; i++){
                for(int j = 0; j < 12; j++){
                	this.cmatriz[i][j] = x2[i1];
                	i1++;
                }
    		}
    	} catch(IOException ex) {
    		System.out.println("Nao foi possivel criar o fr");
    	} finally {
    		try {
    			fr.close();
    		} catch (IOException ex) {
    			System.out.println("nao foi possivel fechar o fr");
    		}
    	}
    }
    public char[][] getCampoMod(){
    	return this.cmod;
    }
    public char[][] getCampoMatriz(){
    	return this.cmatriz;
    }
}
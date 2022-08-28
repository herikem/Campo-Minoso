import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dark_
 */
public class CampoMatriz {
    private char campoMatrizMod[][]=new char[10][10];
    private char campoMatriz[][]=new char [12][12];
    Random random = new Random();
    
    public void gerarCampo(int p){
    	boolean spot;
    	int x=0;
        int lines, rows;
        
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
            campoMatriz[i][j]='0';
            }
        }
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
            campoMatrizMod[i][j]='0';
            }
        }
        
        for(int i=0; i<p; i++) {
        	do{
                lines = random.nextInt(10) ;
                rows = random.nextInt(10) ;
                
                if(campoMatrizMod[lines][rows] == (char)164)
                    spot=true;
                else
                    spot = false;
            }while(spot);
        	
        	campoMatrizMod[lines][rows] = (char)164;
        	}
        
        for(int i = 1; i < 11; i++){
            for(int j = 1; j < 11; j++){
                campoMatriz[i][j]= campoMatrizMod[i-1][j-1];
                x++;
            }
        }
        
        for(int i = 1; i < 11; i++){
            for(int j = 1; j < 11; j++){
                int codchar;
                if(campoMatriz[i][j]!=(char)164){

                    if(campoMatriz [i-1][j-1]==(char)164){
                        codchar=campoMatriz[i][j];
                        codchar=codchar+1;
                        campoMatriz[i][j]=(char)codchar;
                    }
                    if(campoMatriz[i-1][j]==(char)164){
                        codchar=campoMatriz[i][j];
                        codchar=codchar+1;
                        campoMatriz[i][j]=(char)codchar;
                    }
                    if(campoMatriz[i-1][j+1]==(char)164){
                        codchar=campoMatriz[i][j];
                        codchar=codchar+1;
                        campoMatriz[i][j]=(char)codchar;
                    }
                    if(campoMatriz[i][j-1]==(char)164){
                        codchar=campoMatriz[i][j];
                        codchar=codchar+1;
                        campoMatriz[i][j]=(char)codchar;
                    }
                    if(campoMatriz[i][j+1]==(char)164){
                        codchar=campoMatriz[i][j];
                        codchar=codchar+1;
                        campoMatriz[i][j]=(char)codchar;
                    }
                    if(campoMatriz[i+1][j-1]==(char)164){
                        codchar=campoMatriz[i][j];
                        codchar=codchar+1;
                        campoMatriz[i][j]=(char)codchar;
                    }
                    if(campoMatriz[i+1][j]==(char)164){
                        codchar=campoMatriz[i][j];
                        codchar=codchar+1;
                        campoMatriz[i][j]=(char)codchar;
                    }
                    if(campoMatriz[i+1][j+1]==(char)164){
                        codchar=campoMatriz[i][j];
                        codchar=codchar+1;
                        campoMatriz[i][j]=(char)codchar;
                    }
                }                
            }
        }
    }
    
    public char[][]getCampoMatriz(){
        return campoMatriz;
    }
}

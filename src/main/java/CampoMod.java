
import java.io.File;
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
public class CampoMod {
    Scanner scan = new Scanner(System.in);
    CampoFake campofake = new CampoFake();
    CampoMatriz matriz = new CampoMatriz();
    ManipuladorArq arqs = new ManipuladorArq();
    File arq = new File("save.game");
    private char[][] campoMod;
    
    public CampoMod() throws IOException, InterruptedException {
    	if(arq.exists()){
    		System.out.println("Existe um jogo salvo, deseja continua-lo? sim(s) nao(n)");
    		String choice = scan.nextLine();
    			switch(choice) {
	    			case "s":
	    				supercls();
	    				arqs.loadGame();
	    				campoMod = arqs.getCampoMod();
	    				imprimir();
	    				break;
	    			case "n":
	    				reset();
	    				break;
	    			default:
	    				System.out.println("OPCAO INVALIDA");
	    				break;
    			}
    	} else {
    		reset();
    	}
    }

    public char open(int x,int y) throws IOException, InterruptedException{
    	supercls();
    	x = x+1;y=y+1;
    	char[][]cm = arqs.getCampoMatriz();
    	if(campoMod[x][y]==(char)25||campoMod[x][y]==(char)70) {
    		if(cm[x][y]=='0') {
    			campoMod[x-1][y-1]=cm[x-1][y-1];
    			campoMod[x-1][y]=cm[x-1][y];
    			campoMod[x-1][y+1]=cm[x-1][y+1];
    			campoMod[x][y-1]=cm[x][y-1];
    			campoMod[x][y]=cm[x][y];
    			campoMod[x][y+1]=cm[x][y+1];
    			campoMod[x+1][y-1]=cm[x+1][y-1];
    			campoMod[x+1][y+1]=cm[x+1][y+1];
    			campoMod[x+1][y]=cm[x+1][y];
    		} else {
    			campoMod[x][y]=cm[x][y];
    		}
    	} else {
    		System.out.println("// POSICAO JA ABERTA //");
    	}
        imprimir();
        arqs.saveGame(cm, getcampoMod());
        verificador(x,y);
        return 0;
    }
    public void reset() throws IOException, InterruptedException{
        System.out.println("QUANTAS BOMBAS SEU NOVO CAMPO MINADO TERA? : ");
        int p = scan.nextInt();
        while(p<1||p>99){
        	System.out.println("A quantidade deve ser menor 100 e maior que 1");
        	System.out.println("QUANTAS BOMBAS SEU NOVO CAMPO MINADO TERA? : ");
        	p = scan.nextInt();
        }
        matriz.gerarCampo(p);
        campoMod = campofake.getCampoFake();
        arqs.saveGame(matriz.getCampoMatriz(), getcampoMod());
        supercls();
        imprimir();
    }
    
    public void mark(int x, int y) throws IOException, InterruptedException{
    	supercls();
    	x=x+1;y=y+1;
    	if(campoMod[x][y]==(char)25) {
    		campoMod[x][y]=(char)70;
    	}else if(campoMod[x][y]==(char)70){
    		campoMod[x][y]=(char)25;
    	}else {
    		System.out.println("// POSICAO JA ABERTA //");
    	}
    	
    	arqs.saveGame(arqs.getCampoMatriz(), getcampoMod());
    	imprimir();
    }
    
    private void imprimir(){
    	
    	System.out.println("");
    	int x=0;
    	char[][]cm = arqs.getCampoMod();
        System.out.println("     0 1 2 3 4 5 6 7 8 9\n");
        for(int i = 1; i < 11; i++){
        	System.out.print(x+"    ");
        	x++;
            for(int j = 1; j < 11; j++){
                if(j==0){
                    System.out.print(i + "    ");
                }
                System.out.print(cm[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    private void verificador(int x, int y) throws IOException, InterruptedException{
        int cont=0;
        if(campoMod[x][y]==(char)164){
            System.out.println("BOOOMMMM, VOCE PERDEU");
            reset();
        }
        for(int i = 1; i < 11; i++){
            for(int j = 1; j < 11; j++){
                if(campoMod[i][j]==(char)25||campoMod[i][j]==(char)70){
                	char[][]cm = arqs.getCampoMatriz();
                    if(cm[i][j] != (char)164){
                        cont = cont+1;
                    }
                }
            }
        }
        if(cont==0){
            System.out.println("PARABENS, VOCE GANHOU O JOGO");
            reset();
        }
    }
    
    public void supercls() throws InterruptedException, IOException {
    	if(System.getProperty("os.name").contains("Windows")) {
    		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    	}else {
    		Runtime.getRuntime().exec("clear");
    	}
    }
    
    public char[][]getcampoMod(){
    	return campoMod;
    }
}
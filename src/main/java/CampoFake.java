

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dark_
 */
public class CampoFake {
    private final char campoFake[][] = new char [12][12];
    
    private void campoFake(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                this.campoFake[i][j]= ((char)25);
            }
        }
    }
    public char[][] getCampoFake(){
        campoFake();
        return this.campoFake;
    }
}

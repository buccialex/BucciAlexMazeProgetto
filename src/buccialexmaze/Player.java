/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexmaze;

/**
 *
 * @author Bux
 */
public class Player extends OggettoMobile{

    /**
     * costruttore di player
     * @param nome nome del giocatore
     */
    public Player(String nome){
        super(nome);
        
    }
  
    
    /**
     * Muove il player di una casella verso il numero 2 adiacente
     * @param labirinto l'oggetto Labirinto su cui muoversi
     */
    
    @Override
    public void muovi(Labirinto labirinto){
        if(this.x == 0 && this.y == 0){
            this.x = labirinto.getxEntrata();
            this.y = labirinto.getyEntrata();
            labirinto.aggiornaPosPlayer(x, y, x, y);
        }
        
        int[][] maze = labirinto.getMappa();
        
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = maze.length;
        
        // Cerca un 2 adiacente
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && 
                maze[nextX][nextY] == 2) {
                
                int oldX = this.x;
                int oldY = this.y;
                
                
                this.x = nextX;
                this.y = nextY;
                labirinto.aggiornaPosPlayer(oldX, oldY, nextX, nextY);
                
            }
            
            
        }
  
    }
    
    public boolean terminato(Labirinto labirinto){
        int misure = labirinto.getMisure();
        
        if (misure % 2 == 0) misure++;
        
        int uscitaX = misure-1;
        int uscitaY = misure/2;
        
        return this.x == uscitaX && this.y == uscitaY;
    }
        
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexmaze;
import java.util.*;
/**
 *
 * @author diego
 */
public class Speciale {
    /**
     * attributi:
     * tipo:
     * 1 = boost
     * 2 = mostra soluzione
     * 3 = rallenta
     * 4 = teletrasporta
     */
    private int tipo;
    
    public Speciale(){
        Random r = new Random();
        this.tipo = r.nextInt(1, 5);
    }
    
    public void posizionaSpeciale(Labirinto l){
        Random rnd = new Random();
        
        int numeroOggetti = l.getMisure() / 2; 
        int contatore = 0;
        int tentativi = 0; // Protezione anti-loop infinito

        // Aumentiamo i tentativi perché è più difficile trovare spazio con questa regola
        while (contatore < numeroOggetti && tentativi < 10000) {
            
            // Coordinate casuali (escludendo i bordi estremi)
            int r = rnd.nextInt(l.getMisure() - 2) + 1; 
            int c = rnd.nextInt(l.getMisure() - 2) + 1;

            // 1. La cella deve essere vuota (0)
            if (l.getMappa()[r][c] == 0) {
                
                // 2. CONTROLLO DI VICINANZA
                // Verifichiamo che SOPRA, SOTTO, DESTRA e SINISTRA non ci sia già un 4
                boolean toccaAltroOggetto = false;

                if (l.getMappa()[r - 1][c] == 4) toccaAltroOggetto = true; // Nord
                if (l.getMappa()[r + 1][c] == 4) toccaAltroOggetto = true; // Sud
                if (l.getMappa()[r][c - 1] == 4) toccaAltroOggetto = true; // Ovest
                if (l.getMappa()[r][c + 1] == 4) toccaAltroOggetto = true; // Est

                // Se NON tocca nessun altro oggetto, posizionalo
                if (!toccaAltroOggetto) {
                    l.getMappa()[r][c] = 4;
                    contatore++;
                }
            }
            tentativi++;
        }
    }
}

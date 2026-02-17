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
public class Incrocio {
    private int x;
    private int y;
    private List<String> direzioniPossibili;

    public Incrocio(int x, int y, int[][] mappa) {
        this.x = x;
        this.y = y;
        this.direzioniPossibili = new ArrayList<>();
        calcolaDirezioni(mappa);
    }

    private void calcolaDirezioni(int[][] mappa) {
        int n = mappa.length;
        // Controlla Nord (Su) - Ricorda che le matrici hanno la riga 0 in alto
        if (x > 0 && mappa[x - 1][y] != 1) direzioniPossibili.add("Su");
        
        // Controlla Sud (Giù)
        if (x < n - 1 && mappa[x + 1][y] != 1) direzioniPossibili.add("Giù");
        
        // Controlla Ovest (Sinistra)
        if (y > 0 && mappa[x][y - 1] != 1) direzioniPossibili.add("Sinistra");
        
        // Controlla Est (Destra)
        if (y < n - 1 && mappa[x][y + 1] != 1) direzioniPossibili.add("Destra");
    }

    public int getX() { return x; }
    public int getY() { return y; }
    
    // Ritorna le opzioni per il JOptionPane
    public String[] getOpzioni() {
        return direzioniPossibili.toArray(new String[0]);
    }

    // Ci serve per convertire la scelta dell'utente (Stringa) in numeri (dx, dy)
    public int[] getVettoreDirezione(String scelta) {
        switch (scelta) {
            case "Su": return new int[]{-1, 0};
            case "Giù": return new int[]{1, 0};
            case "Sinistra": return new int[]{0, -1};
            case "Destra": return new int[]{0, 1};
            default: return new int[]{0, 0};
        }
    }
    
    
}

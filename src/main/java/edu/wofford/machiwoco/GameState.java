package edu.wofford.machiwoco;

public class GameState {

    /*

    For Phase 1, really the only thing getting updated on the market
    is the number of available cards

    */

    private int numWheatFields;
    private int numRanches;
    private int numForrests;
    private int playerCoins; // pull that data from Player Class
    private boolean hasWon;
    
    public GameState() {
        numWheatFields = 6;
        numRanches = 6;
        numForrests = 6;
        playerCoins = 3;
    }

    public int getNumWheatFields() {
        return numWheatFields;
    }

    public int getNumRanches() {
        return numRanches;
    }

    public int getNumForrests() {
        return numForrests;
    }

    public int getPlayerCoins() {
        return playerCoins;
    }

    public boolean hasWon() {
        return false;
    }



    public void printMarketState() {
        if (playerCoins >= 3) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + numWheatFields);
            System.out.println("Ranch              BC (1)  [2]      #" + numRanches);
            System.out.println("Forrest            BG (3)  [5]      #" + numForrests);
        } else if (playerCoins > 0 && playerCoins < 3) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + numWheatFields);
            System.out.println("Ranch              BC (1)  [2]      #" + numRanches);
        } else {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("          You can't afford any cards      ");
        }
    }

    public void printPlayerOneState() {

    }

    public void printPlayerTwoState() {

    }

    public void printMarketMenu() {
        if (playerCoins >= 7) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + numWheatFields);
            System.out.println("2. Ranch               BC (1)  [2]      #" + numRanches);
            System.out.println("3. Forrest             BG (3)  [5]      #" + numForrests);
            System.out.println("---------       CONSTRUCT        ---------");
            System.out.println("4. City Hall           NT (7)  [ ]");
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing");
            System.out.println("==========================================");
        } else if (playerCoins < 7 && playerCoins >=3) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + numWheatFields);
            System.out.println("2. Ranch               BC (1)  [2]      #" + numRanches);
            System.out.println("3. Forrest             BG (3)  [5]      #" + numForrests);
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing");
            System.out.println("==========================================");
        } else if (playerCoins > 0 && playerCoins < 3) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + numWheatFields);
            System.out.println("2. Ranch               BC (1)  [2]      #" + numRanches);
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing");
            System.out.println("==========================================");
        } else {
            System.out.println("==========================================");
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing");
            System.out.println("==========================================");
        }
        
    }


}

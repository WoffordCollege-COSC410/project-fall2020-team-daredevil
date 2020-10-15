package edu.wofford.machiwoco;

public class GameState {

    /*

    For Phase 1, really the only thing updated on the market
    is the number of available cards

    */

    private int numWheatFields;
    private int numRanches;
    private int numForrests;
    private boolean activated;
    private Player p1;
    private Player p2;
    
    public GameState() {
        numWheatFields = 6;
        numRanches = 6;
        numForrests = 6;
        activated = false;
        p1 = new Player();
        p2 = new Player();
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

    public boolean isActivated(int r) {
        int roll = 0;
        if (roll == 1 || roll == 2 || roll == 5) {
            activated = true;
            p1.addCoins(1);
            p2.addCoins(1);
        } 
        return activated;
    }

    public void purchaseCard() {
        
    }

    
    public void printMarketState() {
        if (p1.getCoins() >= 3) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + numWheatFields);
            System.out.println("Ranch              BC (1)  [2]      #" + numRanches);
            System.out.println("Forrest            BG (3)  [5]      #" + numForrests);
            System.out.println("                                          ");

        } else if (p1.getCoins() > 0 && p1.getCoins() < 3) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + numWheatFields);
            System.out.println("Ranch              BC (1)  [2]      #" + numRanches);
            System.out.println("                                          ");
        } else {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("          You can't afford any cards      ");
            System.out.println("                                          ");
        }
    }

    public void printPlayerOneState() {
        System.out.println("              Player 1* [YOU]             ");
        System.out.println("------------------------------------------");
        System.out.println("                (" + p1.getCoins() + " coins)                 ");
        System.out.println("Wheat Field        BW (1)  [1]      #1    ");
        System.out.println("..........................................");
    }

    public void printPlayerTwoState() {
        System.out.println("                 Player 2                 ");
        System.out.println("------------------------------------------");
        System.out.println("                (" + p2.getCoins() + " coins)                 ");
        System.out.println("Wheat Field        BW (1)  [1]      #1    ");
        System.out.println("..........................................");
    }



    public void printMarketMenu() {
        if (p1.getCoins() >= 7) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + numWheatFields);
            System.out.println("2. Ranch               BC (1)  [2]      #" + numRanches);
            System.out.println("3. Forrest             BG (3)  [5]      #" + numForrests);
            System.out.println("---------       CONSTRUCT        ---------");
            System.out.println("4. City Hall           NT (7)  [ ]        ");
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing                            ");
            System.out.println("==========================================");
        } else if (p1.getCoins() < 7 && p1.getCoins() >=3) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + numWheatFields);
            System.out.println("2. Ranch               BC (1)  [2]      #" + numRanches);
            System.out.println("3. Forest             BG (3)  [5]      #" + numForrests);
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing                            ");
            System.out.println("==========================================");
        } else if (p1.getCoins() > 0 && p1.getCoins() < 3) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + numWheatFields);
            System.out.println("2. Ranch               BC (1)  [2]      #" + numRanches);
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing                            ");
            System.out.println("==========================================");
        } else {
            System.out.println("==========================================");
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing                            ");
            System.out.println("==========================================");
        }
        
    }
    
}

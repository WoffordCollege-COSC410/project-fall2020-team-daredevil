package edu.wofford.machiwoco;

public class GameState {

    /*

    For Phase 1, really the only thing updated on the market
    is the number of available cards

    */

    private int availableWheat;
    private int availableRanch;
    private int availableForest;
    private boolean activated;
    private Player p1;
    private Player p2;
    
    public GameState() {
        availableWheat = 6;
        availableRanch = 6;
        availableForest = 6;
        activated = false;
        p1 = new Player();
        p2 = new Player();
    }

    public int getAvailableWheat() {
        return availableWheat;
    }

    public int getAvailableRanch() {
        return availableRanch;
    }

    public int getAvailableForest() {
        return availableForest;
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
        if (p1.getTurn()) {
            p1.addCard("w");
        } else if (p2.getTurn()) {
            p2.addCard("w");
        }
    }

    /**
    *   The Market State will always be displayed after each turn, regardless of how many coins
    *   the players have. The only thing that affects the Market State for now is the number of 
    *   available cards. The **MARKET MENU** (see below) however is formatted and displayed on 
    *   depending on what the players can afford and are allowed to buy.  
    */
    public void printMarketState() {
        if (availableWheat > 0 && availableRanch > 0 && availableForest > 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + availableWheat);
            System.out.println("Ranch              BC (1)  [2]      #" + availableRanch);
            System.out.println("Forest             BG (3)  [5]      #" + availableForest);
            System.out.println("                                          ");

        } else if (availableWheat > 0 && availableRanch > 0 && availableForest == 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + availableWheat);
            System.out.println("Ranch              BC (1)  [2]      #" + availableRanch);
            System.out.println("                                          ");
        } else if (availableWheat > 0 && availableRanch == 0 && availableForest > 0){
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + availableWheat);
            System.out.println("Forest             BG (3)  [5]      #" + availableForest);
            System.out.println("                                          ");
        } else if (availableWheat == 0 && availableRanch > 0 && availableForest > 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Ranch              BC (1)  [2]      #" + availableRanch);
            System.out.println("Forest             BG (3)  [5]      #" + availableForest);
            System.out.println("                                          ");
        } else if (availableWheat > 0 && availableRanch == 0 && availableForest == 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + availableWheat);
            System.out.println("                                          ");
        } else if (availableWheat == 0 && availableRanch > 0 && availableForest == 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Ranch              BC (1)  [2]      #" + availableRanch);
            System.out.println("                                          ");
        } else if (availableWheat == 0 && availableRanch == 0 && availableForest > 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Forest             BG (3)  [5]      #" + availableForest);
            System.out.println("                                          ");
        } else {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
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
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + availableWheat);
            System.out.println("2. Ranch               BC (1)  [2]      #" + availableRanch);
            System.out.println("3. Forest              BG (3)  [5]      #" + availableForest);
            System.out.println("---------       CONSTRUCT        ---------");
            System.out.println("4. City Hall           NT (7)  [ ]        ");
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing                            ");
            System.out.println("==========================================");
        } else if (p1.getCoins() < 7 && p1.getCoins() >=3) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + availableWheat);
            System.out.println("2. Ranch               BC (1)  [2]      #" + availableRanch);
            System.out.println("3. Forest              BG (3)  [5]      #" + availableForest);
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing                            ");
            System.out.println("==========================================");
        } else if (p1.getCoins() > 0 && p1.getCoins() < 3) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println("1. Wheat Field         BW (1)  [1]      #" + availableWheat);
            System.out.println("2. Ranch               BC (1)  [2]      #" + availableRanch);
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

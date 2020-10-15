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
    String options;
    
    public GameState(Player p1, Player p2) {
        availableWheat = 6;
        availableRanch = 6;
        availableForest = 6;
        activated = false;
        this.p1 = p1;
        this.p2 = p2;
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

    public void purchaseCard() { //TODO
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

    
    public String menuOptions() {
        //all
        String op1 = "1. Wheat Field         BW (1)  [1]      #" + availableWheat + "\n"
                    + "2. Ranch               BC (1)  [2]      #" + availableRanch + "\n"
                    + "3. Forest              BG (3)  [5]      #" + availableForest;
        //no wheat
        String op2 = "1. Ranch               BC (1)  [2]      #" + availableRanch + "\n"
                    + "2. Forest              BG (3)  [5]      #" + availableForest;
        //no ranch
        String op3 = "1. Wheat Field         BW (1)  [1]      #" + availableWheat + "\n"
                    + "2. Forest              BG (3)  [5]      #" + availableForest;
        //no forest
        String op4 = "1. Wheat Field         BW (1)  [1]      #" + availableWheat + "\n"
                    + "2. Ranch               BC (1)  [2]      #" + availableRanch;
        //no wheat & ranch
        String op5 = "1. Forest              BG (3)  [5]      #" + availableForest;
        //no wheat & forest
        String op6 = "1. Ranch               BC (1)  [2]      #" + availableRanch;
        //no ranch & forest
        String op7 = "1. Wheat Field         BW (1)  [1]      #" + availableWheat;
        //none
        String op8 = "";

        if(p1.getCoins() >= 3) {
            if(availableWheat == 0 && availableRanch == 0 && availableForest == 0) {
                return op8;
            }
            else if(availableWheat == 0) {
                return op2;
            }
            else if(availableRanch == 0) {
                return op3;
            }
            else if(availableForest == 0) {
                return op4;
            }
            else if(availableWheat == 0 && availableRanch == 0) {
                return op5;
            }
            else if(availableWheat == 0 && availableForest == 0) {
                return op6;
            }
            else if(availableRanch == 0 && availableForest == 0) {
                return op7;
            }
            else {
                return op1;
            }
        }
        else if(p1.getCoins() <= 3 && p1.getCoins() > 0) {
            if(availableWheat == 0 && availableRanch == 0) {
                return op8;
            }
            else if(availableWheat == 0) {
                return op6;
            }
            else if(availableRanch == 0) {
                return op7;
            }
            else {
                return op4;
            }
        }
        else {
            return op8;
        }

    }


    public void printMarketMenu() {
        System.out.println("To view details of an item, type 'view'"); //TODO how to get view working?
        System.out.println("followed by the item number. For example,");
        System.out.println("to view item 6, type 'view 6'.");
        if (p1.getCoins() >= 7) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println(menuOptions());
            System.out.println("---------       CONSTRUCT        ---------");
            System.out.println("4. City Hall           NT (7)  [ ]        ");
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing                            ");
            System.out.println("==========================================");
        } else if (p1.getCoins() < 7 && p1.getCoins() >=3) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println(menuOptions());
            System.out.println("---------         CANCEL         ---------");
            System.out.println("99. Do nothing                            ");
            System.out.println("==========================================");
        } else if (p1.getCoins() > 0 && p1.getCoins() < 3) {
            System.out.println("==========================================");
            System.out.println("---------        PURCHASE        ---------");
            System.out.println(menuOptions());
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

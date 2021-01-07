package Blockudoku;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */

public class Pontuation implements java.io.Serializable { 
    private final static int BASIC_SQUARE = 1;
    private final static int ADVANCED_SQUARE = 2;
    private final static int CLEAN_SQUARE = 4;
    private final static int NICE_SQUARES = 9;
    private final static int BONUS_BIG_SQUARE = 10;
    private int totalPoints;

    /**
     * This constructor will create a Pontuation with zero total points
     */
    public Pontuation() {
        totalPoints = 0;
    }
    
    /**
     * This method will increment one or two points according the Game Mode for each square placed and then multiplied by the number of '#' that the Block has
     * @param mode - Game Mode
     * @param block - Block that was placed
     */
    public void incrementPlacementPoints(Mode mode, Block block) {
        if(mode == Mode.BASIC)
            this.totalPoints += BASIC_SQUARE * block.getSpaceOccupied();
        else if(mode == Mode.ADVANCED)
            this.totalPoints += ADVANCED_SQUARE * block.getSpaceOccupied();
    }
    
    /**
     * This method will increment four points for a line, column or big square cleaned
     */
    public void incrementCleanSquarePoints() { this.totalPoints += CLEAN_SQUARE * NICE_SQUARES; }
    
    /**
     * This method will increment ten bonus points for completing a big square
     */
    public void incrementBonusPoints() { this.totalPoints += BONUS_BIG_SQUARE; }
    
    /**
     * This method will return the total points that the user has
     * @return int - total points of the Player
     */
    public int getTotalPoints() { return this.totalPoints; }
    
    /**
     * This method will return the total points in a String format
     * @return String - String with the Player's Pontuation
     */
    @Override
    public String toString() {
        String str = "" + totalPoints;
        return str.toString();
    }
    
    /**
     * This method will change the pontuation
     * @param pontuation - new number of points
     */
    public void setPoints(int pontuation) { this.totalPoints = pontuation; }
}

package Blockudoku;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */

public class Round implements java.io.Serializable {
    private static int roundNumber = 0;
    private Block blockA;
    private Block blockB;
    private Block blockC;
    
    /**
     * This constructor will initialize a Round
     * @param mode - Game Mode
     */
    public Round(Mode mode) {
        roundNumber++;
        if(mode == Mode.BASIC)
            generateThreeBasicBlocks();
        else
            generateThreeAdvancedBlocks();
    }
    
    /**
     * This method will return the number of the Round
     * @return int - number of actual Round
     */
    public int getRoundNumber() { return roundNumber; }
    
    /**
     * This methos will return the Block A
     * @return Block - Block A
     */
    public Block getBlockA() { return this.blockA; }
    
    /**
     * This methos will return the Block B
     * @return Block - Block B
     */
    public Block getBlockB() { return this.blockB; }
    
    /**
     * This methos will return the Block C
     * @return Block - Block C
     */
    public Block getBlockC() { return this.blockC; }
    
    /**
     * This method will set the Block A to null
     */
    public void clearBlockA() { this.blockA = null; }
    
    /**
     * This method will set the Block B to null
     */
    public void clearBlockB() { this.blockB = null; }
    
    /**
     * This method will set the Block C to null
     */
    public void clearBlockC() { this.blockC = null; }
    
    /**
     * This method will randomly generate three basic Blocks
     */
    private void generateThreeBasicBlocks() {
        Randomizer r = new Randomizer();
        blockA = r.generateBasicBlock();
        blockB = r.generateBasicBlock();
        blockC = r.generateBasicBlock();
    }
    
    /**
     * This method will randomly generate three advanced Blocks
     */
    private void generateThreeAdvancedBlocks() {
        Randomizer r = new Randomizer();
        blockA = r.generateAdvancedBlock();
        blockB = r.generateAdvancedBlock();
        blockC = r.generateAdvancedBlock();
    }
    
    /**
     * This method will return a formatted String of the available Blocks
     * @return String - formatted String of the available Blocks on the actual Round
     */
    public String availableBlocks() {
        String str = "Blocos a jogar:\n";
        if(blockA != null)
            str += "Bloco A\n" + blockA + "\n";
        if(blockB != null)
            str +="Bloco B\n" + blockB + "\n";
        if(blockC != null)
            str +="Bloco C\n" + blockC + "\n";
        return str;
                   
    }
    
    /**
     * This methos will return the number of the Round in a String format
     * @return String - String with the Round number
     */
    @Override
    public String toString() {
        String str = "" + roundNumber;
        return str.toString();
    }
    
    /**
     * This method will chamge the Round number
     * @param number - int with new Round number
     */
    public void setRoundNumber(int number) { this.roundNumber = number; }
}

package Blockudoku;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */

import java.util.Random;

public class Randomizer implements java.io.Serializable {
    
    /**
     * This constructor will initialize a Randomizer
     */
    public Randomizer() {
    }
    
    /**
     * This method will generate one basic Blocks
     * @return Block - basic Block generated
     */
    public Block generateBasicBlock() {
        Block b = null;
        Random randomSequence = new Random();
        int identifier = randomSequence.nextInt(7);
        switch (identifier) {
            case 0 : b = new BlockI();
                     break;
            case 1 : b = new BlockQ();
                     break;
            case 2 : b = new BlockT();
                     break;
            case 3 : b = new BlockL();
                     break;
            case 4 : b = new BlockJ();
                     break;
            case 5 : b = new BlockS();
                     break;
            case 6 : b = new BlockZ();
                     break;
        }
        return b;
    }
    
    /**
     * This method will generate one advanced Blocks
     * @return Block - advanced Block generated
     */
    public Block generateAdvancedBlock() {
        Block b = null;
        Random randomSequence = new Random();
        int identifier = randomSequence.nextInt(14);
        switch (identifier) {
            case 0 : b = new BlockI();
                     break;
            case 1 : b = new BlockQ();
                     break;            
            case 2 : b = new BlockT();
                     break;
            case 3 : b = new BlockL();
                     break;
            case 4 : b = new BlockJ();
                     break;
            case 5 : b = new BlockS();
                     break;
            case 6 : b = new BlockZ();
                     break;
            case 7 : b = new BlockI1();
                     break;
            case 8 : b = new BlockI2();
                     break;
            case 9 : b = new BlockI3();
                     break;
            case 10 : b = new BlockLmin();
                      break;
            case 11 : b = new BlockLmax();
                      break;
            case 12 : b = new BlockTbig();
                      break;
            case 13 : b = new BlockQbig();
                      break;
        }
        return b;
    }
    
    /**
     * This method will return the degree also generated
     * @return int - 0 or 90 or 180 or 270
     */
    public int generateBlockDegree() {
        int i = -1;
        Random randomSequence = new Random();
        int identifier = randomSequence.nextInt(4);
        switch (identifier) {
            case 0 : i = 0;
                     break;
            case 1 : i = 90;
                     break;
            case 2 : i = 180;
                     break;
            case 3 : i = 270;
                     break;
        }
        return i;
    }
}

     package Blockudoku;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public abstract class Block implements java.io.Serializable {
    protected char[][] coord;
    private int rotation;
    protected GridPane gridPane;
    protected Color color;
    
    /**
     * This constructor will create a Block and is the base to all subclasses
     */
    public Block() {
        gridPane = new GridPane();
        //gridPane.setHgap(20);
        //gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        this.rotation = blockDegree();
    }
    
    /**
     * This method will generate a certain degree for a block  
     * @return 0 or 90 or 180 or 270
     */
    private int blockDegree() {
        Randomizer r = new Randomizer();
        return r.generateBlockDegree();
    }
    
    /**
     * This method will create a block, and each Block class will do an Override of this method
     */
    protected abstract void createBlock();
    
    /**
     * This method will fill the Block positions
     */
    protected abstract void fillBlock();
    
    /**
     * This method will return the rotation generated to a Block
     * @return int - 0 or 90 or 180 or 270
     */
    public int getRotation() { return this.rotation; }
    
    /**
     * This method will return the number of lines of a Block
     * @return int - number of lines of a Block
     */
    public int getNumberOfLines() { return coord.length; }
    
    /**
     * This method will return the number of columns of a Block
     * @return int - number of columns of a Block
     */
    public int getNumberOfColumns() { return coord[0].length; }
    
    /**
     * This method will return a formatted String with the Block representation
     * @return String - formatted Block representation
     */
    @Override
    public String toString() {
        String str = "";
        for(int l=0 ; l<coord.length ; l++) {
            for(int c=0 ; c<coord[l].length ; c++) {
                if(coord[l][c] == 0)
                    str += "  ";
                else
                    str += coord[l][c] + " ";
            }
            str += "\n";
        }
        return str.toString();
    }
    
    /**
     * This method will return the number of '#' a Block has
     * @return int - number of filled spaces of a Block
     */
    public int getSpaceOccupied() {
        int spaceOccupied = 0;
        for(int l=0 ; l<coord.length ; l++) {
            for(int c=0 ; c<coord[l].length ; c++) {
                if(coord[l][c] == '#')
                    spaceOccupied++;
            }
        }
        return spaceOccupied;
    }
    
    /**
     * This method will return where if the most coordenate on the left and on the top
     * @return int - number of the most coordenate on the left and on the top
     */
    public int leftAndUpperCoord() {
        for(int i=0 ; i<getNumberOfLines() ; i++) {
            if(coord[i][0] == '#')
                return i;
        }
        return -1;
    }
    
    /**
     * This method will check if the Block is fiiled on a certain coordenate
     * @param line - coordenate on x
     * @param column - coordenate on y
     * @return true - if the Block is fiiled on a certain coordenate; false - if the Block isn't filled on a certain coordenate
     */
    public boolean isCoordFilled(int line, int column) {
        return coord[line][column] == '#';
    }
    
    /**
     * This method will return the Block's GridPane representation
     * @return GridPane - block's representation
     */
    public GridPane getBlockGridPane() { return this.gridPane; }
    
    /**
     * This method will return the color of the Block
     * @return Color - color of the Block
     */
    public Color getColor() { return this.color; }
}
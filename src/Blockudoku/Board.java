package Blockudoku;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class Board implements java.io.Serializable {
    private char[][] gameBoard;
    private GridPane gridPane;
    
    /**
     * This constructor will create a char bidimentional array initialize it and create the Board representation in a GridPane
     */
    public Board() {
        gameBoard = new char[9][9];
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        initializeBoard();
    }
    
    /**
     * This method will return a formatted String of the Board
     * @return String - representation of the Board
     */
    @Override
    public String toString() {
        String str = " |A|B|C|D|E|F|G|H|I\n";
        for(int l=0 ; l<gameBoard.length ; l++) {
            str += l+1;
            for(int c=0 ; c<gameBoard[l].length ; c++) {
                str += "|" + gameBoard[l][c];
            }
            str += "\n";
        }
        return str.toString();
    }
    
    /**
     * This method will fill all the lines and collumns with a dot (empty) and fill the GridPane with Silver squares
     */
    private void initializeBoard() {
        for (int l=0; l < gameBoard.length; l++) { 
            for (int c=0; c < gameBoard[l].length; c++) {
                Rectangle rec = new Rectangle(40, 40, Color.SILVER);
                rec.setStroke(Color.BLACK);
                rec.setStrokeWidth(2);
                gridPane.add(rec, l, c, 1, 1);
                gameBoard[l][c] = '.';
            } 
        }
    }
    
    /**
     * This method will convert a char into an int 
     * @param characterLine - char of the x position
     * @return int - number of a line
     */
    private int convertToLine(char characterLine) { return Character.getNumericValue(characterLine) - 1; }
    
    /**
     * This method will convert a char into an int 
     * @param characterColumn - char of the y position
     * @return int - number of a column
     */
    private int convertToColumn(char characterColumn) {
        int c = -1;
        switch(characterColumn) {
            case 'A': c = 0;
                      break;
            case 'B': c = 1;
                      break;
            case 'C': c = 2;
                      break;
            case 'D': c = 3;
                      break;
            case 'E': c = 4;
                      break;
            case 'F': c = 5;
                      break;
            case 'G': c = 6;
                      break;
            case 'H': c = 7;
                      break;
            case 'I': c = 8;
                      break;
        }
        return c;
    }

    /**
     * This method will check if a line is filled
     * @return line - number of the line that is filled ; -1 - if there isn't a filled line
     */
    public int fullLine() {
        int lineHelp = 0;
        int line;
        for(line=0 ; line<gameBoard.length ; line++) {
            for(int c=0 ; c<gameBoard[line].length ; c++) {
                if(gameBoard[line][c] == '#')
                    lineHelp++;
            }
            if(lineHelp == 9)
                return line;
            lineHelp = 0;
        }
        return -1;
    }
    
    /**
     * This method will check if a column is filled
     * @return column - number of the column that is filled ; -1 - if there isn't a filled column
     */
    public int fullColumn() {
        int columnHelp = 0;
        int column;
        for(column=0 ; column<gameBoard[0].length ; column++) {
            for(int l=0 ; l<gameBoard.length ; l++) {
                if(gameBoard[l][column] == '#')
                    columnHelp++;
            }
            if(columnHelp == 9)
                return column;
            columnHelp = 0;
        }
        return -1;
    }
    
    /**
     * This method will check if the big square corresponding to the number of the given square is filled
     * @param square - number of the big square
     * @return true - if the if the big square is filled ; false - if the big square isn't filled
     */
    public boolean fullSquare(int square) {
        int squareHelp = 0;
        switch(square) {
            case 1:
                for(int l=0 ; l<3 ; l++) {
                    for(int c=0; c<3 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
            case 2:
                for(int l=0 ; l<3 ; l++) {
                    for(int c=3; c<6 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
            case 3:
                for(int l=0 ; l<3 ; l++) {
                    for(int c=6; c<9 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
            case 4:
                for(int l=3 ; l<6 ; l++) {
                    for(int c=0; c<3 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
            case 5:
                for(int l=3 ; l<6 ; l++) {
                    for(int c=3; c<6 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
            case 6:
                for(int l=3 ; l<6 ; l++) {
                    for(int c=6; c<9 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
            case 7:
                for(int l=6 ; l<9 ; l++) {
                    for(int c=0; c<3 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
            case 8:
                for(int l=6 ; l<9 ; l++) {
                    for(int c=3; c<6 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
            case 9:
                for(int l=6 ; l<9 ; l++) {
                    for(int c=6; c<9 ; c++) {
                        if(gameBoard[l][c] == '#')
                            squareHelp++;
                    }
                }
                if(squareHelp == 9) return true;
                else squareHelp = 0;
                break;
        }
        return false;
    }
    
    /**
     * This method will check if a big square is filled
     * @return i - number of the big square that is filled ; -1 - if there isn't a filled big square
     */
    public int fullBigSquare() {
        for(int i=1 ; i<=9 ; i++) {
            if(fullSquare(i))
                return i;
        }
        return -1;
    }
    
    /**
     * This method will clear a certain line 
     * @param line - number of the line to be cleaned
     */
    public void clearLine(int line) {
        for(int c=0 ; c<gameBoard[0].length ; c++) {
            gameBoard[line][c] = '.';
            changeRectangleColor(c, line, Color.SILVER);
        }
    }
    
    /**
     * This method will clear a certain column
     * @param column - number of the column to be cleaned
     */
    public void clearColumn(int column) {
        for(int l=0 ; l<gameBoard.length ; l++) {
            gameBoard[l][column] = '.';
            changeRectangleColor(column, l, Color.SILVER);
        }
    }
    
    /**
     * This method will clear a certain big square
     * @param bigSquare - number of the big square to be cleaned
     */
    public void clearBigSquare(int bigSquare) {
        switch(bigSquare) {
            case 1:
                for(int l=0 ; l<3 ; l++) {
                    for(int c=0; c<3 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
            case 2:
                for(int l=0 ; l<3 ; l++) {
                    for(int c=3; c<6 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
            case 3:
                for(int l=0 ; l<3 ; l++) {
                    for(int c=6; c<9 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
            case 4:
                for(int l=3 ; l<6 ; l++) {
                    for(int c=0; c<3 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
            case 5:
                for(int l=3 ; l<6 ; l++) {
                    for(int c=3; c<6 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
            case 6:
                for(int l=3 ; l<6 ; l++) {
                    for(int c=6; c<9 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
            case 7:
                for(int l=6 ; l<9 ; l++) {
                    for(int c=0; c<3 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
            case 8:
                for(int l=6 ; l<9 ; l++) {
                    for(int c=3; c<6 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
            case 9:
                for(int l=6 ; l<9 ; l++) {
                    for(int c=6; c<9 ; c++) {
                        gameBoard[l][c] = '.';
                        changeRectangleColor(c, l, Color.SILVER);
                    }
                }
                break;
        }
    }
    
    /**
     * This method will check if the Block given fits in a certain position also given by the user
     * @param block - Block given by the user
     * @param position - String that contains the coordenates (column and line, on this order)
     * @return true - if the Block fits on the position ; false - if the Block doesn't fit on the position
     */
    public boolean checkBlockInPosition(Block block, String position) {
        if(block == null)
            return false;
        int positionL = convertToLine(position.charAt(1));
        int positionC = convertToColumn(position.toUpperCase().charAt(0));
        int help = block.leftAndUpperCoord();
        if(positionL + block.getNumberOfLines() - help > gameBoard.length || positionC + block.getNumberOfColumns() > gameBoard[0].length)
            return false;
        for(int i=0 ; i<block.getNumberOfLines() ; i++) {
            for(int j=0 ; j<block.getNumberOfColumns() ; j++) {
                if((positionL + i - help) < 0)
                    return false;
                if(block.isCoordFilled(i, j) && gameBoard[positionL+i-help][positionC+j] == '#')
                    return false;
            }
        }
        return true;
    }
        
    /**
     * This method will put the Block given on the position also given by the user
     * @param block - Block given by the user
     * @param position - String that contains the coordenates (column and line, on this order)
     */
    public void putBlock(Block block, String position) {
        int positionL = convertToLine(position.charAt(1));
        int positionC = convertToColumn(position.toUpperCase().charAt(0));
        int help = block.leftAndUpperCoord();
        for(int i=0 ; i<block.getNumberOfLines() ; i++) {
            for(int j=0 ; j<block.getNumberOfColumns() ; j++) {
                if(block.isCoordFilled(i, j)) {
                    if(positionL+i-help >= 0) {
                        gameBoard[positionL+i-help][positionC+j] = '#';
                        changeRectangleColor(positionC+j, positionL+i-help, block.getColor());
                    }
                }
            }
        }
    }
    
    /**
     * This method will check if the Block given fits on the Board 
     * @param block - Block given bu the user
     * @return true - if the Block fits on the Board ; false - if the Block doesn't fit on the Board
     */
    public boolean checkIfBlockFits(Block block) {
        for(char l='1' ; l<='9' ; l++) {
            for(char c='A' ; c<='I' ; c++) {
                StringBuilder str = new StringBuilder();
                str.append(c);
                str.append(l);
                if(checkBlockInPosition(block, str.toString()))
                    return true;
            }
        }
        return false;
    }
    
    /**
     * This method will return the Board's representation in a GridPane
     * @return GridPane - Board's representation
     */
    public GridPane getBoardGridPane() { return this.gridPane; }
    
    /**
     * This method will change the color of a square of the Board's GridPane after a block is introduced into the Board or after a line/column/bigSquare is cleaned
     * @param column - Column of the Square to be changed
     * @param line - Line of the Square to be changed
     * @param color - New Color of the Square
     */
    public void changeRectangleColor(int column, int line, Color color) {
        Rectangle rec = new Rectangle(40, 40, color);
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        gridPane.add(rec, column, line);
        
        if (color.equals(Color.SILVER)) {
            FadeTransition ft = new FadeTransition(Duration.seconds(2.3), rec);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            
            for(Node node : gridPane.getChildren()) {
                if(gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == line) {
                    ft.setOnFinished((event) -> {
                        gridPane.getChildren().remove(node);
                    });
                    break;
                }
            }
            ft.play();
        }
        else {
            FillTransition ft = new FillTransition(Duration.seconds(0.6), rec, Color.SILVER, color);
            ft.setAutoReverse(false);
            for(Node node : gridPane.getChildren()) {
                if(gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == line) {
                    gridPane.getChildren().remove(node);
                    break;
                }
            }
            ft.play();
        }
    }
    
    /**
     * This method will fill a position at the board with '#'
     * @param line - Line to be filled
     * @param column - Column to be filled
     */
    public void fillAtPosition(int line, int column) {
        gameBoard[line][column] = '#';
    }
}

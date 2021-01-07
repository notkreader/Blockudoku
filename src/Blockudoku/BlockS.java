package Blockudoku;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class BlockS extends Block {
    
    public BlockS() {
        super();
        createBlock();
        fillBlock();
        color = Color.YELLOW;
    }
    
    @Override
    protected void createBlock() {
        int r = getRotation();
        switch(r) {
            case 0   : coord = new char[2][3];
                       break;
            case 90  : coord = new char[3][2];
                       break;
            case 180 : coord = new char[2][3];
                       break;
            case 270 : coord = new char[3][2];
                       break;
        }
    }
    
    @Override
    protected void fillBlock() {
        Rectangle rec1 = new Rectangle(40, 40, Color.YELLOW);
        rec1.setStroke(Color.BLACK);
        rec1.setStrokeWidth(2);
        Rectangle rec2 = new Rectangle(40, 40, Color.YELLOW);
        rec2.setStroke(Color.BLACK);
        rec2.setStrokeWidth(2);
        Rectangle rec3 = new Rectangle(40, 40, Color.YELLOW);
        rec3.setStroke(Color.BLACK);
        rec3.setStrokeWidth(2);
        Rectangle rec4 = new Rectangle(40, 40, Color.YELLOW);
        rec4.setStroke(Color.BLACK);
        rec4.setStrokeWidth(2);
        if(getRotation() == 0 || getRotation() == 180) {
            coord[0][1] = '#'; gridPane.add(rec1, 1, 0);
            coord[0][2] = '#'; gridPane.add(rec2, 2, 0);
            coord[1][0] = '#'; gridPane.add(rec3, 0, 1);
            coord[1][1] = '#'; gridPane.add(rec4, 1, 1);
        }
        else if(getRotation() == 90 || getRotation() == 270) {
            coord[0][0] = '#'; gridPane.add(rec1, 0, 0);
            coord[1][0] = '#'; gridPane.add(rec2, 0, 1);
            coord[1][1] = '#'; gridPane.add(rec3, 1, 1);
            coord[2][1] = '#'; gridPane.add(rec4, 1, 2);
        }
    }
}

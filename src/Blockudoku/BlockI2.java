package Blockudoku;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class BlockI2 extends Block {
    
    public BlockI2() {
        super();
        createBlock();
        fillBlock();
        color = Color.BLUE;
    }
    
    @Override
    protected void createBlock() {
        int r = getRotation();
        switch(r) {
            case 0   : coord = new char[2][1];
                       break;
            case 90  : coord = new char[1][2];
                       break;
            case 180 : coord = new char[2][1];
                       break;
            case 270 : coord = new char[1][2];
                       break;
        }
    }
    
    @Override
    protected void fillBlock() {
        Rectangle rec1 = new Rectangle(40, 40, Color.BLUE);
        rec1.setStroke(Color.BLACK);
        rec1.setStrokeWidth(2);
        Rectangle rec2 = new Rectangle(40, 40, Color.BLUE);
        rec2.setStroke(Color.BLACK);
        rec2.setStrokeWidth(2);
        if(getRotation() == 0 || getRotation() == 180) {
            coord[0][0] = '#'; gridPane.add(rec1, 0, 0);
            coord[1][0] = '#'; gridPane.add(rec2, 0, 1);
        }
        else if(getRotation() == 90 || getRotation() == 270) {
            coord[0][0] = '#'; gridPane.add(rec1, 0, 0);
            coord[0][1] = '#'; gridPane.add(rec2, 1, 0);
        }
    }
}

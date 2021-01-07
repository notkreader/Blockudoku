package Blockudoku;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class BlockLmin extends Block {
    
    public BlockLmin() {
        super();
        createBlock();
        fillBlock();
        color = Color.LIME;
    }
    
    @Override
    protected void createBlock() {
        coord = new char[2][2];
    }
    
    @Override
    protected void fillBlock() {
        Rectangle rec1 = new Rectangle(40, 40, Color.LIME);
        rec1.setStroke(Color.BLACK);
        rec1.setStrokeWidth(2);
        Rectangle rec2 = new Rectangle(40, 40, Color.LIME);
        rec2.setStroke(Color.BLACK);
        rec2.setStrokeWidth(2);
        Rectangle rec3 = new Rectangle(40, 40, Color.LIME);
        rec3.setStroke(Color.BLACK);
        rec3.setStrokeWidth(2);
        if(getRotation() == 0) {
            coord[0][0] = '#'; gridPane.add(rec1, 0, 0);
            coord[1][0] = '#'; gridPane.add(rec2, 0, 1);
            coord[1][1] = '#'; gridPane.add(rec3, 1, 1);
        }
        else if(getRotation() == 90) {
            coord[0][1] = '#'; gridPane.add(rec1, 1, 0);
            coord[1][0] = '#'; gridPane.add(rec2, 0, 1);
            coord[1][1] = '#'; gridPane.add(rec3, 1, 1);
        }
        else if(getRotation() == 180) {
            coord[0][0] = '#'; gridPane.add(rec1, 0, 0);
            coord[0][1] = '#'; gridPane.add(rec2, 1, 0);
            coord[1][1] = '#'; gridPane.add(rec3, 1, 1);
        }
        else if(getRotation() == 270) {
            coord[0][0] = '#'; gridPane.add(rec1, 0, 0);
            coord[0][1] = '#'; gridPane.add(rec2, 1, 0);
            coord[1][0] = '#'; gridPane.add(rec3, 0, 1);
        }
    }
}

package Blockudoku;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class BlockI1 extends Block {
    
    public BlockI1() {
        super();
        createBlock();
        fillBlock();
        color = Color.BLUE;
    }
    
    @Override
    protected void createBlock() {
        coord = new char[1][1];
    }
    
    @Override
    protected void fillBlock() {
        Rectangle rec = new Rectangle(40, 40, Color.BLUE);
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        coord[0][0] = '#'; gridPane.add(rec, 0, 0);
    }
}

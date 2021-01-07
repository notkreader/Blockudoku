package Blockudoku;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class BlockQbig extends Block {
    
    public BlockQbig() {
        super();
        createBlock();
        fillBlock();
        color = Color.ORANGE;
    }
    
    @Override
    protected void createBlock() {
        coord = new char[3][3];
    }
    
    @Override
    protected void fillBlock() {
        Rectangle rec1 = new Rectangle(40, 40, Color.ORANGE);
        rec1.setStroke(Color.BLACK);
        rec1.setStrokeWidth(2);
        Rectangle rec2 = new Rectangle(40, 40, Color.ORANGE);
        rec2.setStroke(Color.BLACK);
        rec2.setStrokeWidth(2);
        Rectangle rec3 = new Rectangle(40, 40, Color.ORANGE);
        rec3.setStroke(Color.BLACK);
        rec3.setStrokeWidth(2);
        Rectangle rec4 = new Rectangle(40, 40, Color.ORANGE);
        rec4.setStroke(Color.BLACK);
        rec4.setStrokeWidth(2);
        Rectangle rec5 = new Rectangle(40, 40, Color.ORANGE);
        rec5.setStroke(Color.BLACK);
        rec5.setStrokeWidth(2);
        Rectangle rec6 = new Rectangle(40, 40, Color.ORANGE);
        rec6.setStroke(Color.BLACK);
        rec6.setStrokeWidth(2);
        Rectangle rec7 = new Rectangle(40, 40, Color.ORANGE);
        rec7.setStroke(Color.BLACK);
        rec7.setStrokeWidth(2);
        Rectangle rec8 = new Rectangle(40, 40, Color.ORANGE);
        rec8.setStroke(Color.BLACK);
        rec8.setStrokeWidth(2);
        Rectangle rec9 = new Rectangle(40, 40, Color.ORANGE);
        rec9.setStroke(Color.BLACK);
        rec9.setStrokeWidth(2);
        coord[0][0] = '#'; gridPane.add(rec1, 0, 0);
        coord[0][1] = '#'; gridPane.add(rec2, 1, 0);
        coord[0][2] = '#'; gridPane.add(rec3, 2, 0);
        coord[1][0] = '#'; gridPane.add(rec4, 0, 1);
        coord[1][1] = '#'; gridPane.add(rec5, 1, 1);
        coord[1][2] = '#'; gridPane.add(rec6, 2, 1);
        coord[2][0] = '#'; gridPane.add(rec7, 0, 2);
        coord[2][1] = '#'; gridPane.add(rec8, 1, 2);
        coord[2][2] = '#'; gridPane.add(rec9, 2, 2);
    }
}

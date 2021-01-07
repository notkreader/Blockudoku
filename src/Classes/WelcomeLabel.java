package Classes;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class WelcomeLabel extends HBox {
    
    /**
     * This constructor will display the main menu of Blockudoku Game 
     * @param playerName - String with the Player's name
     */
    public WelcomeLabel(String playerName) {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(30));
        
        Label initialLabelOne = new Label("Bem-vindo ao Jogo");
        initialLabelOne.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 40));
        initialLabelOne.setTextFill(Color.BLACK);
        
        Label initialLabelTwo = new Label("Blockudoku!");
        initialLabelTwo.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 60));
        initialLabelTwo.setTextFill(Color.BLACK);
        
        Rectangle recMiddle1 = new Rectangle(60, 60, Color.RED);
        recMiddle1.setStroke(Color.BLACK);
        recMiddle1.setStrokeWidth(2);
        
        Rectangle recMiddle2 = new Rectangle(60, 60, Color.rgb(213, 213, 213));
        recMiddle2.setStroke(Color.BLACK);
        recMiddle2.setStrokeWidth(2);
        
        HBox middle = new HBox(29);
        middle.setAlignment(Pos.CENTER);
        middle.getChildren().addAll(recMiddle1, initialLabelTwo, recMiddle2);
        
        Label nameLabel = new Label("Jogador: " + playerName);
        nameLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 25));
        nameLabel.setTextFill(Color.BLACK);
        
        Rectangle rec1 = new Rectangle(60, 60, Color.BLUE);
        rec1.setStroke(Color.BLACK);
        rec1.setStrokeWidth(2);
        
        Rectangle rec2 = new Rectangle(60, 60, Color.LIME);
        rec2.setStroke(Color.BLACK);
        rec2.setStrokeWidth(2);
        
        Rectangle rec3 = new Rectangle(60, 60, Color.FUCHSIA);
        rec3.setStroke(Color.BLACK);
        rec3.setStrokeWidth(2);
        
        Rectangle rec4 = new Rectangle(60, 60, Color.YELLOW);
        rec4.setStroke(Color.BLACK);
        rec4.setStrokeWidth(2);
        
        Rectangle rec5 = new Rectangle(60, 60, Color.TURQUOISE);
        rec5.setStroke(Color.BLACK);
        rec5.setStrokeWidth(2);
        
        Rectangle rec6 = new Rectangle(60, 60, Color.ORANGE);
        rec6.setStroke(Color.BLACK);
        rec6.setStrokeWidth(2);
        
        HBox pos1 = new HBox(150);
        pos1.setAlignment(Pos.CENTER);
        pos1.getChildren().addAll(rec1, rec2, rec3);
        
        HBox pos2 = new HBox(150);
        pos2.setAlignment(Pos.CENTER);
        pos2.getChildren().addAll(rec4, rec5, rec6);
        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(pos1, initialLabelOne, middle, nameLabel, pos2);
        vbox.setAlignment(Pos.CENTER);
        
        this.getChildren().addAll(vbox);
        
        FillTransition ft1 = new FillTransition(Duration.seconds(3), rec1, Color.BLUE, Color.FUCHSIA);
        ft1.setCycleCount(Animation.INDEFINITE);
        ft1.setAutoReverse(true);
        ft1.play();
        
        FillTransition ft2 = new FillTransition(Duration.seconds(3), rec2, Color.LIME, Color.TURQUOISE);
        ft2.setCycleCount(Animation.INDEFINITE);
        ft2.setAutoReverse(true);
        ft2.play();
        
        FillTransition ft3 = new FillTransition(Duration.seconds(3), rec3, Color.FUCHSIA, Color.BLUE);
        ft3.setCycleCount(Animation.INDEFINITE);
        ft3.setAutoReverse(true);
        ft3.play();
        
        FillTransition ft4 = new FillTransition(Duration.seconds(3), rec4, Color.YELLOW, Color.ORANGE);
        ft4.setCycleCount(Animation.INDEFINITE);
        ft4.setAutoReverse(true);
        ft4.play();
        
        FillTransition ft5 = new FillTransition(Duration.seconds(3), rec5, Color.TURQUOISE, Color.LIME);
        ft5.setCycleCount(Animation.INDEFINITE);
        ft5.setAutoReverse(true);
        ft5.play();
        
        FillTransition ft6 = new FillTransition(Duration.seconds(3), rec6, Color.ORANGE, Color.YELLOW);
        ft6.setCycleCount(Animation.INDEFINITE);
        ft6.setAutoReverse(true);
        ft6.play();
        
        FillTransition ft7 = new FillTransition(Duration.seconds(3), recMiddle1, Color.RED, Color.rgb(213, 213, 213));
        ft7.setCycleCount(Animation.INDEFINITE);
        ft7.setAutoReverse(true);
        ft7.play();
        
        FillTransition ft8 = new FillTransition(Duration.seconds(3), recMiddle2, Color.rgb(213, 213, 213), Color.RED);
        ft8.setCycleCount(Animation.INDEFINITE);
        ft8.setAutoReverse(true);
        ft8.play();
        
        ScaleTransition st = new ScaleTransition(Duration.seconds(1.5), vbox);
        st.setToX(1.1);
        st.setToY(1.1);
        st.setCycleCount(Integer.MAX_VALUE);
        st.setAutoReverse(true);
        st.play();
    }
    
}

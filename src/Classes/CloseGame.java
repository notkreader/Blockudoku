package Classes;

import Blockudoku.MenuInfo;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class CloseGame extends VBox {
    
    /**
     * This constructor will call the createWindow method
     */
    public CloseGame() {
        createWindow();
    }
    
    /**
     * This method will ask the user of he's sure to leave the game
     */
    public void createWindow() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(30));
        
        Label exitLabel = new Label("Pretende Saír do Jogo?");
        exitLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 40));
        
        Button yes = new Button("Sim");
        yes.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        yes.setMinWidth(80);
        yes.setFocusTraversable(true);
        yes.setOnAction(e -> {
            Platform.exit();
        });
        
        Button no = new Button("Não");
        no.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        no.setMinWidth(80);
        no.setFocusTraversable(true);
        no.setOnAction(e -> 
                ((Stage) no.getScene().getWindow()).close());
        
        HBox hbox = new HBox(30);
        hbox.getChildren().addAll(yes, no);
        hbox.setAlignment(Pos.CENTER);
        
        this.getChildren().addAll(exitLabel, hbox);
    }
}

package Classes;

import Blockudoku.Commands;
import Blockudoku.FileManagement;
import Blockudoku.Game;
import Blockudoku.InputReader;
import StartGame.ViewApp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class ModeSelector extends BorderPane {
    private GameFX gameFX;
    private String playerName;
    private int gameMode;

    /**
     * This constructor will receive the player's name and call the createContent method
     * @param playerName - String with the player's Name
     */
    public ModeSelector(String playerName) {
        this.playerName = playerName;
        createContent();
    }
    
    /**
     * This method will display to the user the two game mode's that can be choosen to play and initialize a Game with the choosen one
     */
    private void createContent() {
        
        Label selectLabel = new Label("Selecione um Modo de Jogo");
        selectLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 40));
        
        Button normalBtn = new Button("Modo Básico");
        normalBtn.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        normalBtn.setMinWidth(165);
        normalBtn.setFocusTraversable(true);
        normalBtn.setOnAction(e -> {
            this.gameMode = 1;
            this.gameFX = new GameFX(playerName, gameMode);
            showGameFX();
        });
        
        Button hardBtn = new Button("Modo Avançado");
        hardBtn.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        hardBtn.setMinWidth(165);
        hardBtn.setFocusTraversable(true);
        hardBtn.setOnAction(e -> { 
            this.gameMode = 2;
            this.gameFX = new GameFX(playerName, gameMode);
            showGameFX();
        });
        
        Button back = new Button("Voltar");
        back.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        back.setMinWidth(40);
        back.setFocusTraversable(true);
        back.setOnAction(e -> {
                this.getScene().setRoot(new ViewApp());
        });
        
        HBox hbox1 = new HBox(30);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(normalBtn, hardBtn, back);
        
        VBox vbox1 = new VBox(10);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.getChildren().addAll(selectLabel, hbox1);
        
        this.setCenter(vbox1);
    }
    
    /**
     * This method will change the senter of this stage to the GameFX is the user have choosen a Basic or Advanced game mode
     */
    public final void showGameFX() { this.setCenter(gameFX); }
    
    /**
     * This method will return the current GameFX
     * @return GameFX - actual GameFX
     */
    public GameFX getGameFX() { return this.gameFX; }
}
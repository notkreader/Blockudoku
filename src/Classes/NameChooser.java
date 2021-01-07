package Classes;

import StartGame.ViewApp;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class NameChooser extends VBox {
    private TextField txtField;
    private Text errorMsg;
    private String playerName;
            
    /**
     * This constructor will call the createNameAsk method
     */
    public NameChooser() {
        createNameAsk();
    }
    
    /**
     * This method will display a TextField to the user introduces his name
     */
    private void createNameAsk() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(30));
        
        Label nameLabel = new Label("Nome:");
        nameLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        txtField = new TextField();
        txtField.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        txtField.setMinHeight(40);
        txtField.setPromptText("Introduz o teu nome");
        txtField.setPrefColumnCount(30);
        HBox txtBox = new HBox(10);
        txtBox.getChildren().addAll(nameLabel, txtField);
        txtBox.setAlignment(Pos.CENTER);
        
        Button ok = new Button("Ok");
        ok.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        ok.setMinWidth(100);
        ok.setOnAction(e -> {
                if(!nameCheck())
                    showError();
                else 
                    this.getScene().setRoot(new ViewApp());
        });
        
        txtField.setOnAction(e -> {
                if(!nameCheck())
                    showError();
                else 
                    this.getScene().setRoot(new ViewApp());
        });
        
        Button clear = new Button("Limpar");
        clear.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        clear.setMinWidth(100);
        clear.setOnAction(e -> {
                clearName();
        });
        
        Button close = new Button("Saír");
        close.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        close.setMinWidth(100);
        close.setOnAction(e -> {
            Stage exitWindow = new Stage();
            exitWindow.setTitle("Blockudoku: Saír do Jogo");
            exitWindow.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
            exitWindow.setScene(new Scene(new CloseGame(), 800, 500));
            exitWindow.centerOnScreen();
            exitWindow.show();
        });
        
        HBox buttonsBox = new HBox(30);
        buttonsBox.getChildren().addAll(ok, clear, close);
        buttonsBox.setAlignment(Pos.CENTER);
        
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(txtBox, buttonsBox);
        
        ok.requestFocus();
    }
    
    /**
     * This method will check if the name given by the user is valid or invalid
     * @return true - if the name is valid; false - if the name is invalid
     */
    public boolean nameCheck() {
        String name = txtField.getText().trim();
        if(name.isEmpty())
            return false;
        this.playerName = name;
        return true;
    }
    
    /**
     * This method will display an error alert if the name given by the user is invalid
     */
    private void showError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Nome Inválido!");
        alert.setHeaderText("Erro - Nome Inválido");
        String s = "Erro!!! O nome introduzido é inválido! "
                + "\nIntroduz um nome válido.";
        alert.setContentText(s);
        alert.showAndWait();
    }
    
    /**
     * This method will clear the textField
     */
    private void clearName() {
        txtField.setText("");
        txtField.setPromptText("Introduz o teu nome");
    }
    
    /**
     * This method will return the Player's name
     * @return String - Player's name
     */
    public String getPlayerName() {
        return this.playerName;
    }
}

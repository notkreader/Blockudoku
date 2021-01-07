package Classes;

import Blockudoku.FileManagement;
import Blockudoku.MenuInfo;
import StartGame.ViewApp;
import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class SaveGame extends VBox {
    private TextField txtField;
    private GameFX gameFx;
    
    /**
     * This constructor will change the gameFx attribute to the actual GameFX and call the createSaveBox method
     * @param modeSelector - ModeSelector
     */
    public SaveGame(ModeSelector modeSelector) {
        if(modeSelector != null && modeSelector.getGameFX() != null)
            this.gameFx = modeSelector.getGameFX();
        createSaveBox();
    }
    
    /**
     * This method will display a TextField to the user give the name of the file that the game will be saved to
     */
    private void createSaveBox() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(130));
        
        Label infoLabel = new Label("Insere o nome do ficheiro de destino");
        infoLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        
        txtField = new TextField();
        txtField.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 16));
        txtField.setMinHeight(2);
        txtField.setPromptText("Nome do Ficheiro");
        txtField.setPrefColumnCount(2);
        
        Button ok = new Button("Ok");
        ok.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 16));
        ok.setMinWidth(50);
        ok.setOnAction(e -> {
                if(!validateFileName())
                    showError();
                FileManagement.saveGameFxInfo(txtField.getText(), gameFx);
                ((Stage) ok.getScene().getWindow()).close();
                    
        });
        
        Button clear = new Button("Limpar");
        clear.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 16));
        clear.setMinWidth(50);
        clear.setOnAction(e -> {
                clearFileName();
        });
        
        Button back = new Button("Voltar");
        back.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 16));
        back.setMinWidth(50);
        back.setFocusTraversable(true);
        back.setOnAction(e -> 
                ((Stage) back.getScene().getWindow()).close());
        
        HBox buttonsBox = new HBox(10);
        buttonsBox.getChildren().addAll(ok, clear, back);
        buttonsBox.setAlignment(Pos.CENTER);
        
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(infoLabel, txtField, buttonsBox);
    }
    
    /**
     * This method will check if the file name given by the user is valid or invalid
     * @return true - if the file name is valid; false - if the file name is invalid
     */
    private boolean validateFileName() {
        if(txtField.getText().isEmpty())
            return false;
        String move = txtField.getText().toUpperCase().trim();
        if(move.length() == 0 || move == null)
            return false;
        return true;
    }
    
    /**
     * This method will clear the TextField
     */
    private void clearFileName() {
        txtField.setText("");
        txtField.setPromptText("Nome do Ficheiro");
    }
    
    /**
     * This method will display an error alert if the file name is invalid
     */
    private void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Nome Inválido");
        alert.setHeaderText("Nome do ficheiro inserido inválido");
        String s = "Introduz um nome válido ";
        alert.setContentText(s);
        alert.showAndWait();
    }
}

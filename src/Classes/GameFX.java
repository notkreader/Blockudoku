package Classes;

import Blockudoku.FileManagement;
import Blockudoku.Game;
import Blockudoku.Player;
import Blockudoku.InputReader;
import Blockudoku.Mode;
import StartGame.ViewApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class GameFX extends HBox {
    private TextField txtField;
    private Game game;
    private String playerName;
    private int gameMode;
    private String move;
    private GridPane gpA, gpB, gpC;
    
    /**
     * This constructor will create a Game and call the startGame method
     * @param playerName - String with the name of the Player
     * @param gameMode - 1 if the gameMode is Basic; 2 - if the gameMode is Advanced
     */
    public GameFX(String playerName, int gameMode) {
        this.playerName = playerName;
        this.gameMode = gameMode;
        game = new Game();
        game.createPlayer(playerName);
        game.setGameMode(this.gameMode);
        game.nextRound();
        game.getRound().setRoundNumber(1);
        startGame();
    }
    
    /**
     * This constructor will create a Game just to display the leaderBoard and the personalBoard while the main game isn't running
     */
    public GameFX() {
        this.game = new Game();
    }
    
    /**
     * This constructor will create a Game with the loaded one choosed by the user
     * @param savedGame - Game choosed to play buy the user that was saved before
     */
    public GameFX(Game savedGame) {
        this.game = savedGame;
        this.playerName = savedGame.getPlayer().getName();
        Mode mode = savedGame.getGameMode();
        if(mode == Mode.BASIC) this.gameMode = 1;
        else if(mode == Mode.ADVANCED) this.gameMode = 2;
        startGame();
    }
    
    /**
     * This method will start a JavaFX Game and display the available Blocks, the Board, the Pontuation, the Round number and a TextField to the user gives a move to be done
     */
    public void startGame() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(30));
        
        Label boardlabel = new Label("Tabuleiro do Jogo");
        boardlabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 30));
        GridPane boardPane = game.getBoard().getBoardGridPane();
        Label pointsLabel = new Label("Pontuação: " + game.getPlayer().getPontuation().toString());
        pointsLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 25));
        Label roundLabel = new Label("Rodada: " + game.getRound().toString());
        roundLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        Label lettersLabel = new Label("A       B       C       D       E       F       G       H       I");
        lettersLabel.setTranslateY(10);
        lettersLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        
        VBox vbox0 = new VBox(14);
        vbox0.setAlignment(Pos.CENTER_LEFT);
        for(int i=1 ; i<=9 ; i++) {
            Label numberLabel = new Label("" + i);
            numberLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
            vbox0.getChildren().add(numberLabel);
        }
        vbox0.setTranslateY(7);
        vbox0.setTranslateX(-5);
        
        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(10);
        vbox1.getChildren().addAll(boardlabel, lettersLabel, boardPane, pointsLabel, roundLabel);
        
        HBox hboxAll = new HBox();
        hboxAll.setAlignment(Pos.CENTER);
        hboxAll.getChildren().addAll(vbox0, vbox1);
        
        Label label3 = new Label("Blocos Disponíveis");
        label3.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        Label label4 = new Label("Bloco A");
        label4.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        gpA = game.getRound().getBlockA().getBlockGridPane();
        Label label5 = new Label("Bloco B");
        label5.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        gpB = game.getRound().getBlockB().getBlockGridPane();
        Label label6 = new Label("Bloco C");
        label6.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 20));
        gpC = game.getRound().getBlockC().getBlockGridPane();
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(5);
        
        vbox2.getChildren().addAll(label3, label4, gpA, label5, gpB, label6, gpC);
        
        Label nameLabel = new Label("Jogada:");
        nameLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        txtField = new TextField();
        txtField.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 14));
        txtField.setMinHeight(10);
        txtField.setPromptText("Bloco-Coluna/Linha");
        txtField.setPrefColumnCount(10);
        
        Button ok = new Button("Ok");
        Button clear = new Button("Limpar");
        HBox hbox1 = new HBox(5);
        VBox vbox3 = new VBox(8);
        
        ok.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 14));
        ok.setMinWidth(70);
        ok.setOnAction(e -> {
            game.checkRound();
            validateMove();
            play();
            pointsLabel.setText("Pontuação: " + game.getPlayer().getPontuation().toString());
            if (game.getRound().getBlockA() == null) {
                vbox2.getChildren().remove(label4);
                vbox2.getChildren().remove(gpA);
            }
            if (game.getRound().getBlockB() == null) {
                vbox2.getChildren().remove(label5);
                vbox2.getChildren().remove(gpB);
            }
            if (game.getRound().getBlockC() == null) {
                vbox2.getChildren().remove(label6);
                vbox2.getChildren().remove(gpC);
            }
            if (game.checkRound()) {
                gpA = game.getRound().getBlockA().getBlockGridPane();
                gpB = game.getRound().getBlockB().getBlockGridPane();
                gpC = game.getRound().getBlockC().getBlockGridPane();
                vbox2.getChildren().addAll(label4, gpA, label5, gpB, label6, gpC);
            }
            if (game.isGameOver()) {
                Label loseLabel = new Label("GAME OVER");
                loseLabel.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 29));

                ImageView imageGameOver = new ImageView(new Image("file:resources/images/GameOver.png", 145, 145, false, false));

                hbox1.getChildren().remove(ok);
                hbox1.getChildren().remove(clear);
                vbox3.getChildren().addAll(imageGameOver);
                vbox3.getChildren().remove(nameLabel);
                vbox3.getChildren().remove(txtField);
                showGameOver();
                game.endTime();
                game.getLeaderBoard().addPlayer(game.getPlayer());
                game.getPersonalBoard().addPlayer(game.getPlayer());
                game.setLeaderBoard(FileManagement.loadLeaderBoard());
                game.setPersonalBoard(FileManagement.loadPersonalBoard());
                game.finishGame();
            }
            roundLabel.setText("Rodada: " + game.getRound().toString());
            clearMove();
        });
        clear.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 14));
        clear.setMinWidth(70);
        clear.setOnAction(e -> {
                clearMove();
        });
        
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(ok, clear);
        
        vbox3.setAlignment(Pos.CENTER_RIGHT);
        vbox3.getChildren().addAll(nameLabel, txtField, hbox1);
        
        this.getChildren().addAll(vbox2, hboxAll, vbox3);
    }
    
    /**
     * This method will check if the mode given by the user is valid or invalid
     * @return true - if the move is valid; false - if the move is invalid
     */
    private boolean validateMove() {
        String move = txtField.getText().toUpperCase().trim();
        if(move.length() == 0 || move == null)
            return false;
        System.out.println("Move: " + move);
        if((move.charAt(0) == 'A' && game.getRound().getBlockA() == null) || (move.charAt(0) == 'B' && game.getRound().getBlockB() == null) || (move.charAt(0) == 'C' && game.getRound().getBlockC() == null))
            return false;
        if((move.charAt(0) != 'A' && move.charAt(0) != 'B' && move.charAt(0) != 'C') || move == null)
            return false;
        if(move.charAt(2) < 'A' || move.charAt(2) > 'I' || move.charAt(3) < '1' || move.charAt(3) > '9')
            return false;
        return true;
    }
    
    /**
     * This method will clear the TextField of the move
     */
    private void clearMove() {
        txtField.setText("");
        txtField.setPromptText("Bloco-Coluna/Linha");
    }
    
    /**
     * This method will display an error alert if the move given by the user is invalid
     */
    private void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Jogada Inválida");
        alert.setHeaderText("Erro - Jogada Inválida");
        String s = "Erro!!! A jogada deve ser válida! "
                + "\nIntroduz uma jogada do tipo bloco-coluna/linha.";
        alert.setContentText(s);
        alert.showAndWait();
    }
    
    /**
     * This method will display an information alert if the game is over
     */
    private void showGameOver() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Perdeste!");
        String s = "Não é possível efetuar mais jogadas.\n\n"
                 + "Pontuação final: " + game.getPlayer().getPontuation().toString();
        alert.setContentText(s);
        alert.showAndWait();
    }
    
    /**
     * This method will add the Block to a position all choosen by the user to the Board and clear this
     */
    private void play() {
        System.out.println(game.getBoard());
        System.out.println(game.getRound().availableBlocks());
        String str = "";
        if(txtField.getText().isEmpty() || txtField.getText().length() != 4)
            showError();
        else {
            str = "" + txtField.getText().charAt(2) + txtField.getText().charAt(3);
            System.out.println("\nBloco " + txtField.getText().toUpperCase().charAt(0) + " selecionado");
            System.out.println("Na posição " + str + " coluna/linha\n");
            if (!game.addBlock(txtField.getText().toUpperCase().charAt(0), str)) {
                System.out.println("\nInstrução inválida!\n");
                showError();
            } else {
            game.clearBoard();
            }
        }
        if(game.isGameOver())
            System.out.println("GAME OVER");
        System.out.println(game.getBoard());
        System.out.println(game.getRound().availableBlocks()); 
    }
    
    /**
     * This method will return the current Game
     * @return Game - actual Game
     */
    public Game getGame() { return this.game; }
    
    /**
     * This method will return the current gameMode in a int
     * @return 1 - if the gameMode is Basic; 2 - if the gameMode is Advanced
     */
    public int getGameModeNumber() { return this.gameMode; }
}

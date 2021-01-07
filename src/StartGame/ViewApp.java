package StartGame;

import Blockudoku.Block;
import Blockudoku.BlockI;
import Blockudoku.BlockI2;
import Blockudoku.BlockLmin;
import Blockudoku.Board;
import Blockudoku.Randomizer;
import Classes.AboutGame;
import Classes.CommandsGame;
import Classes.CloseGame;
import Classes.GameFX;
import Classes.LoadGame;
import Classes.ModeSelector;
import Classes.NameChooser;
import Classes.RankingList;
import Classes.SaveGame;
import Classes.TopList;
import Classes.WelcomeLabel;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class ViewApp extends BorderPane {
    private boolean firstRun;
    private static Stage stg;
    private static NameChooser namechooser;
    private static WelcomeLabel wl;
    private static ModeSelector modeSelector;
    private static SaveGame saveGame;
    private static LoadGame loadGame;
    private static GameFX gameFxHelp;
    
    /**
     * This constructor will display all the menus and it will be called when the user wants to return to the main menu
     */
    public ViewApp() {
        firstRun = false;
        this.stg = getStage();
        this.wl = new WelcomeLabel(namechooser.getPlayerName());
        gameFxHelp = new GameFX();
        showWelcomeLabel();
        createHomeMenu();
    }
    
    /**
     * This constructor will display all the menus and the area to the user gives his name
     * @param stage - Stage that will be modified to display on the center other Nodes
     */
    public ViewApp(Stage stage) {
        firstRun = true;
        this.stg = stage;
        this.namechooser = new NameChooser();
        this.wl = new WelcomeLabel(namechooser.getPlayerName());
        gameFxHelp = new GameFX();
        showNameChooser();
        createHomeMenu();
    }
    
    /**
     * This method will create the MenuBar, Menus and MenuItems, display them and also contains the actions for all the MenuItems
     */
    private void createHomeMenu() {
        MenuBar bar = new MenuBar();
        
        Menu home = new Menu("Jogo");
        MenuItem game = new MenuItem("Novo Jogo");
        MenuItem cancel = new MenuItem("Cancelar o Jogo");
        MenuItem load = new MenuItem("Abrir um Jogo");
        MenuItem save = new MenuItem("Guardar o Jogo");
        MenuItem exit = new MenuItem("Saír");
        
        Menu see = new Menu("Ver");
        MenuItem personalBoard = new MenuItem("Pontuações Pessoais");
        MenuItem leaderBoard = new MenuItem("Top 10 Pontuações");
        
        Menu window = new Menu("Janela");
        MenuItem fullscreen = new MenuItem("Abrir Tela Cheia");
        MenuItem normalscreen = new MenuItem("Fechar Tela Cheia");
        
        Menu help = new Menu("Ajuda");
        MenuItem commands = new MenuItem("Comandos");
        MenuItem about = new MenuItem("Sobre o Jogo");
        
        if(firstRun){ 
            game.setDisable(true);
            cancel.setDisable(true);
            save.setDisable(true);
            personalBoard.setDisable(true);
        } else {
            game.setDisable(false);
            cancel.setDisable(false);
            save.setDisable(false);
            personalBoard.setDisable(false);
        }
        
        game.setOnAction(e -> {
            this.modeSelector = new ModeSelector(namechooser.getPlayerName());
            showModeSelector();
        }); 
        
        cancel.setOnAction(e -> {
            this.wl = new WelcomeLabel(namechooser.getPlayerName());
            showWelcomeLabel();
        });
        
        load.setOnAction(e -> {
//            loadGame = new LoadGame();
//            Stage loadWindow = new Stage();
//            loadWindow.setTitle("Blockudoku: Abrir um jogo");
//            loadWindow.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
//            loadWindow.setScene(new Scene(loadGame, 800, 500));
//            loadWindow.centerOnScreen();
//            loadWindow.show();
//            gameFxHelp = loadGame.getGameFx();
//            showGameFX();
            
        });

        save.setOnAction(e -> {
            Stage saveWindow = new Stage();
            saveWindow.setTitle("Blockudoku: Guardar o jogo");
            saveWindow.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
            saveWindow.setScene(new Scene(new SaveGame(modeSelector), 800, 500));
            saveWindow.centerOnScreen();
            saveWindow.show();
        });
        
        personalBoard.setOnAction(e -> {
            Stage personalWindow = new Stage();
            personalWindow.setTitle("Blockudoku: PersonalBoard");
            personalWindow.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
            if(modeSelector != null && modeSelector.getGameFX() != null && modeSelector.getGameFX().getGame() != null)
                personalWindow.setScene(new Scene(new RankingList(modeSelector.getGameFX().getGame().getPersonalBoard(), namechooser.getPlayerName()), 800, 500));
            else
                personalWindow.setScene(new Scene(new RankingList(gameFxHelp.getGame().getPersonalBoard(), namechooser.getPlayerName()), 800, 500));
            personalWindow.centerOnScreen();
            personalWindow.show();
        });
        
        leaderBoard.setOnAction(e -> {
            Stage leaderWindow = new Stage();
            leaderWindow.setTitle("Blockudoku: LeaderBoard");
            leaderWindow.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
            if(modeSelector != null && modeSelector.getGameFX() != null && modeSelector.getGameFX().getGame() != null)
                leaderWindow.setScene(new Scene(new TopList(modeSelector.getGameFX().getGame().getLeaderBoard()), 800, 500));
            else
                leaderWindow.setScene(new Scene(new TopList(gameFxHelp.getGame().getLeaderBoard()), 800, 500));
            leaderWindow.centerOnScreen();
            leaderWindow.show();
        });
        
        fullscreen.setOnAction(e -> {
            stg.setFullScreen(true);
        }); 
        
        normalscreen.setOnAction(e -> {
            stg.setFullScreen(false);
        });
        
        about.setOnAction(e -> {
            Stage aboutWindow = new Stage();
            aboutWindow.setTitle("Blockudoku: Sobre o Jogo");
            aboutWindow.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
            aboutWindow.setScene(new Scene(new AboutGame(), 800, 500));
            aboutWindow.centerOnScreen();
            aboutWindow.show();
        });
        
        commands.setOnAction(e -> {
            Stage commandsWindow = new Stage();
            commandsWindow.setTitle("Blockudoku: Comandos");
            commandsWindow.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
            commandsWindow.setScene(new Scene(new CommandsGame(), 800, 500));
            commandsWindow.centerOnScreen();
            commandsWindow.show();
        }); 
        
        exit.setOnAction(e -> {
            Stage exitWindow = new Stage();
            exitWindow.setTitle("Blockudoku: Saír do Jogo");
            exitWindow.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
            exitWindow.setScene(new Scene(new CloseGame(), 800, 500));
            exitWindow.centerOnScreen();
            exitWindow.show();
        });
        
        home.getItems().addAll(game, cancel, new SeparatorMenuItem(), load, save, new SeparatorMenuItem(), exit);
        see.getItems().addAll(personalBoard, leaderBoard);
        window.getItems().addAll(fullscreen, normalscreen);
        help.getItems().addAll(commands, about);
        bar.getMenus().addAll(home, see, window, help);
        
        this.setTop(bar);
    }
    
    /**
     * This method will display on the center of this Stage the area to the user enter his name
     */
    public final void showNameChooser() { this.setCenter(namechooser); }
    
    /**
     * This method will display on the center of this Stage the area to the user selects the mode he wants to play
     */
    public final void showModeSelector() { this.setCenter(modeSelector); }
    
    /**
     * This method will display on the center of this Stage the main menu
     */
    public final void showWelcomeLabel() { this.setCenter(wl); }
    
    /**
     * This method will display on the center of this Stage the GameFX
     */
    public final void showGameFX() { this.setCenter(gameFxHelp); }
    
    /**
     * This method will return the current Stage
     * @return Stage - actual Stage
     */
    public final Stage getStage() { return this.stg; }
    
    /**
     * This method will return the WelcomeLabel object
     * @return WelcomeLabel - WelcomeLabel object
     */
    public final WelcomeLabel getWelcomeLabel() { return this.wl; }
    
    /**
     * This method will return the ModeSelector object
     * @return ModeSelector - ModeSelector object
     */
    public final ModeSelector getModeSelector() { return this.modeSelector; }
    
    /**
     * This method will return the NameChooser object
     * @return NameChooser - NameChooser object
     */
    public final NameChooser getNameChooser() { return this.namechooser; }
}

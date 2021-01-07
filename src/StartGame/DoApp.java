package StartGame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class DoApp extends Application {
    
    /**
     * This method will open the Game on a new Stage
     * @param primaryStage - Stage
     */
    @Override
    public void start(Stage primaryStage) {
        ViewApp viewApp = new ViewApp(primaryStage);
        
        Scene scene = new Scene(viewApp, 1000, 700);
        
        primaryStage.getIcons().add(new Image("file:resources/icon/Blockudoku.png"));
        primaryStage.setTitle("Blockudoku");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

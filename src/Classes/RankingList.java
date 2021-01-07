package Classes;

import Blockudoku.Game;
import Blockudoku.PersonalBoard;
import Blockudoku.Player;
import StartGame.ViewApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class RankingList extends VBox  {
    private ObservableList<Player> obsList;

    /**
     * This constructor will display the Scores on Ranking
     * @param pb - PersonalBoard
     * @param name - String with the name of the player
     */
    public RankingList(PersonalBoard pb, String name) {
        obsList = FXCollections.observableArrayList(pb.getPersonalBoardListByName(name));
        ListView<Player> listView = new ListView<>();
        listView.setItems(obsList);

        listView.setCellFactory((ListView<Player> listview) -> {
            ListCell<Player> cell = new ListCell<Player>() {
                @Override
                public void updateItem(Player p, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                    }
                    if (p != null) {
                        setGraphic(drawCell(p));
                    }
                }
            };
            return cell;
        });
        
        Label info = new Label("PersonalBoard (Ranking Pessoal)");
        info.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 30));
        
        Button clear = new Button("Limpar");
        clear.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        clear.setMinWidth(40);
        clear.setFocusTraversable(true);
        clear.setOnAction(e -> {
                pb.removeByName(name);
                obsList.clear();
        });
        
        Button back = new Button("Voltar");
        back.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        back.setMinWidth(40);
        back.setFocusTraversable(true);
        back.setOnAction(e -> 
                ((Stage) back.getScene().getWindow()).close());
        
        HBox hbox = new HBox(60);
        hbox.getChildren().addAll(info, clear, back);
        
        setSpacing(20);
        setPadding(new Insets(30));
        this.getChildren().addAll(hbox, listView);
    }
    
    /**
     * This method will draw a cell to be inserted on the ListView
     * @param p - Player on the Ranking
     * @return Node - formatted Label
     */
    private Node drawCell(Player p) {
        Label name = new Label("Nome: " + p.getName() + "\nPontuação: " + p.getPontuation().toString());
        name.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 14));

        return name;
    }
}

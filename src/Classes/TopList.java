package Classes;

import Blockudoku.Game;
import Blockudoku.LeaderBoard;
import Blockudoku.Player;
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
public class TopList extends VBox  {
    private final ObservableList<Player> obsList;
    private final ListView<Player> listView;

    /**
     * This constructor will display the Scores on Top 10
     * @param lb - LeaderBoard
     */
    public TopList(LeaderBoard lb) {
        obsList = FXCollections.observableArrayList(lb.getLeaderBoardList());
        listView = new ListView<>();
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
        
        Label info = new Label("LeaderBoard (Top 10 Pontuações)");
        info.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 30));
        
        Button back = new Button("Voltar");
        back.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 18));
        back.setMinWidth(40);
        back.setFocusTraversable(true);
        back.setOnAction(e -> 
                ((Stage) back.getScene().getWindow()).close());
        
        HBox hbox = new HBox(160);
        hbox.getChildren().addAll(info, back);
        
        setSpacing(20);
        setPadding(new Insets(30));
        this.getChildren().addAll(hbox, listView);
    }

    /**
     * This method will draw a cell to be inserted on the ListView
     * @param p - Player on the Top 10
     * @return Node - formatted Label
     */
    private Node drawCell(Player p) {
        Label name = new Label("Nome: " + p.getName() + "\nPontuação: " + p.getPontuation().toString());
        name.setFont(Font.loadFont("file:resources/fonts/DidactGothic.ttf", 14));

        return name;
    }
}

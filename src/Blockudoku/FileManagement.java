package Blockudoku;


import Classes.GameFX;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public abstract class FileManagement implements java.io.Serializable {
    
    /**
     * This method will save a game
     * @param fileName - String with the name given by the user to the file
     * @param game - actual Game
     */
    public static void saveGame(String fileName, Game game) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(game);
            oos.flush();
            oos.close();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * This method will load a certain game that the user will choose by entering a filename
     * @param fileName - String of the filename that the user will load the game
     * @return Game - Game that will be loaded and played by the user
     */
    public static Game loadGame(String fileName) {
        Game game = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            game = (Game) ois.readObject();
            ois.close();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException c) {
            System.out.println(c.getMessage());
            game = new Game();
        }
        return game;
    }
    
    /**
     * This method will save a LeaderBoard
     * @param lb - LeaderBoard that will be saved everytime to be updated
     */
    public static void saveLeaderBoard(LeaderBoard lb) {
        String filename = "leaderboard.bin";
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(lb);
            oos.flush();
            oos.close();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * This method will load the LeaderBoard or create a new one if is the first time of the user
     * @return LeaderBoard - Leaderboard loaded
     */
    public static LeaderBoard loadLeaderBoard() {
        String filename = "leaderboard.bin";
        LeaderBoard lb = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            lb = (LeaderBoard) ois.readObject();
            ois.close();
        }catch(IOException e) {
            lb = new LeaderBoard();
            saveLeaderBoard(lb);
        }catch(ClassNotFoundException c) {
            System.out.println(c.getMessage());
            lb = new LeaderBoard();
        }
        return lb;
    }
    
    /**
     * This method will save a PersonalBoard
     * @param pb - PersonalBoard that will be saved everytime to be updated
     */
    public static void savePersonalBoard(PersonalBoard pb) {
        String filename = "personalboard.bin";
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(pb);
            oos.flush();
            oos.close();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * This method will load the PersonalBoard or create a new one if is the first time of the user
     * @return PersonalBoard - PersonalBoard loaded
     */
    public static PersonalBoard loadPersonalBoard() {
        String filename = "personalboard.bin";
        PersonalBoard pb = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            pb = (PersonalBoard) ois.readObject();
            ois.close();
        }catch(IOException e) {
            pb = new PersonalBoard();
            savePersonalBoard(pb);
        }catch(ClassNotFoundException c) {
            System.out.println(c.getMessage());
            pb = new PersonalBoard();
        }
        return pb;
    }
    
    /**
     * This method will send to a .txt file all the information of the game to be saved
     * UNFINISHED
     * @param fileName - String with the name given by the user to the file
     * @param gameFx - actual GameFX
     */
    public static void saveGameFxInfo(String fileName, GameFX gameFx) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName + ".txt"));
            
            bw.write(gameFx.getGame().getPlayer().getName() + "\n");
            bw.write(gameFx.getGame().getPlayer().getPontuation().toString() + "\n");
            bw.write(gameFx.getGame().getRound().toString() + "\n");
            bw.write(gameFx.getGameModeNumber() + "\n");
            
            GridPane gp = gameFx.getGame().getBoard().getBoardGridPane();
            Rectangle r;
            Color color = null;
            for(int c=0 ; c<9 ; c++) {
                for(int l=0 ; l<9 ; l++) {
                    for(Node node : gp.getChildren()) {
                        if (gp.getColumnIndex(node) == c && gp.getRowIndex(node) == l) {
                            r = (Rectangle) node;
                            color = (Color) r.getFill();
                            System.out.println(r.getFill().toString() + "column:" + c + " line:" + l + "\n");
                            if(color.equals(Color.SILVER)) bw.write("SILVER\n");
                            else if(color.equals(Color.BLUE)) bw.write("BLUE\n");
                            else if(color.equals(Color.FUCHSIA)) bw.write("FUCHSIA\n");
                            else if(color.equals(Color.LIME)) bw.write("LIME\n");
                            else if(color.equals(Color.ORANGE)) bw.write("ORANGE\n");
                            else if(color.equals(Color.YELLOW)) bw.write("YELLOW\n");
                            else if(color.equals(Color.RED)) bw.write("RED\n");
                            else if(color.equals(Color.TURQUOISE)) bw.write("TURQUOISE\n");
                        }
                    }
                }
            }
            
            System.out.println("Successful");
            bw.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * This method will load a Game
     * UNFINISHED
     * @param fileName - String with file name
     * @return Game - Game loaded
     */
    public static Game loadGameFx(String fileName) {
        BufferedReader br = null;
        Game game = new Game();
        int i=1, line=0, column=0;
        String str;
        try {
            File file = new File(fileName + ".txt"); 
            br = new BufferedReader(new FileReader(file));
            while ((str = br.readLine()) != null) {
                if(i==1) game.createPlayer(str);
                else if(i==2) game.getPlayer().getPontuation().setPoints(Integer.parseInt(str));
                else if(i==3) game.getRound().setRoundNumber(Integer.parseInt(str));
                else if(i==4) game.setGameMode(Integer.parseInt(str));
                else if(i>=5 && i<=85) {
                    if(str.equals("SILVER")) {  }
                    else if(str.equals("BLUE")) {
                        game.getBoard().fillAtPosition(line, column);
                        game.getBoard().changeRectangleColor(column, line, Color.BLUE);
                    }
                    else if(str.equals("FUCHSIA")) {
                        game.getBoard().fillAtPosition(line, column);
                        game.getBoard().changeRectangleColor(column, line, Color.FUCHSIA);
                    }
                    else if(str.equals("LIME")) {
                        game.getBoard().fillAtPosition(line, column);
                        game.getBoard().changeRectangleColor(column, line, Color.LIME);
                    }
                    else if(str.equals("ORANGE")) {
                        game.getBoard().fillAtPosition(line, column);
                        game.getBoard().changeRectangleColor(column, line, Color.ORANGE);
                    }
                    else if(str.equals("YELLOW")) {
                        game.getBoard().fillAtPosition(line, column);
                        game.getBoard().changeRectangleColor(column, line, Color.YELLOW);
                    }
                    else if(str.equals("RED")) {
                        game.getBoard().fillAtPosition(line, column);
                        game.getBoard().changeRectangleColor(column, line, Color.RED);
                    }
                    else if(str.equals("TURQUOISE")) {
                        game.getBoard().fillAtPosition(line, column);
                        game.getBoard().changeRectangleColor(column, line, Color.TURQUOISE);
                    }
                    column++;
                    if(column==9) {
                        line++;
                        column=0;
                    }
                }
                i++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return game;
    }
}

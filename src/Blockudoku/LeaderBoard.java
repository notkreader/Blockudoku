package Blockudoku;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class LeaderBoard implements java.io.Serializable {
    private List<Player> leaderboard;
    
    /**
     * This constructor will create an ArrayList that is the LeaderBoard
     */
    public LeaderBoard() {
        leaderboard = new ArrayList<>();
    }
    
    /**
     * This method will sort the list in descending order of pontuation 
     */
    private void sortList() {
        Collections.sort(leaderboard, new SortBoardByPontuation());
    }
    
    /**
     * This method will add a Player to the list, will sort the list and if the list size in bigger than 10 it will remove the last game
     * @param p - Player to be added to the list 
     */
    public void addPlayer(Player p) {
        leaderboard.add(p);
        sortList();
        if(leaderboard.size()>10)
            leaderboard.remove(leaderboard.get(10));
        FileManagement.saveLeaderBoard(this);
    }
    
    /**
     * This method will return a formatted String of the LeaderBoard
     * @return String - formatted LeaderBoard
     */
    @Override
    public String toString() {
        int i=1;
        String str = "\n************************* LEADERBOARD *************************\n";
        if(leaderboard.isEmpty()) {
            str += "Não há registos de pontuações";
            return str.toString();
        }
        for(Player p : leaderboard) {
            str += i + " - " + p.getName() + " | " + p.getPontuation().getTotalPoints() + "\n";
            i++;
        }
        return str.toString();
    }
    
    /**
     * This method will return a List of the best Player's Scores
     * @return List - List of Players
     */
    public List<Player> getLeaderBoardList() { return this.leaderboard; }
}

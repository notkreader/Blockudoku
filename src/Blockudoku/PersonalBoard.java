package Blockudoku;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class PersonalBoard implements java.io.Serializable {
    private List<Player> personalboard;
    
    /**
     * This constructor will create an ArrayList that is the PersonalBoard
     */
    public PersonalBoard() {
        personalboard = new ArrayList<>();
    }
    
    /**
     * This method will sort the list in descending order of pontuation 
     */
    private void sortList() {
        Collections.sort(personalboard, new SortBoardByPontuation());
    }
    
    /**
     * This method will add a Player to the list and will sort the list
     * @param p - Player to be added to the list 
     */
    public void addPlayer(Player p) {
        personalboard.add(p);
        sortList();
        FileManagement.savePersonalBoard(this);
    }
    
    /**
     * This method will show all the scores of the Player with the name given
     * @param name - name of the Player
     * @return String - formatted String of the PersonalBoard (Ranking)
     */
    public String showPersonalBoard(String name) {
        int i=0;
        String str = "\n************************ PERSONALBOARD *************************\n";
        if(personalboard.isEmpty()) {
            str += "\nNão há registos de pontuações!";
            return str.toString();
        }
        for(Player p : personalboard) {
            if(p.getName().equalsIgnoreCase(name)) {
                i++;
                str += i + " - " + p.getName() + " | " + p.getPontuation().getTotalPoints() + "\n";
            }
        }
        if(i==0)
            str += "\nAinda não jogaste!";
        return str.toString();
    }
    
    /**
     * This method will return a List of the Players
     * @return List - List of Players
     */
    public List<Player> getPersonalBoardList() { return this.personalboard; }
    
    /**
     * This method will return a List of the Players by the name given
     * @param name - String with the name of a player
     * @return List - List of Personal Scores
     */
    public List<Player> getPersonalBoardListByName(String name) {
        List<Player> newList = new ArrayList<>();
        for(Player p : personalboard) {
            if(p.getName().equalsIgnoreCase(name))
                newList.add(p);
        }
        return newList;
    }
    
    /**
     * This method will remove all the Players that are on the List with the name given
     * @param name - String with the name of the Player to remove
     */
    public void removeByName(String name) {
        for(Player p : personalboard) {
            if(p.getName().equalsIgnoreCase(name))
                personalboard.remove(p);
        }
    }
}

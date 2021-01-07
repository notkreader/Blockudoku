package Blockudoku;


import java.io.Serializable;
import java.util.Comparator;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class SortBoardByPontuation implements Comparator<Player>, Serializable {
    
    /**
     * This method will sort by descending order
     * @param p1 - Player 1
     * @param p2 - Player 2
     * @return int
     */
    @Override
    public int compare(Player p1, Player p2) { 
        return p2.getPontuation().getTotalPoints() - p1.getPontuation().getTotalPoints();
    } 
}

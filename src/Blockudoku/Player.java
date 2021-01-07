package Blockudoku;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */

public class Player implements java.io.Serializable {
    private String name;
    private Pontuation pontuation;

    /**
     * This constructor will create a Player
     * @param name - String with the Player name given by the user
     */
    public Player(String name) {
        if (name.isEmpty())
            name = "Default Player";
        this.name = name;
        pontuation = new Pontuation();
    }

    /**
     * This method will return the Player name
     * @return String - name of the Player
     */
    public String getName() { return this.name; }
    
    /**
     * This methos will change the Player name
     * @param name - String with the new Player name
     */
    public void setName(String name) { this.name = name; }
    
    /**
     * This method will return the Player Pontuation
     * @return Pontuation - Player's Pontuation
     */
    public Pontuation getPontuation() { return this.pontuation; }
}

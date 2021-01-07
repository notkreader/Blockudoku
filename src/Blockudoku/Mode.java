package Blockudoku;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */

public enum Mode implements java.io.Serializable {
    BASIC, ADVANCED;
    
    /**
     * This method will return a String with the Mode choosen
     * @return String - formatted String with the Mode choosen to the Game
     */
    @Override
    public String toString() {
        switch(this) {
            case BASIC : return "\nPrepara-te para jogares o modo básico\n";
            case ADVANCED : return "\nPrepara-te para jogares o modo avançado\n";
            default : return "";
        }
    }
}

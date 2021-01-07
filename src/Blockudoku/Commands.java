package Blockudoku;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public abstract class Commands implements java.io.Serializable {

    /**
     * This method will return the number of the command given by the user
     * @param command - String with the command wrote bu the user
     * @return 1 - if the command is "SAVE" ; 2 - if the command if "CANCEL" ; 3 - if the command is "block-columnline" ; -1 - if the command is invalid
     */
    public static int whichCommand(String command) {
        if(command.trim().toUpperCase().equals("SAVE"))
            return 1;
        if(command.trim().toUpperCase().equals("CANCEL"))
            return 2;
        String strTemp = command.trim().toUpperCase();
        if(strTemp.trim().length() != 4)
            return -1;
        char c1 = strTemp.charAt(0);
        char c2 = strTemp.charAt(1);
        char c3 = strTemp.charAt(2);
        char c4 = strTemp.charAt(3);
        int n4 = Character.getNumericValue(c4);
        if((c1>='A' && c1<='C') && (c2=='-') && (c3>= 'A' && c3<= 'I') && (n4>=1 && n4<=9))
            return 3;
        return -1;
    }
}

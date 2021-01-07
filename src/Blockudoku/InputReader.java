package Blockudoku;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */

import java.util.Scanner;

public class InputReader implements java.io.Serializable {
    private Scanner reader;

    /**
     * This constructor will create an InputReader
     */
    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * This method will get a char entered by the user
     * @return answer - char at position zero read
     */
    public char getFirstChar() {
        System.out.print(">");
        char answer = reader.next().charAt(0);
        reader.nextLine();
        return answer;
    }
    
    /**
     * This method will get an int entered by the user
     * @return answer - int read
     */
    public int getInt() {
        System.out.println(">");
        int answer = reader.nextInt();
        reader.nextLine();
        return answer;
    }
    
    /**
     * This method will get a String entered by the user
     * @return answer - String read
     */
    public String getString() {
        System.out.println(">");
        String answer = reader.nextLine();
        return answer;
    }
}

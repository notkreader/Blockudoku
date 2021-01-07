package Blockudoku;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class Game implements java.io.Serializable {
    private Mode mode;
    private boolean finished;
    private Player player;
    private Board board;
    private Round round;
    private boolean previousGame;
    private String startTime;
    private String endTime;
    private LeaderBoard leaderBoard;
    private PersonalBoard personalBoard;
    
    /**
     * This constructor will create a Game
     */
    public Game() {
        mode = null;
        finished = false;
        board = new Board();
        previousGame = false;
        leaderBoard = FileManagement.loadLeaderBoard();
        personalBoard = FileManagement.loadPersonalBoard();
    }
    
    /**
     * This method will return the game Mode
     * @return Mode - BASIC or ADVANCED
     */
    public Mode getGameMode() { return this.mode; }
    
    /**
     * This method will check if the game if finished
     * @return true - if the game is finished ; false - if the game isn't finished
     */
    public boolean isFinished() { return this.finished; }
    
    /***
     * This method will return the Player
     * @return Player - Player of the Game
     */
    public Player getPlayer() { return this.player; }
    
    /**
     * This method will call a new Round with the Game Mode
     */
    public void nextRound() { this.round = new Round(this.mode); }
    
    /**
     * This method will return a Round
     * @return Round - actual Round of the Game
     */
    public Round getRound() { return this.round; }
    
    /**
     * This method will return the Board
     * @return Board - the Board of this Game
     */
    public Board getBoard() { return this.board; }
    
    /**
     * This method will check if this game was loaded
     * @return true - if the game was loaded ; false - if the game wasn't loaded 
     */
    public boolean isPreviousGame() { return this.previousGame; }
    
    /**
     * This method will set this attribute to true if the game was loaded at the time the user wants to load a Game
     */
    public void setPreviousGame() { previousGame = true; }
    
    /**
     * This method will finish the game by setting this attribute to true
     */
    public void finishGame() { this.finished = true; }
    
    /**
     * This method will create a new Player with a name given by the user
     * @param name - String that constains the Player name
     */
    public void createPlayer(String name) { this.player = new Player(name); }
    
    /**
     * This method will return the LeaderBoard
     * @return LeaderBoard - LeaderBoard of the Game
     */
    public LeaderBoard getLeaderBoard() { return this.leaderBoard; }
    
    /**
     * This method will return the PersonalBoard (personal ranking) of the Game
     * @return PersonalBoard - PersonalBoard of the Game
     */
    public PersonalBoard getPersonalBoard() { return this.personalBoard; }
    
    /**
     * This method will start the time of this Game
     */
    public void startTime() { this.startTime = getFormattedDate(); }
    
    /**
     * This method will end the time of this Game
     */
    public void endTime() { this.endTime = getFormattedDate(); }
    
    /**
     * This method will return the time when this Game started
     * @return String - time when this Game started on a formatted String
     */
    public String getStartTime() { return this.startTime; }
    
    /**
     * This method will return the time when this Game ended
     * @return String - time when this Game ended on a formatted String
     */
    public String getEndTime() { return this.endTime; }
    
    /**
     * This method will return a String of the actual Game
     * @return String - actual time on a formatted String like "dd/MM/yyyy HH:mm:ss"
     */
    private String getFormattedDate() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return ldt.format(formatter);
    }
    
    /**
     * This method will set the mode to a specific one
     * @param mode - number of the mode (1 to BASIC Mode ; 2 to ADVANCED Mode)
     */
    public void setGameMode(int mode) { 
        if(mode == 1)
            this.mode = Mode.BASIC;
        else if(mode == 2)
            this.mode = Mode.ADVANCED;
    }
    
    /**
     * This method will check if the Round is finish and is needed a new Round
     * @return true - if a new Round will be generated; false - if there is no need to generate a new Round
     */
    public boolean checkRound() {
        if(getRound() == null || (getRound().getBlockA()==null && getRound().getBlockB()==null && getRound().getBlockC()==null)) {
            nextRound();
            return true;
        }
        return false;
    }
    
    /**
     * This method will check if is possible to put all the three Blocks on the Board 
     * @return false - if all Blocks fits on the Board ; true - if at leats one Block doesn't fit on the Board
     */
    public boolean isGameOver() {
        if(getRound().getBlockA() == null && getRound().getBlockB() == null && getRound().getBlockC() == null)
            return false;
        if((getRound().getBlockA() == null || board.checkIfBlockFits(getRound().getBlockA()) == false) &&
           (getRound().getBlockB() == null || board.checkIfBlockFits(getRound().getBlockB()) == false) &&
           (getRound().getBlockC() == null || board.checkIfBlockFits(getRound().getBlockC()) == false))
                return true;
        return false;
    }
        
    /**
     * This method will check if the Block can fit at the position also given by the user
     * @param blockChar - char 'A' to Block A ; char 'B' to Block B ; char 'C' to Block C
     * @param position - String with the coordenates entered by the user
     * @return true - if the Block was added ; false - if the Block wasn't added
     */
    public boolean addBlock(char blockChar, String position) {
        switch(blockChar) {
            case 'A' :  if(board.checkBlockInPosition(round.getBlockA(), position)) {
                            board.putBlock(round.getBlockA(), position);
                            player.getPontuation().incrementPlacementPoints(mode, round.getBlockA());
                            round.clearBlockA();
                            return true;
                        }
                        return false;
            case 'B' :  if(board.checkBlockInPosition(round.getBlockB(), position)) {
                            board.putBlock(round.getBlockB(), position);
                            player.getPontuation().incrementPlacementPoints(mode, round.getBlockB());
                            round.clearBlockB();
                            return true;
                        }
                        return false;
            case 'C' :  if(board.checkBlockInPosition(round.getBlockC(), position)) {
                            board.putBlock(round.getBlockC(), position);
                            player.getPontuation().incrementPlacementPoints(mode, round.getBlockC());
                            round.clearBlockC();
                            return true;
                        }
                        return false;
        }
        return false;
    }
    
    /**
     * This method will clear the Board (checking and clearing lines, columns and big squares)
     */
    public void clearBoard() {
        int nL, nC, nBS;
        do {
            nL = board.fullLine();
            nC = board.fullColumn();
            nBS = board.fullBigSquare();
            if(nL != -1) {
                board.clearLine(nL);
                System.out.println("\nLinha " + nL + " limpa");
                nL = board.fullLine();
                player.getPontuation().incrementCleanSquarePoints();
            }
            if(nC != -1) {
                board.clearColumn(nC);
                System.out.println("\nColuna " + nC + " limpa");
                nC = board.fullColumn();
                player.getPontuation().incrementCleanSquarePoints();
            }
            if(nBS != -1) {
                board.clearBigSquare(nBS);
                System.out.println("\nQuadrado grande " + nBS + " limpo");
                nBS = board.fullBigSquare();
                player.getPontuation().incrementCleanSquarePoints();
                player.getPontuation().incrementBonusPoints();
            }
        }while(nL != -1 || nC != -1 || nBS != -1);
    }
    
    /**
     * This method will update the LeaderBoard
     * @param lb - Updated LeaderBoard 
     */
    public void setLeaderBoard(LeaderBoard lb) { this.leaderBoard = lb; }
    
    /**
     * This method will update the PersonalBoard
     * @param pb - Updated PersonalBoard 
     */
    public void setPersonalBoard(PersonalBoard pb) { this.personalBoard = pb; }
}

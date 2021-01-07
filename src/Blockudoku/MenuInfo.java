package Blockudoku;

/* 
 * NetBeans Project
 * @JoaoCabete
 * @190221046
 */
public class MenuInfo {
    
    /**
     * This method will show the menu one
     * @return String - formatted String with the menu one information
     */
    public static String menuOne() {
        String str = "\nBem-vindo ao jogo Blockudoku"
                   + "\nPrepara-te!";
        return str;
    }
    
    /**
     * This method will show the menu two
     * @return String - formatted String with the menu two information
     */
    public static String menuTwo() {
        String str = "\n1 – Iniciar novo jogo"
                   + "\n2 – Abrir jogo"
                   + "\n3 – PersonalBoard (Pontuações pessoais)"
                   + "\n4 – LeaderBoard (Ranking Top 10)"
                   + "\n5 - Comandos disponíveis"        
                   + "\n0 – Sair";
        return str;
    }
    
    /**
     * This method will show the menu three
     * @return String - formatted String with the menu three information
     */
    public static String menuThree() {
        String str = "\n1 - Iniciar novo jogo – Modo básico"
                   + "\n2 – Iniciar novo jogo – Modo avançado";
        return str;
    }
    
    /**
     * This method will show the menu four
     * @return String - formatted String with the menu four information
     */
    public static String menuFour() {
        String str = "\nEstão disponiveis os seguintes comandos"
                   + "\nSAVE   - Guarda o jogo (apenas disponível quando um jogo está em execução)"
                   + "\nCANCEL - Cancela o jogo em execução (apenas disponível quando um jogo está"
                   + "\nem execução)";
        return str;
    }
    
    /**
     * This method will show the menu five
     * @return String - formatted String with the menu five information
     */
    public static String menuFive() {
        String str = "\nBlockudoku consite numa mistura de Sudoku com um jogo de blocos em que o principal"
                   + "\nobjetivo do jogo passa por efetuar o preenchimento de linhas, colunas ou quadrados"
                   + "\nmantendo o tabuleiro com o mínimo de blocos possíveis e acumulando o maior número"
                   + "\npossível de pontos"
                   + "\nO jogo acaba quando um ou mais blocos fornecidos ao jogador não conseguirem entrar "
                   + "\nno tabuleiro do jogo";
        return str;
    }
    
    /**
     * This method will show the menu six
     * @return String - formatted String with the menu six information
     */
    public static String menuSix() {
        String str = "\nEstão disponiveis os seguintes comandos"
                   + "\nNOVO JOGO                        - Começa um novo jogo"
                   + "\nCANCELAR UM JOGO        - Cancela o jogo em execução"
                   + "\nABRIR UM JOGO                 - Abre um jogo guardado anteriormente pelo jogador"
                   + "\nGUARDAR O JOGO             - Guarda o jogo em execução"
                   + "\nSAÍR                                       - O jogo é fechado"
                   + "\nPONTUAÇÕES PESSOAIS  - Mostra uma lista das pontuações do jogador"
                   + "\nTOP 10 PONTUAÇÕES       - Mostra o Top 10 de melhores pontuações"
                   + "\nABRIR TELA CHEIA              - Abre o jogo em modo fullscreen"
                   + "\nFECHAR TELA CHEIA           - Sai do modo fullscreen";
        return str;
    }
}

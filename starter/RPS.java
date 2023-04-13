/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import java.util.Scanner;

/**
 * TODO: Add your class header (purpose and capabilities of the class)
 */
public class RPS extends RPSAbstract {
    
    /**
     * TODO: Add method header
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    /**
     * Takes the user move, the CPU move, and determines who wins.
     * @param playerMove - move of the player
     * @param cpuMove - move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */
    public int determineWinner(String playerMove, String cpuMove)
    {
        // TODO
        boolean found1 = false;
        boolean found2 = false;
        for(int i = 0; i < possibleMoves.length; i++){
            if(possibleMoves[i].equals(playerMove)){
                found1 = true;
            }
            if(possibleMoves[i].equals(cpuMove)){
                found2 = true;
            }
        }
        if(found1==false){
            return INVALID_INPUT_OUTCOME;
        }
        if(found2==false){
            return INVALID_INPUT_OUTCOME;
        }
        for(int i = 0; i < possibleMoves.length; i++){
            if(possibleMoves[i].equals(playerMove)){
                if(i == possibleMoves.length - 1){
                    if(cpuMove.equals(possibleMoves[0])){
                        return PLAYER_WIN_OUTCOME;
                    }
                }
                else if(cpuMove.equals(possibleMoves[i+1])){
                    return PLAYER_WIN_OUTCOME;
                }

                if(i == 0){
                    if(cpuMove.equals(possibleMoves[possibleMoves.length -1])){
                        return CPU_WIN_OUTCOME;
                    }
                }
                else if(cpuMove.equals(possibleMoves[i-1])){
                    return CPU_WIN_OUTCOME;
                }
            }
        }            
        return TIE_OUTCOME;
    } 

    /**
     * Main method that reads user input, generates cpu move, and plays game
     * 
     * @param args - arguments passed in from command line in String form
     */
    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);
        System.out.println("Let's play! What's your move? (Type the move or q to quit)");
        String input = in.nextLine();
        while(true){
            if(input.equals("q")){
                game.end();
                break;
            }
            String cpuMove = game.genCPUMove();
            game.play(input, cpuMove);
            if((game.determineWinner(input, cpuMove) == (INVALID_INPUT_OUTCOME))){
                System.out.println(INVALID_INPUT);
                System.out.println("Let's play! What's your move? (Type the move or q to quit)");
                input = in.nextLine();
                continue;
            }
            System.out.print(String.format(CPU_MOVE, cpuMove));
            if(game.determineWinner(input, cpuMove) == (PLAYER_WIN_OUTCOME)){
                System.out.println(PLAYER_WIN);
            }
            else if(game.determineWinner(input, cpuMove) == (CPU_WIN_OUTCOME)){
                System.out.println(CPU_WIN);
            }
            else if(game.determineWinner(input, cpuMove) == (TIE_OUTCOME)){
                System.out.println(TIE);
            }
            System.out.println("Let's play! What's your move? (Type the move or q to quit)");
            input = in.nextLine();
        }
        // While user does not input "q", play game
        
        // TODO: Insert the code to play the game. 
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written 
        // to do most of the work!


        in.close();
    }
}

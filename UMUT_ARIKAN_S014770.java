import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[][] board = new String[6][7];

        //Fill in our board with #
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                board[row][col] = "#";
            }
        }

        int turn = 1;
        String player = "X";
        boolean winner = false;

        //play a turn
        while (winner == false && turn <= 42){
            boolean suitPlay;
            int play;
            do {
                showBoard(board);

                System.out.print("pick a move (a number between 1-7) ");
                play = scan.nextInt()-1;





                //suitable play
                suitPlay = suitMove(play,board);

            }while (suitPlay == false);

            //drop the checker
            for (int row = board.length-1; row >= 0; row--){
                if(board[row][play].equals("#")){
                    board[row][play] = String.valueOf(player);
                    break;
                }
            }

            //looking for winner if there is exist
            winner = isWinner(String.valueOf(player),board);

            //switch players
            if (player.equals("X") ){
                player = "O";
            }else{
                player = "X";
            }

            turn++;
        }
        showBoard(board);

        if (winner){
            if (player.equals("X")){
                System.out.println("PC won");
            }else{
                System.out.println("User won");
            }
        }else{
            System.out.println("Tie game");
        }

    }

    public static void showBoard(String[][] Board){
        System.out.println(" 1 2 3 4 5 6 7");

        for (int row = 0; row < Board.length; row++){
            System.out.print(" ");
            for (int col = 0; col < Board[0].length; col++){
                System.out.print(Board[row][col]);
                System.out.print(" ");
            }
            System.out.println();

        }

        System.out.println();
    }

    public static boolean suitMove(int column, String[][] board){
        //looking for suitable column
        if (column < 0 || column > board[0].length){
            return false;
        }

        // looking for column has empty spaces
        if (!"#".equals(board[0][column])) {
            return false;
        }



        return true;
    }

    public static boolean isWinner(String player, String[][] board){
        //check for horizontal
        for(int row = 0; row<board.length; row++){
            for (int col = 0;col < board[0].length - 3;col++){
                if (board[row][col] == player   &&
                        board[row][col+1].equals(player) &&
                        board[row][col+2].equals(player) &&
                        board[row][col+3].equals(player)){
                    return true;
                }
            }
        }
        //check for vertical
        for(int row = 0; row < board.length - 3; row++){
            for(int col = 0; col < board[0].length; col++){
                if (board[row][col] == player   &&
                        board[row+1][col].equals(player) &&
                        board[row+2][col].equals(player) &&
                        board[row+3][col].equals(player)){
                    return true;
                }
            }
        }
        //check for up diagonal
        for(int row = 3; row < board.length; row++){
            for(int col = 0; col < board[0].length - 3; col++){
                if (board[row][col] == player   &&
                        board[row-1][col+1].equals(player) &&
                        board[row-2][col+2].equals(player) &&
                        board[row-3][col+3].equals(player)){
                    return true;
                }
            }
        }
        //check for down diagonal
        for(int row = 0; row < board.length - 3; row++){
            for(int col = 0; col < board[0].length - 3; col++){
                if ((board[row][col] == player) &&
                        board[row + 1][col + 1].equals(player) &&
                        board[row + 2][col + 2].equals(player) &&
                        board[row + 3][col + 3].equals(player)) {
                    return true;
                }
            }
        }
        return false;

    }
}

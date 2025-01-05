import java.util.*;
public class tictactoe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                board[row][col] = ' ';
            }
        }
    
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (!gameOver){
            if (count == 9){
                gameOver = true;
            }else{
                printBoard(board);
                System.out.println("Player " + player + " enter: ");
                System.out.print("Enter row: ");
                int row = sc.nextInt();
                System.out.print("Enter column: ");
                int col = sc.nextInt();
                if (board[row][col] == ' '){
                    count++;
                    board[row][col] = player;
                    gameOver = haveWon(board,player);
                    if (gameOver){
                        System.out.println("Player " + player + " won!");
                    }
                    else{
                        player = (player == 'X' ) ? '0' : 'X';
                    }
                }else{
                    System.out.println("Invalid move. Try again");
                }
            }
        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player){
        //check for row
        for (int row = 0; row < board.length; row++){
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        //check for col
        for (int col = 0; col < board[0].length; col++){
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        //diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                if(col == 2){
                    System.out.print(board[row][col] + " ");
                }else{
                    System.out.print(board[row][col] + " | ");
                }
            }
            System.out.println();
        }
    }
}


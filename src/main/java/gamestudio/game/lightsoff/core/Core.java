package gamestudio.game.lightsoff.core;

public class Core {
    public int[][] board;
    private final int[][] level1 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1}};
    private final int[][] level2 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}};
    private final int[][] level3 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 1, 1, 0},
            {1, 1, 0, 0, 0}};
    private final int[][] level4 = {
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1}};
    private final int[][] level5 = {
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 0, 0},
            {0, 1, 0, 0, 1}};
    private int size;
    public boolean isGameWon;

    public Core(){
        this.size = 5;
        this.board = new int[size][size];
        this.isGameWon = false;
    }

    public void choseLevel(int level){
        switch(level){
            case 1:
                copyBoard(level1);
                break;
            case 2:
                copyBoard(level2);
                break;
            case 3:
                copyBoard(level3);
                break;
            case 4:
                copyBoard(level4);
                break;
            case 5:
                copyBoard(level5);
                break;
        }
    }

    public void copyBoard(int[][] sourse){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = sourse[i][j];
            }
        }
    }

    public void displayBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isGameWon(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    public void press(int i, int j){
        toggle(i, j);
        toggle(i-1, j);
        toggle(i+1, j);
        toggle(i, j-1);
        toggle(i, j+1);
    }

    public void toggle(int i, int j){
        if((i >= 0 && i < size) && (j >= 0 && j < size)) {
            board[i][j] = (board[i][j] == 0) ? 1 : 0;
            //умова ? значення_якщо_істинно : значення_якщо_хибно;
        }
    }
}

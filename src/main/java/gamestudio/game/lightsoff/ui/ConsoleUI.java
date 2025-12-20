package gamestudio.game.lightsoff.ui;

import gamestudio.game.lightsoff.core.Core;
import gamestudio.game.lightsoff.core.GameState;

import java.util.Scanner;

public class ConsoleUI {
    Scanner scanner = new Scanner(System.in);
    Core core = new Core();
    GameState gameState;

    public ConsoleUI(){
        gameState = GameState.PLAYING;
    }

    public void playGame(){
        System.out.print("Chose the game level: ");
        int level = scanner.nextInt();
        if(level > 2){playGame();return;}
        core.choseLevel(level);

        while(gameState == GameState.PLAYING){
            core.displayBoard();
            System.out.print("Введи координати (рядок і стовпець від 0 до 4): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            core.press(row, col);
            System.out.println();
            if (core.isGameWon()) {
                core.displayBoard();
                System.out.println("\nGame Won!");
                gameState = GameState.END;
            }
        }
    }
}

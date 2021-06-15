package fr.jeanpicard.prs;

import fr.jeanpicard.prs.game.*;
import fr.jeanpicard.prs.player.ComputerPlayer;
import fr.jeanpicard.prs.player.ConsoleHelper;
import fr.jeanpicard.prs.player.HumanPlayer;
import fr.jeanpicard.prs.player.strategies.RandomStrategy;
import fr.jeanpicard.prs.player.strategies.ComputerStrategy;
import fr.jeanpicard.prs.player.Player;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PaperRockScissors
{
    private static final int DEFAULT_ROUND_NUMBER = 3;

    public static void main( String[] args ) throws GameException
    {
        displayIntroductionText();
        Game twoPlayerGame = new TwoPlayerGame();
        GameReporter reporter = new TwoPlayerGameReporter();
        twoPlayerGame.setGameReporter(reporter);

        ConsoleHelper consoleHelper = new ConsoleHelper();
        Player human = new HumanPlayer("Human", consoleHelper);
        ComputerStrategy randomStrategy = new RandomStrategy();
        Player computer = new ComputerPlayer("Computer", randomStrategy);
        twoPlayerGame.addPlayer(human);
        twoPlayerGame.addPlayer(computer);

        int rounds = getNumberOfRounds();
        twoPlayerGame.setNumberOfRounds(rounds);
        twoPlayerGame.play();
    }

    private static void displayIntroductionText(){
        System.out.println("Welcome to a game of Paper-Rock-Scissors");
        System.out.println("Paper-Rock-Scissors is a game for two players. Each player simultaneously opens his/her hand to display \n" +
                "a symbol: \n" +
                "• Fist equals rock \n" +
                "• Open hand equals paper \n" +
                "• Showing the index and middle finger equals scissors. \n" +
                " \n" +
                "The winner is determined by the following schema: \n" +
                "• Paper beats (wraps) rock \n" +
                "• Rock beats (blunts) scissors \n" +
                "• Scissors beats (cuts) paper. ");
    }

    private static int getNumberOfRounds() {
        System.out.println("How many rounds do you want to play? (default if empty: "+DEFAULT_ROUND_NUMBER+" )");
        Scanner reader = new Scanner(System.in);
        int roundNumber = -1;
        while(roundNumber < 1) {
            try {
                roundNumber = reader.nextInt();
                if(roundNumber == 0) {
                    System.out.println("There should to be at least 1 round.");
                }
            } catch (InputMismatchException e) {
                System.out.println("This needs to be a number");
            } catch (NoSuchElementException e) {
                roundNumber = DEFAULT_ROUND_NUMBER;
            }
        }
        return roundNumber;
    }

}

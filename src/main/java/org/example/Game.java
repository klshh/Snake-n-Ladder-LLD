package org.example;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5,4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player p1 = new Player("Ram",0);
        Player p2 = new Player("Sham",0);
        playerList.add(p1);
        playerList.add(p2);
    }

    public void startGame() {
        while (winner == null){
//            check player turn

            Player currentPlayer = checkPlayerTurn();
            System.out.println("player turn is:" + currentPlayer.name + " current position is: " + currentPlayer.currentPosition);



//            roll the dice

            Integer diceNumber = dice.rollDice();

//            check new position

            Integer newPosition = currentPlayer.currentPosition + diceNumber;
            newPosition = checkForJump(newPosition);
            currentPlayer.currentPosition = newPosition;

            System.out.println("player turn is:" + currentPlayer.name + " new Position is: " + newPosition);

//            check winning condition

            if(newPosition >= board.cells.length * board.cells.length-1){
                winner = currentPlayer;
            }
        }
        System.out.println("WINNER IS:" + winner.name);
    }

    private Integer checkForJump(Integer newPosition) {
        Cell cell = board.getCell(newPosition);
        if(cell.jump != null && cell.jump.start == newPosition){
            String jumpedDueTo = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
            System.out.println("jump due to: " + jumpedDueTo);
            return cell.jump.end;
        }
        return newPosition;
    }

    private Player checkPlayerTurn() {
        Player player = playerList.removeFirst();
        playerList.addLast(player);
        return player;
    }
}

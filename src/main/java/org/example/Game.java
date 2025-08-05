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
        Board board = new Board(10, 5,4);
        Dice dice = new Dice(1);
        Player winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();
        playerList.add(p1);
        playerList.add(p2);
    }

    public void startGame() {
        while (winner == null){

        }
    }
}

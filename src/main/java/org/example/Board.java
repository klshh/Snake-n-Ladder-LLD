package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    public Board(int boardSize, int noOfSnakes, int noOfLadders) {
        initializeCells(boardSize);
        addSnakesAndLadder(noOfLadders,noOfSnakes,boardSize);
    }

    private void addSnakesAndLadder(int noOfLadders, int noOfSnakes, int boardSize) {
        while(noOfSnakes > 0){

            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(snakeTail >= snakeHead) {
                continue;
            }

            Jump snake = new Jump();
            snake.start = snakeHead;
            snake.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snake;

            noOfSnakes--;
        }

        while(noOfLadders > 0){

            int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(ladderStart >= ladderEnd) {
                continue;
            }

            Jump ladder = new Jump();
            ladder.start = ladderStart;
            ladder.end = ladderEnd;

            Cell cell = getCell(ladderStart);
            cell.jump = ladder;

            noOfLadders--;
        }
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i = 0;i < boardSize; i++){
            for(int j = 0; j< boardSize; j++){
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }

    public Cell getCell(Integer newPosition) {
        int boardRow = newPosition / cells.length;
        int boardCol = newPosition % cells.length;
        return cells[boardRow][boardCol];
    }
}

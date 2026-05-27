package com.muhammad.chess.model;

import com.muhammad.chess.enums.*;

import java.util.List;

public class Game {
    private Board board;
    private Status status;
    private Color round;

    public Game(){
        board = new Board();
        status = Status.ACTIVE;
        round = Color.WHITE;
    }

    public Result makeMove(int oldRow, int oldCol, int newRow, int newCol) {

        // 1. check game active
        if (status != status.ACTIVE)
            return Result.GAME_OVER;

        // 2. check piece exists
        Piece piece = board.getPiece(oldRow, oldCol);
        if (piece == null)
            return Result.INVALID;

        // 3. check correct turn
        if (piece.getColor() != round)
            return Result.WRONG_TURN;

        // 4. check move is in valid moves list
        List<int[]> moves = piece.getMoves(oldRow, oldCol, board);
        if (!checkMove(moves, newRow, newCol))
            return Result.INVALID;

        // 5. Board handles everything else
        board.movePiece(oldRow, oldCol, newRow, newCol);

        // 6. flip turn
        round = (round == Color.WHITE) ? Color.BLACK : Color.WHITE;

        return Result.SUCCESS;
    }

    public boolean checkMove(List<int[]> moves, int row, int col){
        for (int[] move : moves) {
            if (move[0] == row && move[1] == col) return true; // ✅ compare values
        }
        return false;
    }

    public Color getRound(){
        return round;
    }
    public Status getStatus(){
        return status;
    }
    public Board getBoard(){
        return board;
    }
}

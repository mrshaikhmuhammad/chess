package com.muhammad.chess.entity;

import com.muhammad.chess.entity.pieces.Piece;

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

    public Move makeMove(int oldRow, int oldCol, int newRow, int newCol) {

        // 1. check game active
        if (status != status.ACTIVE)
            return Move.GAME_OVER;

        // 2. check piece exists
        Piece piece = board.getPiece(oldRow, oldCol);
        if (piece == null)
            return Move.INVALID;

        // 3. check correct turn
        if (piece.getColor() != round)
            return Move.WRONG_TURN;

        // 4. check move is in valid moves list
        List<int[]> moves = piece.getMoves(newRow, newCol, board);
        if (!checkMove(moves, newRow, newCol))
            return Move.INVALID;

        // 5. Board handles everything else
        board.movePiece(oldRow, oldCol, newRow, newCol);

        // 6. flip turn
        round = (round == Color.WHITE) ? Color.BLACK : Color.WHITE;

        return Move.SUCCESS;
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


}

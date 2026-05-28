package com.muhammad.chess.model;

import com.muhammad.chess.enums.*;

import java.util.InputMismatchException;
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

    public Result makeMove(String oldLocation, String newLocation) {
        int oldRow, oldCol, newRow, newCol;

        try{
            int[] coords = parseMove(oldLocation);
            oldRow = coords[0];
            oldCol = coords[1];

            coords = parseMove(newLocation);
            newRow = coords[0];
            newCol = coords[1];
        }
        catch (InputMismatchException e) {
            return Result.INVALID;
        }

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

    private int[] parseMove(String move)throws InputMismatchException {
        try{
            int col = Character.toLowerCase(move.charAt(0))  - 'a';
            int row = Integer.parseInt(String.valueOf(move.charAt(1))) - 1;
            return new int[]{row, col};
        }
        catch (Exception e){
            throw new InputMismatchException();
        }
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

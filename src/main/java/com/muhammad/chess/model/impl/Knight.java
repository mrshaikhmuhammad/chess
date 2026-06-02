package com.muhammad.chess.model.impl;

import com.muhammad.chess.enums.*;
import com.muhammad.chess.model.*;

import java.util.*;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public List<Position> getMoves(int row, int col, Board board) {
        int newRow, newCol;
        List<Position> moves = new ArrayList<>();
        int[][] directions = {
            { 2,  1}, { 2, -1}, {-2,  1}, {-2, -1},
            { 1,  2}, { 1, -2}, {-1,  2}, {-1, -2}
        };

        for (int[] dir : directions) {
            newRow = row + dir[0];
            newCol = col + dir[1];

            if (canOccupy(newRow, newCol, board)) {
                moves.add(new Position(newRow, newCol));
            } else if (canKill(newRow, newCol, board)) {
                moves.add(new Position(newRow, newCol));
                break;
            } else {
                break;
            }
        }
        return moves;
    }

    @Override
    public String toString(){
        return (super.getColor() == Color.WHITE)?"♘":"♞";
    }
}

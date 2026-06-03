package com.muhammad.chess.model.impl;

import com.muhammad.chess.enums.*;
import com.muhammad.chess.model.*;

import java.util.*;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public List<Position> getMoves(int row, int col, Board board) {
        int newRow, newCol;
        List<Position> moves = new ArrayList<>();
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {1, 1}, {1, -1}, {-1, 1}
        };

        for (int[] dir : directions) {
            newRow = row + dir[0];
            newCol = col + dir[1];

            if (isInBox(newRow, newCol) && (canOccupy(newRow, newCol, board) || canKill(newRow, newCol, board))) {
                moves.add(new Position(newRow, newCol));
            }
        }
        return moves;
    }

    @Override
    public String toString(){
        return (super.getColor() == Color.WHITE)?"♔":"♚";
    }
}

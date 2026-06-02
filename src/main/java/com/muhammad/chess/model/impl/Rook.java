package com.muhammad.chess.model.impl;

import com.muhammad.chess.enums.*;
import com.muhammad.chess.model.*;

import java.util.*;

public class Rook extends Piece {
    public Rook(Color color){
        super(color);
    }

    @Override
    public List<Position> getMoves(int row, int col, Board board) {
        int newRow, newCol;
        List<Position> moves = new ArrayList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            for (int i = 1; i < 8; i++) {
                newRow = row + dir[0] * i;
                newCol = col + dir[1] * i;

                if (canOccupy(newRow, newCol, board)) {
                    moves.add(new Position(newRow, newCol));
                } else if (canKill(newRow, newCol, board)) {
                    moves.add(new Position(newRow, newCol));
                    break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }

    public String toString(){
        return (super.getColor() == Color.WHITE)?"♖":"♜";
    }
}

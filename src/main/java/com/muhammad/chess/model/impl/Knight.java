package com.muhammad.chess.model.impl;

import com.muhammad.chess.model.Board;
import com.muhammad.chess.enums.Color;
import com.muhammad.chess.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public List<int[]> getMoves(int row, int col, Board board) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {
            { 2,  1}, { 2, -1}, {-2,  1}, {-2, -1},
            { 1,  2}, { 1, -2}, {-1,  2}, {-1, -2}
        };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (checkMove(newRow, newCol, board)) {
                moves.add(new int[]{newRow, newCol});
            } else if (checkKill(newRow, newCol, board)) {
                moves.add(new int[]{newRow, newCol});
                break;
            } else {
                break;
            }

        }
        return moves;
    }

    @Override
    public String toString(){
        if(super.getColor() == Color.WHITE){
            return "♘";
        }
        else{
            return "♞";
        }
    }
}

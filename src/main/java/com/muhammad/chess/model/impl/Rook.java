package com.muhammad.chess.model.impl;

import com.muhammad.chess.model.Board;
import com.muhammad.chess.enums.Color;
import com.muhammad.chess.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(Color color){
        super(color);
    }

    @Override
    public List<int[]> getMoves(int row, int col, Board board) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            for (int i = 1; i < 8; i++) {
                int newRow = row + dir[0] * i;
                int newCol = col + dir[1] * i;

                if (checkMove(newRow, newCol, board)) {
                    moves.add(new int[]{newRow, newCol});
                } else if (checkKill(newRow, newCol, board)) {
                    moves.add(new int[]{newRow, newCol});
                    break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }

    @Override
    public String toString(){
        if(super.getColor() == Color.WHITE){
            return "♖";
        }
        else{
            return "♜";
        }
    }
}

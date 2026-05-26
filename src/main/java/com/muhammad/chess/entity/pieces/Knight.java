package com.muhammad.chess.entity.pieces;

import com.muhammad.chess.entity.Board;
import com.muhammad.chess.entity.Color;

import java.util.List;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
    }

    @Override
    public List<int[]> getMoves(int row, int col, Board board) {
        return List.of();
    }

    @Override
    public String toString(){
        return "N";
    }
}

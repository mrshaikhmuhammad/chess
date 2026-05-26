package com.muhammad.chess.model.impl;

import com.muhammad.chess.model.Board;
import com.muhammad.chess.enums.Color;
import com.muhammad.chess.model.Piece;

import java.util.List;

public class Knight extends Piece {
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

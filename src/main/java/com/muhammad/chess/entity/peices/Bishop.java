package com.muhammad.chess.entity.peices;

import com.muhammad.chess.entity.Board;
import com.muhammad.chess.entity.Color;

import java.util.List;

public class Bishop extends Peice{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public List<int[]> getMoves(int row, int col, Board board) {
        return List.of();
    }

    @Override
    public String toString(){
        return "B";
    }
}

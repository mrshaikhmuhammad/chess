package com.muhammad.chess.model.impl;

import com.muhammad.chess.model.Board;
import com.muhammad.chess.enums.Color;
import com.muhammad.chess.model.Piece;

import java.util.List;

public class Rook extends Piece {
    public Rook(Color color){
        super(color);
    }

    @Override
    public List<int[]> getMoves(int row, int col, Board board) {
        return List.of();
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

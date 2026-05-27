package com.muhammad.chess.model.impl;

import com.muhammad.chess.model.Board;
import com.muhammad.chess.enums.Color;
import com.muhammad.chess.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean initial;

    public Pawn(Color color) {
        super(color);
        initial = true;
    }

    public void setInitial(boolean value){
        initial = value;
    }

    @Override
    public List<int[]> getMoves(int row, int col, Board board){
        List<int[]> moves = new ArrayList<>();
        int direction = ( getColor() == Color.WHITE )? 1 : -1;

        row = row + direction;
        if(checkMove(row, col, board)){
            moves.add(new int[]{row, col});

            if(initial && checkMove(row+direction, col, board)){
                moves.add(new int[]{row+direction, col});
            }
        }

        if(checkKill(row, col+1, board)){
            moves.add(new int[]{row, col+1});
        }
        if(checkKill(row, col-1, board)){
            moves.add(new int[]{row, col-1});
        }
        return moves;
    }

    @Override
    public String toString(){
        if(super.getColor() == Color.WHITE){
            return "♙";
        }
        else{
            return "♟";
        }
    }
}

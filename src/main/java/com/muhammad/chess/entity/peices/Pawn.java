package com.muhammad.chess.entity.peices;

import com.muhammad.chess.entity.Board;
import com.muhammad.chess.entity.Color;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Peice{
    boolean initial;

    public Pawn(Color color) {
        super(color);
        initial = true;
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public List<int[]> getMoves(int row, int col, Board board){
        List<int[]> moves = new ArrayList<>();
        int direction = ( getColor() == Color.WHITE )? -1 : 1;

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
}

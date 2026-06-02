package com.muhammad.chess.model.impl;

import com.muhammad.chess.enums.*;
import com.muhammad.chess.model.*;
import java.util.*;

public class Pawn extends Piece {
    private boolean isFirstMove;

    public Pawn(Color color) {
        super(color);
        isFirstMove = true;
    }

    @Override
    public List<Position> getMoves(int row, int col, Board board){
        List<Position> moves = new ArrayList<>(4);
        int direction = ( getColor() == Color.WHITE )? 1 : -1;

        if(canOccupy(row+direction, col, board)){
            moves.add(new Position(row+direction, col));

            if(isFirstMove && canOccupy(row+ 2 * direction, col, board)){
                moves.add(new Position(row + 2 * direction, col));
            }
        }

        if(canKill(row+direction, col+1, board)){
            moves.add(new Position(row+direction, col+1));
        }
        if(canKill(row+direction, col-1, board)){
            moves.add(new Position(row+direction, col-1));
        }
        return moves;
    }

    @Override
    public String toString(){
        return (super.getColor() == Color.WHITE)?"♙":"♟";
    }

    @Override
    public void onMove(){
        isFirstMove = false;
    }
}

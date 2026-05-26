package com.muhammad.chess.model;

import com.muhammad.chess.enums.Color;

import java.util.List;

public abstract class Piece {
    //white if color = 1 else black
    private Color color;

    public Piece(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }

    //True means both belong to same party
    public boolean checkEnemy(Piece piece){
        if (piece != null){
            return this.color != piece.getColor();
        }
        return false;
    }

    //True means valid
    private boolean checkLocation(int row, int col){
        return ( row>=0 && row<8 ) && ( col>=0 && col<8 );
    }

    //Checks can piece move thier
    public boolean checkMove(int row, int col, Board board){
        if(checkLocation(row, col)){
            Piece piece = board.getPiece(row, col);
            if(piece == null){
                return true;
            }
        }
        return false;
    }

    public boolean checkKill(int row, int col, Board board){
        if(checkLocation(row, col)){
            Piece piece = board.getPiece(row, col);
            if(checkEnemy(piece)){
                return true;
            }
        }
        return false;
    }

    public abstract List<int[]> getMoves(int row, int col, Board board);
}

package com.muhammad.chess.model;

import com.muhammad.chess.enums.Color;

import java.util.List;

public abstract class Piece {

    private Color color;

    public Piece(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public static boolean isInBox(int row, int col){
        return row >= 0 && row < 8  &&  col >= 0 && col < 8;
    }

    public boolean isEnemy(Piece piece){
        return piece != null && this.color != piece.getColor();
    }

    public boolean canOccupy(int row, int col, Board board){
        return isInBox(row, col) && board.getPiece(row, col) == null;
    }

    public boolean canKill(int row, int col, Board board){
        return isInBox(row, col) && isEnemy(board.getPiece(row, col));
    }

    public void onMove(){
        return;
    }

    public List<Position> getMoves(Position position, Board board){
        return getMoves(position.getRow(), position.getCol(), board);
    }
    public abstract List<Position> getMoves(int row, int col, Board board);
}

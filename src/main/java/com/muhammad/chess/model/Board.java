package com.muhammad.chess.model;

import com.muhammad.chess.enums.Color;
import com.muhammad.chess.model.impl.*;
import java.util.*;


public class Board {
    private Piece[][] board;
    private List<Piece> deadPeices;

    public Board(){
        deadPeices = new ArrayList<>();
        board = new Piece[8][8];
        setBoard();

    }

    public void movePiece(int oldRow, int oldCol, int newRow, int newCol){
        try {
            // is location in the box
            if (!checkLocation(newRow, newCol) || !checkLocation(oldRow, oldCol)) {
                throw new Exception("Location out of board");
            }

            // validate piece exists
            if (checkEmpty(oldRow, oldCol)) {
                throw new Exception("No piece at source location");
            }

            if(board[oldRow][oldCol] instanceof  Pawn){
                ((Pawn) board[oldRow][oldCol]).setInitial(false);
            }

            // is that box empty to move
            if (checkEmpty(newRow, newCol)) {
                board[newRow][newCol] = board[oldRow][oldCol];
                board[oldRow][oldCol] = null;
            }
            // do I need to kill enemy to move their
            else if(board[oldRow][oldCol].checkEnemy(board[newRow][newCol])){
                deadPeices.add(board[newRow][newCol]);
                board[newRow][newCol] = board[oldRow][oldCol];
                board[oldRow][oldCol] = null;
            }
            // it's your friend sitting their
            else{
                throw new Exception("Can not kill own friend");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setBoard(){
        for(int i=0; i<8; i++){
            board[1][i] = new Pawn(Color.WHITE);
            board[6][i] = new Pawn(Color.BLACK);
        }

        // White Pieces
        board[0][0] = new Rook(Color.WHITE);
        board[0][1] = new Knight(Color.WHITE);
        board[0][2] = new Bishop(Color.WHITE);
        board[0][3] = new King(Color.WHITE);
        board[0][4] = new Queen(Color.WHITE);
        board[0][5] = new Bishop(Color.WHITE);
        board[0][6] = new Knight(Color.WHITE);
        board[0][7] = new Rook(Color.WHITE);

        // Black Pieces
        board[7][0] = new Rook(Color.BLACK);
        board[7][1] = new Knight(Color.BLACK);
        board[7][2] = new Bishop(Color.BLACK);
        board[7][3] = new King(Color.BLACK);
        board[7][4] = new Queen(Color.BLACK);
        board[7][5] = new Bishop(Color.BLACK);
        board[7][6] = new Knight(Color.BLACK);
        board[7][7] = new Rook(Color.BLACK);
    }

    public Piece getPiece(int row, int col){
        return board[row][col];
    }

    public boolean checkEmpty(int row, int col){
        return board[row][col] == null;
    }

    private boolean checkLocation(int row, int col){
        return ( row>=0 && row<8 ) && ( col>=0 && col<8 );
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(board[i][j] != null){
                    sb.append(board[i][j]).append(" ");
                }
                else{
                    sb.append(". ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

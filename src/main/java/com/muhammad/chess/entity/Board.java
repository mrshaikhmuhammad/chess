package com.muhammad.chess.entity;

import com.muhammad.chess.entity.pieces.*;
import java.util.*;


public class Board {
    private Piece[][] board;
    private List<Piece> deadPeices;

    public Board(){
        deadPeices = new ArrayList<>();
        board = new Piece[8][8];
        setBoard();

    }

    public void move(int oldRow, int oldCol, int newRow, int newCol){
        if (checkEmpty(newRow, newCol)) {
            board[newRow][newCol] = board[oldRow][oldCol];
            board[oldRow][oldCol] = null;
//            deadPeices.add(board[newRow][newCol]);
        }
        else if(board[oldRow][oldCol].checkKill(newRow, newCol, this)){

        }
        try {
            // is location in the box
            if (checkLocation(newRow, newCol) && checkLocation(oldRow, oldCol)) {
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
                    throw new Exception("Invalid location movement\nTrying to kill your friend");
                }

              // location is out of box
            } else {
                throw new Exception("Invalid location movement");
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

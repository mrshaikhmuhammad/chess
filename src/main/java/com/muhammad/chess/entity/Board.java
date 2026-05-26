package com.muhammad.chess.entity;

import com.muhammad.chess.entity.pieces.*;

public class Board {
    private Piece[][] board;

    public Board(){
        board = new Piece[8][8];
        this.setBoard();
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

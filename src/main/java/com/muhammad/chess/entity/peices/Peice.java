package com.muhammad.chess.entity.peices;

import com.muhammad.chess.entity.Board;
import com.muhammad.chess.entity.Color;

import java.util.List;

public abstract class Peice {
    //white if color = 1 else black
    private Color color;

    public Peice(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }

    //True means both belong to same party
    private boolean checkEnemy(Peice peice){
        if (peice != null){
            return this.color != peice.getColor();
        }
        return false;
    }

    //True means valid
    private boolean checkLocation(int row, int col){
        return ( row>=0 && row<8 ) && ( col>=0 && col<8 );
    }

    //Checks can peice move thier
    public boolean checkMove(int row, int col, Board board){
        if(checkLocation(row, col)){
            Peice peice = board.getPeice(row, col);
            if(peice == null){
                return true;
            }
        }
        return false;
    }

    public boolean checkKill(int row, int col, Board board){
        if(checkLocation(row, col)){
            Peice peice = board.getPeice(row, col);
            if(checkEnemy(peice)){
                return true;
            }
        }
        return false;
    }




    public abstract List<int[]> getMoves(int row, int col, Board board);
}

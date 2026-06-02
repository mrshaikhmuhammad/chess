package com.muhammad.chess.model;

import java.util.*;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col){
        if (row >= 0 && row < 8  &&  col >= 0 && col < 8) {
            this.row = row;
            this.col = col;
        }
        else{
            throw new IllegalArgumentException("Invalid chess position!");
        }
    }

    public Position(String position){
        this(
            Character.toLowerCase(position.charAt(0))  - 'a',
            position.charAt(1) - '1'
        );
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString(){
        return "[ " + row + ", " + col + " ]";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if(obj instanceof  Position){
            Position pos = (Position) obj;
            return row == pos.getRow() && col == pos.getCol();
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

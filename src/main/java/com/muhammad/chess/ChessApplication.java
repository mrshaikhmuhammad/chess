package com.muhammad.chess;

import com.muhammad.chess.entity.Board;
import com.muhammad.chess.entity.peices.Peice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);

		Board board = new Board();
		System.out.println(board);

		Peice peice = board.getPeice(1, 1);
		System.out.println("Peice: " + peice );

		List<int[]> moves = peice.getMoves(1, 1, board);
		for(int[] move : moves){
			System.out.println(Arrays.toString(move)); 
		}

	}

}

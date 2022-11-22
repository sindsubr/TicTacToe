package org.sindu.game.tictactoegame.entity;

import java.util.HashMap;
import java.util.Map;

public class Players {

	private Map<Integer, String> boardMap = new HashMap<>();
	private String X;
	private String O;
	private String turn;

	public Map<Integer, String> getBoardMap() {
		
		if(boardMap.isEmpty()) {
			boardMap.put(1, "1");
			boardMap.put(2, "2");
			boardMap.put(3, "3");
			boardMap.put(4, "4");
			boardMap.put(5, "5");
			boardMap.put(6, "6");
			boardMap.put(7, "7");
			boardMap.put(8, "8");
			boardMap.put(9, "9");
		}
		
		return boardMap;
	}

	public void setBoardMap(Map<Integer, String> boardMap) {
		this.boardMap = boardMap;
	}

//	public String[] getBoard() {
//		for (int a = 0; a < 9; a++) {
//			board[a] = String.valueOf(a + 1);
//		}
//		return board;
//	}
//
//	public void setBoard(String[] board) {
//		this.board = board;
//	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getO() {
		return O;
	}

	public void setO(String o) {
		O = o;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	
}

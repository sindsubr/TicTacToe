package org.sindu.game.tictactoegame.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sindu.game.tictactoegame.entity.Players;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tictactoe")
public class TicTacToeController {

	List<Integer> xPosList = new ArrayList<>();
	List<Integer> oPosList = new ArrayList<>();
	String playerO;
	String playerX;

	@RequestMapping("/loadGame")
	public String reloadGame(Model gameModel) {
		Players players = new Players();
		players.setX("Player X");
		players.setO("Player O");
		players.setTurn("X");

		gameModel.addAttribute("players", players);
		return "playerdetails";
	}

	@RequestMapping("/processGame")
	public String processGame(Model gameModel, @ModelAttribute("gameModel") Players players) {
		playerO = players.getO();
		playerX = players.getX();
		gameModel.addAttribute("players", players);
		gameModel.addAttribute("turn", players.getTurn());
		return "tictactoe";
	}

	@RequestMapping("/process")
	public String processGame(@ModelAttribute("gameModel") Players players, Model gameModel,
			@RequestParam("tilePos") Integer data, @RequestParam("turn") String turn) {

		final Map<Integer, String> boardMap = players.getBoardMap();
		System.out.println(oPosList);
		System.out.println(xPosList);
		oPosList.stream().forEach(pos -> {
			boardMap.put(pos, "O");
		});

		xPosList.stream().forEach(pos -> {
			boardMap.put(pos, "X");
		});
		System.out.println(boardMap);
		if (boardMap.get(data).equals("X") || boardMap.get(data).equals("O")) {
			System.out.println("Slot already taken; re-click another slot number:");
		} else {
			System.out.println(players.getTurn());
			if (turn == null) {
				players.setTurn("O");
			} else if (turn.equals("O")) {
				System.out.println("O's will play first. Enter a slot number to place O in:");
				oPosList.add(data);
				players.setTurn("X");
			} else {
				System.out.println("X's will play first. Enter a slot number to place X in:");
				xPosList.add(data);
				players.setTurn("O");
			}
			oPosList.stream().forEach(pos -> {
				boardMap.put(pos, "O");
			});

			xPosList.stream().forEach(pos -> {
				boardMap.put(pos, "X");
			});
		}

		String winner = checkWinner(boardMap);
		if (winner != null) {
			oPosList = new ArrayList<>();
			xPosList = new ArrayList<>();
			if (winner.equals("X")) {
				gameModel.addAttribute("winner", playerX);
				return "congrats";
			} else if (winner.equals("O")) {
				gameModel.addAttribute("winner", playerO);
				return "congrats";
			} else {
				gameModel.addAttribute("winner", winner);
				return "congrats";
			}
		} else {
			players.setBoardMap(boardMap);
			gameModel.addAttribute("players", players);
			return "tictactoe";
		}
	}

	public String checkWinner(Map<Integer, String> boardMap) {
		for (int a = 1; a <= 8; a++) {
			String line = null;
			switch (a) {
			case 1:
				line = boardMap.get(1) + boardMap.get(2) + boardMap.get(3);
				break;
			case 2:
				line = boardMap.get(4) + boardMap.get(5) + boardMap.get(6);
				break;
			case 3:
				line = boardMap.get(7) + boardMap.get(8) + boardMap.get(9);
				break;
			case 4:
				line = boardMap.get(1) + boardMap.get(4) + boardMap.get(7);
				break;
			case 5:
				line = boardMap.get(2) + boardMap.get(5) + boardMap.get(8);
				break;
			case 6:
				line = boardMap.get(3) + boardMap.get(6) + boardMap.get(9);
				break;
			case 7:
				line = boardMap.get(1) + boardMap.get(5) + boardMap.get(9);
				break;
			case 8:
				line = boardMap.get(3) + boardMap.get(5) + boardMap.get(7);
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 1; a <= 9; a++) {
			if (boardMap.containsValue(String.valueOf(a + 1))) {
				break;
			} else if (a == 9)
				return "draw";
		}

		return null;
	}
}

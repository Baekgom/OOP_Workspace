package com.baekgom.repository;

import java.util.ArrayList;
import java.util.List;

import com.vo.BoardDetailVO;
import com.vo.BoardVO;

public class BoardRepository {

	public static List<BoardVO> board; 
	public static BoardRepository boardRepository;
	
	private BoardRepository() {
		board = new ArrayList<BoardVO>();
	}

	public static BoardRepository getInstance() {

		if(boardRepository == null) {
			boardRepository = new BoardRepository();
		}
		
		return boardRepository;
		
	}
	
	public void addNewBoard(BoardVO newBoard) {
		board.add(newBoard);
	}
	
	public void addBoard(int index, BoardVO boardVO) {
		board.add(index, boardVO);
	}

	public BoardVO makeNewBoard(String boardName) {
		List<BoardDetailVO> boardDetailsVOs = new ArrayList<BoardDetailVO>();
		BoardVO boardVO = new BoardVO(boardName, boardDetailsVOs);
		return boardVO;
	}

	public BoardVO selectBoard(String inputBoardStr) {
		for (int i = 0; i < board.size(); i++) {
			if (inputBoardStr.equals(board.get(i).getMenu())) {
				return board.get(i);
			}
		}
		return null;
	}

}

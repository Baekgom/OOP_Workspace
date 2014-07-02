package com.baekgom.repository;

import java.util.ArrayList;
import java.util.List;

import com.util.DateUtil;
import com.vo.BoardDetailVO;
import com.vo.BoardVO;

public class BoardDetailRepository {

	private List<BoardDetailVO> boardDetails;	
	
	public BoardDetailRepository(){
		boardDetails = new ArrayList<BoardDetailVO>();
	}
	
	public int selectBoardIndex(BoardVO board) {
		return BoardRepository.board.indexOf(board);
	}
	
	public void addBoardItem(int boardIndex, String title, String content, String wirter) {
		
		BoardDetailVO detail = new BoardDetailVO(
				BoardRepository.board.get(boardIndex).getBoardDetail().size(), 
				title, 
				content, 
				wirter, 
				DateUtil.getCurrentTime());
		
		BoardRepository.board.get(boardIndex).getBoardDetail().add(detail);
		
	}
	
	public void readBoardItem(BoardVO board) {
		
	}
	
	
}

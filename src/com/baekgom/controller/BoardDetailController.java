package com.baekgom.controller;

import java.util.List;

import com.print.PrintMessage;
import com.repository.BoardDetailRepository;
import com.repository.BoardRepository;
import com.util.DateUtil;
import com.util.InputUtil;
import com.vo.BoardDetailVO;
import com.vo.BoardVO;

public class BoardDetailController extends Contoroller {

	private PrintMessage printMsg;	
	private BoardDetailRepository detailRepository;

	private BoardVO boardSelected;
	private List<BoardDetailVO> detailVO;
	private String boardName;
	
	public BoardDetailController(BoardVO boardSelected) {
		printMsg = new PrintMessage();
		detailRepository = new BoardDetailRepository();
		this.detailVO = boardSelected.getBoardDetail();
		this.boardSelected = boardSelected;
		this.boardName = boardSelected.getMenu();
	}

	@Override
	public void execute() {
		while (true) {
			selectBoardDetail();
			if (!inputMenu()) {
				close();
				break;
			}
		}

	} 

	protected void checkInputValue(String value) {

		switch (value) {
		case "AddItem":
			detailVO.add(addItem());
			System.out.println("추가 완료"); //print 빼기 
			break;
		case "Modify":
			modifyItem();
			System.out.println("수정 완료"); //print 빼기
			break;
		case "Delete":
			deleteItem();
			System.out.println("삭제 완료"); //print 빼기
			break;
		case "exit":
			System.exit(1);
			break;
		default:
			break;
		}

	}

	protected boolean inputMenu() {
		printMsg.printBoardDetailMenu();
		printMsg.printMenuSelectComent();
		String value = InputUtil.getInputLine();

		if (value.equals("Undo")) {
			return false;
		} else {
			checkInputValue(value);
			return true;
		}
	};

	private BoardDetailVO addItem() {

		printMsg.printGetItemTitle();
		String title = InputUtil.getInputLine();
		printMsg.printGetItemContent();
		String content = InputUtil.getInputLine();
		printMsg.printGetItemWriter();
		String writer = InputUtil.getInputLine();

		BoardDetailVO temp = new BoardDetailVO(detailVO.size() + 1, title,
				content, writer, DateUtil.getCurrentTime());
		
		return temp;
	}

	private void modifyItem() {
		printMsg.printModifyItem();
		int index = InputUtil.getInputInteger()-1;
		InputUtil.getInputLine();
		
		if(index >= 0 && index < detailVO.size()) {
			
			printMsg.printGetItemTitle();
			String title = InputUtil.getInputLine();
			printMsg.printGetItemContent();
			String content = InputUtil.getInputLine();
			printMsg.printGetItemWriter();
			String writer = InputUtil.getInputLine();

			BoardDetailVO temp = new BoardDetailVO(detailVO.get(index).getNum(), title,
					content, writer, DateUtil.getCurrentTime());
	
			detailVO.set(index, temp);
			
		}else {
			//예외 처리 
		}
	}

	private void deleteItem() {
		printMsg.printDeleteItem();
		int index = InputUtil.getInputInteger()-1;
		InputUtil.getInputLine();
		
		if(index >= 0 && index < detailVO.size()) {
			detailVO.remove(index);
			for (int i = 0; i < detailVO.size(); i++) {
				detailVO.get(i).setNum(i+1);
			}
		}
	}

	private void selectBoardDetail() {

		if (boardSelected.getBoardDetail().size() <= 0
				|| boardSelected.getBoardDetail() == null) {
			printMsg.printNoBoardDetailItem(boardName);
		} else {
			printMsg.printBoardItemList(detailVO);
		} 

	}

	private void close() {
		
		BoardRepository.board.set(detailRepository.selectBoardIndex(boardSelected), boardSelected);
	}

}

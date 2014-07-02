package com.baekgom.controller;

import com.print.PrintMessage;
import com.repository.BoardRepository;
import com.util.InputUtil;
import com.vo.BoardVO;

public class BoardMenuController extends Contoroller {

	private PrintMessage printMsg;
	private BoardRepository repository;
	private BoardVO boardSelected;

	public BoardMenuController() {
		printMsg = new PrintMessage();
		repository = BoardRepository.getInstance();

		// 기본 게시판 세팅
		repository.addNewBoard(repository.makeNewBoard("NoticeBoard"));
		repository.addNewBoard(repository.makeNewBoard("FreeBoard"));

	}

	@Override
	public void execute() {

		printMsg.printMainTitel();

		while (true) {
			printMsg.PrintBoardList(BoardRepository.board);
			printMsg.printMenuSelectComent();
			inputMenu();
		}

	}

	protected boolean inputMenu() {
		String inputBoardStr = InputUtil.getInputLine();
		checkInputValue(inputBoardStr);

		return true;
	} 
 
	protected void checkInputValue(String value) {

		boardSelected = repository.selectBoard(value);

		if (boardSelected == null) {
			switch (value) {
			case "add":
				addBoard();
				break;
			case "exit":
				System.exit(1);
				break;
			default:
				printMsg.printInputError();
				break;
			}
		} else {
			BoardDetailController boardDetailController = new BoardDetailController(boardSelected);
			boardDetailController.execute();
		}
	}

	private void addBoard() {
		printMsg.printAddBoardComent();
		String boardName = InputUtil.getInputLine();
		repository.addNewBoard(repository.makeNewBoard(boardName));
	}

}

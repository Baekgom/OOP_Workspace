package com.baekgom.print;

import java.util.List;

import com.vo.BoardDetailVO;
import com.vo.BoardVO;

public class PrintMessage {

	public void printMainTitel() {
		System.out.println("WhiteBear's Board");
	}

	public void PrintBoardList(List<BoardVO> board) {

		for (BoardVO boardVO : board) {
			System.out.print("-" + boardVO.getMenu());
			System.out.print("\t");
		}
		System.out.println("-add\t-exit");

	}
	public void printBoardItemList(List<BoardDetailVO> detail) {

		System.out.println("******************** 글 목록 ************************");

		for (BoardDetailVO items : detail) {
			System.out.println(items.toString());
		}

	}

	public void printMenuSelectComent() {

		System.out.print("메뉴를 입력하세요. : ");

	}

	public void printAddBoardComent() {
		System.out.print("추가할 게시판 이름 : ");
	}

	public void printNoBoardDetailItem(String boardName) {
		System.out.println(boardName + " 게시판에 글이 없습니다.");
	}

	public void printBoardDetailItem() {
		System.out.println("-ItemAdd\t-ItemDelete\t-ItemSelect");

	}

	public void printInputError() {
		System.out.println("명령어를 잘못 입력하셨습니다.");
	}
	
	public void printError(String errMsg) {
		System.out.println(errMsg);
	}

	public void printGetItemTitle() {
		System.out.println("******************** 글작성 ***********************");
		System.out.print("글 제목 : ");
	}

	public void printGetItemContent() {
		System.out.print("글 내용 : ");
	}

	public void printGetItemWriter() {
		System.out.print("작성자 : ");
	}

	public void printBoardDetailMenu() {
		System.out.println("-AddItem -Modify -Delete -Undo -exit");
	}
	
	public void printRemoveItem() {
		System.out.print("삭제 할 글 번호 : ");
	}

	public void printModifyItem() {
		System.out.print("수정 할 글 번호 : ");
	}
	
	public void printDeleteItem() {
		System.out.println("삭제 할 글 번호 : ");
	}
	
}

package com.baekgom.main;

import com.controller.BoardDetailController;
import com.controller.BoardMenuController;

//검증 if 체크 코드 분리 하기

public class Main {

	public static void main(String[] args) {
	
		BoardMenuController menuController = new BoardMenuController();
		menuController.execute();

	}
	
}

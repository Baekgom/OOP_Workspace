package com.baekgom.vo;

import java.util.List;

public class BoardVO {

	String menu;
	List<BoardDetailVO> boardDetail;

	public BoardVO(String menu, List<BoardDetailVO> boardDetail) {
		super();
		this.menu = menu;
		this.boardDetail = boardDetail;
	}

	public String getMenu() {
		return menu;
	}

	public List<BoardDetailVO> getBoardDetail() {
		return boardDetail;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public void setBoardDetail(List<BoardDetailVO> boardDetail) {
		this.boardDetail = boardDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((boardDetail == null) ? 0 : boardDetail.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		if (boardDetail == null) {
			if (other.boardDetail != null)
				return false;
		} else if (!boardDetail.equals(other.boardDetail))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardVO [menu=" + menu + ", boardDetail=" + boardDetail + "]";
	}

}

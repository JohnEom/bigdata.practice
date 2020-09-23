package com.johneom.board.mapper;

import java.util.List;

import com.johneom.board.vo.BoardVO;

public interface BoardMapper {

	// 1.list - 전체데이터구하기(페이지처리)
	public List<BoardVO> list();
	public Integer getRow();
	// 2.view - 조회수1증가
	public BoardVO view(int no);
	public void increase(int no);
	// 3.write
	public void write(BoardVO vo);
	// 4.update
	public void update(BoardVO vo);
	// 5.delete - (no, pw 받기 -> BoardVO로 받는게 편함(나머지는 null 값으로 넘어가므로 데이터 크지 않음.)
	public void delete(BoardVO vo);
}

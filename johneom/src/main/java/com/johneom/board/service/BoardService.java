package com.johneom.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.johneom.board.vo.BoardVO;

/**
 * 인터페이스 개발
 */
@Service
public interface BoardService {

	//list
	@Select("select * from board where no>0")
	public List<BoardVO> list();
	//view
	public BoardVO view(int no,int inc);
	//write
	public void write(BoardVO vo);
	//update
	public void update(BoardVO vo);
	//delete
	public void delete(BoardVO vo);
}

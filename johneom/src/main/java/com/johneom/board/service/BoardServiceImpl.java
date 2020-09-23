package com.johneom.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johneom.board.mapper.BoardMapper;
import com.johneom.board.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// 자동생성: @Controller, @Service, @Repository,
// @Component, @RestController, @~Advice
// servlet-context에서 component-scan으로 설정된 패키지 아래 클래스 검색
@Service
@Log4j
@Qualifier("boardServiceImpl")
@AllArgsConstructor //DI:생성자를 이용한 모든 속성을 자동 DI시킨다.lombook
public class BoardServiceImpl implements BoardService{

	//@AllArgsConstructor 를 이용해서 자동 DI 된다.
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		log.info("--- 게시판 글 리스트 service ---");
		return mapper.list();
	}

	@Override
	public BoardVO view(int no, int inc) {
		// TODO Auto-generated method stub
		// inc 가 1 일 때만 조회수 증가 -> 데이터가져오기
		if(inc==1) mapper.increase(no);
		return mapper.view(no);
	}

	@Override
	public void write(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.write(vo);
	}

	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.update(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.delete(vo);
	}
	// 인터페이스를 정의된 것을 재정의해준다.
	// un-implement overrides 한다. 

}

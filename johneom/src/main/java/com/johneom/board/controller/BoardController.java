package com.johneom.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johneom.board.service.BoardService;
import com.johneom.board.vo.BoardVO;



// Controller, Service, Repository,
// Component, RestController, ~Advice
@Controller
@RequestMapping("/board") // http://localhost/board
//@AllArgsConstructor
public class BoardController {

	/**
	 * 1.리스트 list -get
	 * 2.보기 view -get
	 * 3-1.글쓰기 폼 writeForm -get
	 * 3-2.글쓰기 처리 write -post
	 * 4-1.글수정 폼 updateForm -get
	 * 4-2.글수정 처리 update -post
	 * 5. 글삭제 delete -get
	 */
	
	private final String MODULE = "board";
	
	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService service;
	
	// 1. 리스트 - get
	@GetMapping("/list.do")
	public String list(Model model) {
		//모델에 데이터를 담으면
		//리퀘스트에 데이터가 담기게 된다.
		//jsp에서 꺼내쓸때는 ${list} | ${requestScope.list}
		//1.page 2.request 3.session 4.
		//리퀘스트를 콕 집어 검색 명령 가능하나 귀찮다. EL 객체
		model.addAttribute("list", service.list());
		return MODULE + "/list";
	}
	// 2. 보기 - get
	@GetMapping("/view.do")
	public String view(Model model, int no, int inc) {
		model.addAttribute("vo", service.view(no, inc));
		return MODULE + "/view";
	}
	// 3-1. 글쓰기 폼 - get
	@GetMapping("/write.do")
	public String writeForm() {
		return MODULE + "/write";
	}
	// 3-2. 글쓰기 처리 - post
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		System.out.println("vo:"+vo);
		service.write(vo);
		return "redirect:list.do";
	}
	// 4-1. 글수정 폼 - get
	@GetMapping("/update.do")
	public String updateForm(Model model, int no) {
		// 데이터를 가져오기 위해 view 메서드 호출(inc=0)
		model.addAttribute("vo",service.view(no, 0));
		return MODULE + "/update";
	}
	// 4-2. 글수정 처리 - post
	@PostMapping("/update.do")
	public String update(BoardVO vo) {
		service.update(vo);
		return "redirect:view.do?no="+vo.getNo()+"&inc=0";
	}
	// 5. 삭제 - get
	@PostMapping("/delete.do")
	public String delete(BoardVO vo) {
		service.delete(vo);
		return "redirect:list.do";
	}
}

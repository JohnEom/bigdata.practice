package com.johneom.board.vo;

import java.util.Date;

import lombok.Data;

// 자동으로 getter/setter,generator,toString() 생성
@Data
public class BoardVO {

	private int no;
	private String title, content, writer;
	private Date writeDate;
	private int hit;
	private String pw;
}

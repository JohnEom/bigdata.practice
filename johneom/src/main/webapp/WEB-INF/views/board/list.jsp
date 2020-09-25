<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>

  <!-- Bootstrap / jQuery 라이브러리 등록 : CDN -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.dataRow:hover {
	background: #ccc;
	cursor: pointer;
}
</style>

<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
		//글번호 찾기 - 글번호에 클래스를 부여한다
		var no = $(this).find(".no").text();
		location = "view.do?no="+no+"&inc=1";
	});
});
</script>

</head>
<body>
<div class="container">
<h1>게시판 리스트</h1>
<table class="table">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<!-- 만약 데이터가 없으면 데이터 없음을 표시 함. -->
<c:if test="${empty list }">
<tr>
	<td colspan="5">데이터가 존재하지 않습니다.</td>
</tr>
</c:if>
<!-- 데이터가 존재하면 데이터 갯수만큼 반복 표시함. -->
<c:if test="${!empty list }">
<c:forEach items="${list }" var="vo"><!-- item:데이터받는부분 var:데이터이름 -->
<tr class="dataRow">
	<td class="no">${vo.no }</td>
	<td>${vo.title }</td>
	<td>${vo.writer }</td>
	<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy.MM.dd"/></td>
	<td>${vo.hit }</td>
</tr>
</c:forEach>
</c:if>
<tr>
	<td colspan="5">
<!-- 		<button>글쓰기</button> -->
		<a href="write.do" class="btn btn-default">글쓰기</a>
	</td>
</tr>
	
</table>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,height=device-height,initial-scale=1,maximum-scale=1,user-scalable=no,viewport-fit=cover">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
    <script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>
    <title>미래항공 관리자페이지</title>
</head>
<body style="background: #fff;">
    <section class="content board_blank">
        <h2>공지글</h2>
        <table class="table">
            <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
            	<c:if test="${empty noticeList}">
            		<tr><td colspan="9" class="tableEmpty">검색 결과가 없습니다</td></tr>
            	</c:if>
            	<c:forEach var="notice" items="${noticeList}">
	                <tr>
	                    <td><input type="checkbox" value="${notice.post_index}"></td>
	                    <td><a href="postView?board_name=${notice.post_index}">${notice.title}</a></td>
	                    <td>${notice.writer}</td>
	                    <td>${notice.post_date}</td>
	                    <td>${notice.hits}</td>
	                </tr>
            	</c:forEach>
            </tbody>
        </table>
        <div class="submit">
            <input type="submit" value="공지글해제">
        </div>
    </section>
    
    <section class="content board_blank">
        <h2>공지글지정</h2>
        <table class="table">
            <colgroup>
        		<col width="5%">
        		<col width="35%">
        	</colgroup>
            <thead>
                <tr>
                    <th><input type="checkbox" onclick="selectAll(this)"></th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
               	<c:if test="${empty postList}">
            		<tr><td colspan="9" class="tableEmpty">검색 결과가 없습니다</td></tr>
            	</c:if>
            	<c:forEach var="post" items="${postList}">
	                <tr>
	                    <td><input type="checkbox" name="tableSelect" value="${post.post_index}"></td>
	                    <td><a href="postView?board_name=${post.post_index}">${post.title}</a></td>
	                    <td>${post.writer}</td>
	                    <td>${post.post_date}</td>
	                    <td>${post.hits}</td>
	                </tr>
            	</c:forEach>
            </tbody>
        </table>
        <div class="flex_content_footer">
	        <button class="btn danger" form="boardform" onclick="javascript:checkDelete(this)">선택삭제</button>
	        <div class="navi">
	           	<a href="postNotice?page=${navi.currentPage - navi.pagePerGroup}&board_name=${board_name}" class="prev"></a>
	               	<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
						<a href="postNotice?board_name=${board_name}&page=${counter}" <c:if test="${navi.currentPage == counter}">class="active"</c:if>>${counter}</a>
					</c:forEach>
	           	<a href="postNotice?page=${navi.currentPage + navi.pagePerGroup}&board_name=${board_name}" class="next"></a>
	       	</div>
       	</div>
        <div class="submit">
            <input type="submit" value="공지글지정">
        </div>
    </section>

</body>
</html>
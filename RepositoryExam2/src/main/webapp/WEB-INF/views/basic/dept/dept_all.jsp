<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<html>
<head>
	<title>Dept</title>
	<script type="text/javascript">
// 		페이지 번호 클릭시 실행될 함수
		function fn_egov_link_page(pageNo) {
// 			1) 페이지번호를 받기 : 0 -> 1,2(클릭), pageNo(클릭한 번호)
			document.listForm.pageIndex.value = pageNo; // 컨트롤러로 전송됨
// 			2) 재조회(다시 전체조회) : /basic/dept
			document.listForm.action = "/basic/dept";
// 			3) submit() 실행
			document.listForm.submit();
		}
// 		검색 버튼 클릭시 실행될 함수
		function fn_egov_selectList() {
// 			1) 페이지번호 : 1 번으로 전송(컨트롤러)
			document.listForm.pageIndex.value = 1;
// 			2) action 속성 : /basic/dept (다시 전체조회)
			document.listForm.action = "/basic/dept";
// 			3) submit() 실행
			document.listForm.submit();
// 			4) (참고) 검색어(input) 밑에서 자동으로 전송됨(컨트롤러)
	}
// 		부서번호 클릭시 상세조회 페이지열기 함수
		function fn_select(dno) {
// 			1) 부서번호(dno)[input 태그] -> 상세조회로 전달
			document.listForm.dno.value = dno;
// 			2) action = "/basic/dept/edition"
			document.listForm.action = "/basic/dept/edition"
// 			3) submit()
			document.listForm.submit();
		}
	</script>
</head>
<body>
<!-- 	머리말 : ctrl + shift + c(주석단축키), ctrl + space(자동완성) -->
<jsp:include page="/common/header.jsp"></jsp:include>
<!-- 본문 -->
<div class="container">
	<form id="listForm" name="listForm" method="get">
		<input type="hidden" name="dno">
		<!-- 		검색어 입력양식 -->
		<div class="input-group mb-3 mt-3" >
	  		<input type="text"
	   			class="form-control"
	   			id="searchKeyword"
	   			name="searchKeyword"
	    		placeholder="부서명입력" 
	    		onkeypress="fn_egov_selectList()"
	  		>
	  		<button class="btn btn-primary" 
	  			type="button" 
	  			onclick="fn_egov_selectList()"
	  		>
	  			검색
	  		</button>
		</div>
<!-- 	테이블 -->
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">dno</th>
		      <th scope="col">dname</th>
		      <th scope="col">loc</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="data" items="${depts}">
		  		<tr>		 
		  			<td>
		  				<a href="javascript:fn_select('<c:out value="${data.dno}" />')">
                     <c:out value="${data.dno}" />
		  				</a>
		  			</td>    		   
			      	<td><c:out value="${data.dno}"/></td>
			      	<td><c:out value="${data.dname}"/></td>
			      	<td><c:out value="${data.loc}"/></td>
			    </tr>
			 </c:forEach>
		  </tbody>
		</table>
		
<!--    페이징 번호 : 전자정부프레임워크 페이지소스 :
       (참고) https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte:ptl:view:paginationtag 
-->
		<div id="paging" class="text-center">
            <ui:pagination paginationInfo="${paginationInfo}" type="image"
               jsFunction="fn_egov_link_page" />
            <input type="hidden" id="pageIndex" name="pageIndex" />
         </div>
	</form>
</div>
<!-- 꼬리말 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>

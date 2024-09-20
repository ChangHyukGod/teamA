<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<title>Emp</title>
	<script type="text/javascript">
// 		페이지 번호 클릭시 실행될 함수
		function fn_egov_link_page(pageNo) {
			document.listForm.pageIndex.value = pageNo; // 컨트롤러로 전송됨
			document.listForm.action = "/basic/emp";
			document.listForm.submit();
		}
<!-- 연습 7) 부서 전체조회(dept_all.jsp) 샘플을 보고 검색어 기능을 구현하세요 -->
<!-- 함수명 : fn_egov_selectList -->
<!--   ( url : /basic/emp ) -->
		function fn_egov_selectList() {
// 			1) 페이지번호 : 1 번으로 전송(컨트롤러)
			document.listForm.pageIndex.value = 1;
// 			2) action 속성 : /basic/dept (다시 전체조회)
			document.listForm.action = "/basic/emp";
// 			3) submit() 실행
			document.listForm.submit();
// 			4) (참고) 검색어(input) 밑에서 자동으로 전송됨(컨트롤러)
	}
// 		사원번호 클릭시 상세조회 페이지 열기 함수
		function fn_select(eno){
			document.listForm.eno.value =eno;
			document.listForm.action = "/basic/emp/edition"
			document.listForm.submit();
		}
	</script>
</head>
<body>
<!-- 머리말 -->
<jsp:include page="/common/header.jsp"></jsp:include>
<!-- 연습 5) dept_all 을 참고해서 검색어 입력, 테이블로 결과를 출력(이쁘게), 페이징() -->

<!-- 연습 6) 부서 전체조회(dept_all.jsp) 샘플을 보고 페이지 번호 클릭시 재조회되게 구현하세요 -->
<!-- (url : /basic/emp) -->
<!-- 본문 -->
<div class="container">
	<form id="listForm" name="listForm" method="get">
		<input type="hidden" name="eno">
		<!-- 		검색어 입력양식 -->
		<div class="input-group mb-3 mt-3" >
	  		<input type="text"
	   			class="form-control"
	   			id="searchKeyword"
	   			name="searchKeyword"
	    		placeholder="사원명입력" 
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
		      <th scope="col">eno</th>
		      <th scope="col">ename</th>
		      <th scope="col">job</th>
		      <th scope="col">manager</th>
		      <th scope="col">hiredate</th>
		      <th scope="col">salary</th>
		      <th scope="col">commission</th>
		      <th scope="col">dno</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="data" items="${emps}">
		  		<tr>
		  		<td>
		  			<a href="javascript:fn_select('<c:out value="${data.eno}" />')">
		  			<c:out value="${data.eno}"></c:out>
		  		</a>
		  		</td>		     		   
			      <td><c:out value="${data.eno}"/></td>
			      <td><c:out value="${data.ename}"/></td>
			      <td><c:out value="${data.job}"/></td>
			      <td><c:out value="${data.manager}"/></td>
			      <td><c:out value="${data.hiredate}"/></td>
			      <td><c:out value="${data.salary}"/></td>
			      <td><c:out value="${data.commission}"/></td>
			      <td><c:out value="${data.dno}"/></td>
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
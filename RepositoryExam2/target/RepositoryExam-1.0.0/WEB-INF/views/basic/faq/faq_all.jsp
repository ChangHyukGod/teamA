<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
	function fn_egov_link_page(pageNo) {
//			1) 페이지번호를 받기 : 0 -> 1,2(클릭), pageNo(클릭한 번호)
		document.listForm.pageIndex.value = pageNo; // 컨트롤러로 전송됨
//			2) 재조회(다시 전체조회) : /basic/dept
		document.listForm.action = "/basic/faq";
//			3) submit() 실행
		document.listForm.submit();
	}
	</script>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="container">
	<form id="listForm" name="listForm" method="get">
		<input type="hidden" name="fno">
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
		      <th scope="col">fno</th>
		      <th scope="col">title</th>
		      <th scope="col">content</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="data" items="${faqs}">
		  		<tr>		 
		  			<td>
		  				<a href="javascript:fn_select('<c:out value="${data.fno}" />')">
                     <c:out value="${data.fno}" />
		  				</a>
		  			</td>    		   
			      	<td><c:out value="${data.fno}"/></td>
			      	<td><c:out value="${data.title}"/></td>
			      	<td><c:out value="${data.content}"/></td>
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
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>

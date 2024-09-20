<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" defer="defer">
//        저장 버튼 클릭시 실행할 함수
      function fn_save() {
//          1) 컨트롤러 함수 : 저장함수 실행(action) : /basic/dept/add
            document.addForm.action = "/basic/dept/add";
//          2) submit() 실행
            document.addForm.submit();
      }
    </script>
</head>
<body>
<%--    머리말--%>
<jsp:include page="/common/header.jsp"/>
<%--    본문--%>
<div class="container">
<!-- 		유효성 체크 태그 추가 -->
   <form:form modelAttribute="deptVO" id="addForm" name="addForm" method="post">
<%--      TODO: 추가페이지 : 기본키(게시판번호) 입력(없음) : 자동생성  --%>
        <div class="mb-3">
            <%--            게시판제목 입력양식 --%>
            <label for="dname" class="form-label">dname</label>
            <input  
                  class="form-control"
                  id="dname"
                  name="dname"
                  placeholder="게시판제목" />
            &nbsp;<form:errors path="dname" />
        </div>
        <div class="mb-3">
            <%--            게시판내용 입력양식 --%>
            <label for="loc" class="form-label">loc</label>
            <input 
                   class="form-control"
                   id="loc"
                   name="loc"
                   placeholder="게시판내용입력" />
            &nbsp;<form:errors path="loc" />
        </div>
        <div class="mb-3">
            <button class="btn btn-primary" onclick="fn_save()">저장</button>
        </div>
    </form:form>
</div>
<%--    꼬리말--%>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>

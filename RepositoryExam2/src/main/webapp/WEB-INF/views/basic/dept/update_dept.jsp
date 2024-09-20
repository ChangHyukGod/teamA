<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" defer="defer">
//        수정 버튼 클릭시 실행함수
       function fn_save() {
//          1) action 속성 : "/basic/dept/edit"
         document.detailForm.action = "/basic/dept/edit";
//          2) submit() 실행
         document.detailForm.submit();
      }
//     삭제 버튼 클릭시 실행함수
       function fn_delete() {
//           1) action 속성 : "/basic/dept/delete"
          document.detailForm.action = "/basic/dept/delete";
//           2) submit() 실행
          document.detailForm.submit();
       }
    </script>
</head>
<body>
<%--  머리말  --%>
<jsp:include page="/common/header.jsp"/>
<%--  본문 : 수정/추가 : form/input 태그 --%>
<div class="container">
<%--    수정 form --%>
    <form id="detailForm" name="detailForm" method="post">
<!--          부서번호 -->
       <input type="hidden" name="dno" value="<c:out value="${deptVO.dno}" />">
        <div class="mb-3">
            <%--             제목 입력양식 --%>
            <label for="dname" class="form-label">dname</label>
            <input 
                   class="form-control"
                   id="dname"
                   name="dname"
                   value="<c:out value="${deptVO.dname}" />"
                   placeholder="제목입력" />
        </div>
        <div class="mb-3">
            <%--            내용 입력양식 --%>
            <label for="loc" class="form-label">loc</label>
            <input 
                   class="form-control"
                   id="loc"
                   name="loc"
                   value="<c:out value="${deptVO.loc}" />"
                   placeholder="내용입력" />
        </div>
<%--     수정버튼       --%>
        <div class="mb-3">
            <button class="btn btn-warning" onclick="fn_save()">수정</button>
                        
            <button class="btn btn-danger" onclick="fn_delete()">삭제</button>
        </div>
    </form>
</div>
<%--  꼬리말  --%>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>

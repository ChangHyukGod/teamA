<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
<!--     연습 : fn_save js 함수를 수정버튼을 넣어서 테스트 대화상자 출력 -->
    <script type="text/javascript" defer="defer">
//        수정 버튼 클릭시 실행함수
       function fn_save() {
         document.detailForm.action = "/basic/emp/edit";
         document.detailForm.submit();
      }
//       삭제 버튼 클릭시 실행함수
      function fn_delete() {
         document.detailForm.action = "/basic/emp/delete";
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
    <!--          사원번호 -->
       <input type="hidden" name="eno" value="<c:out value="${empVO.eno}" />">
        <div class="mb-3">
            <%--             제목 입력양식 --%>
            <label for="ename" class="form-label">ename</label>
            <input 
                   class="form-control"
                   id="ename"
                   name="ename"
                   value="<c:out value="${empVO.ename}" />"
                   placeholder="제목입력" />
        </div>
        <div class="mb-3">
            <%--            내용 입력양식 --%>
            <label for="job" class="form-label">job</label>
            <input 
                   class="form-control"
                   id="job"
                   name="job"
                   value="<c:out value="${empVO.job}" />"
                   placeholder="내용입력" />
        </div>
        <div class="mb-3">
            <%--             제목 입력양식 --%>
            <label for="manager" class="form-label">manager</label>
            <input 
                   class="form-control"
                   id="manager"
                   name="manager"
                   value="<c:out value="${empVO.manager}" />"
                   placeholder="제목입력" />
        </div>
        <div class="mb-3">
            <%--            내용 입력양식 --%>
            <label for="hiredate" class="form-label">hiredate</label>
            <input 
                   class="form-control"
                   id="hiredate"
                   name="hiredate"         
                   value="<c:out value="${empVO.hiredate}" />"          
                   placeholder="내용입력" />
        </div>
        <div class="mb-3">
            <%--             제목 입력양식 --%>
            <label for="salary" class="form-label">salary</label>
            <input 
                   class="form-control"
                   id="salary"
                   name="salary"
                   value="<c:out value="${empVO.salary}" />" 
                   placeholder="제목입력" />
        </div>
        <div class="mb-3">
            <%--            내용 입력양식 --%>
            <label for="commission" class="form-label">commission</label>
            <input 
                   class="form-control"
                   id="commission"
                   name="commission"
                   value="<c:out value="${empVO.commission}" />" 
                   placeholder="내용입력" />
        </div>
        <div class="mb-3">
            <%--            내용 입력양식 --%>
            <label for="dno" class="form-label">dno</label>
            <input 
                   class="form-control"
                   id="dno"
                   name="dno"
                   value="<c:out value="${empVO.dno}" />"
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

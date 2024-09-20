<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
//        저장 버튼 클릭시 실행할 함수
      function fn_save() {
         document.addForm.action = "/basic/emp/add";
         document.addForm.submit();
      }
    </script>
</head>
<body>
<%--    머리말--%>
<jsp:include page="/common/header.jsp"/>
<%--    본문--%>
<div class="container">
   <form id="addForm" name="addForm" method="post">
<%--      TODO: 추가페이지 : 기본키(게시판번호) 입력(없음) : 자동생성  --%>
        <div class="mb-3">
            <%--            게시판제목 입력양식 --%>
            <label for="ename" class="form-label">ename</label>
            <input  
                  class="form-control"
                  id="ename"
                  name="ename"
                  placeholder="ename 입력 " />
        </div>
        <div class="mb-3">
            <label for="job" class="form-label">job</label>
            <input 
                    class="form-control"
                    id="job"
                  name="job"
                   placeholder="job 입력 " />
        </div>
        <div class="mb-3">
            <label for="manager" class="form-label">manager</label>
            <input 
                    class="form-control"
                    id="manager"
                  name="manager"
                   placeholder="manager 입력 " />
        </div>
        <div class="mb-3">
            <label for="hiredate" class="form-label">hiredate</label>
            <input 
                    class="form-control"
                    id="hiredate"
                    name="hiredate"
                   placeholder="hiredate 입력 " />
        </div>
        <div class="mb-3">
            <label for="salary" class="form-label">salary</label>
            <input 
                    class="form-control"
                    id="salary"
                    name="salary"
                   placeholder="salary 입력 " />
        </div>
        <div class="mb-3">
            <label for="commission" class="form-label">commission</label>
            <input 
                    class="form-control"
                    id="commission"
                    name="commission"
                   placeholder="commission 입력 " />
        </div>
        <div class="mb-3">
            <label for="dno" class="form-label">dno</label>
            <input 
                    class="form-control"
                    id="dno"
                    name="dno"
                   placeholder="dno 입력 " />
        </div>
        <div class="mb-3">
            <button class="btn btn-primary" onclick="fn_save()">저장</button>
        </div>
    </form>
</div>
<%--    꼬리말--%>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>

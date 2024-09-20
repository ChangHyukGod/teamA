<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>로그인 페이지</title>
</head>
<body>
   <%--    머리말--%>
   <jsp:include page="/common/header.jsp" />
   <div class="row justify-content-center">
      <div class="col-xl-10 col-lg-12 col-md-9">
         <div class="card mt-5">
            <div class="card-body p-0">
               <!-- {/* Nested Row within Card Body */} -->
               <div class="row">
                  <div class="col-lg-6">
<!--                   기본주소 : localhost:8000 변경시 찾아주는 코드 -->
                     <img src="${pageContext.request.contextPath}/resources/images/puppy-1920_1280_2.jpg" class="img-fluid">
                  </div>
                  <div class="col-lg-6">
                     <div class="p-5">
                        <div class="text-center">
                           <h1 class="h4 mb-4">Welcome Back!</h1>
                        </div>
                        <form class="user"
                        	action="/loginProcess"
                        	method="post"
                        >
                           <div class="form-group">
                              <input type="text" class="form-control form-control-user mb-3"
                              	id ="email"
                              	name ="email"
                                placeholder="이메일을 넣기" />
                           </div>
                           <div class="form-group">
                              <input type="password"
                                 class="form-control form-control-user mb-3"
                                 id = "password"
                                 name = "password"
                                 placeholder="패스워드 넣기"" />
                           </div>

                           <button class="btn btn-primary btn-user w-100 mb-3">
                              Login</button>
                        </form>
                        <hr />
                        <div class="text-center">
                           <a class="small" href="/register"> Create an Account! </a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <%--    꼬리말--%>
   <jsp:include page="/common/footer.jsp" />
</body>
</html>
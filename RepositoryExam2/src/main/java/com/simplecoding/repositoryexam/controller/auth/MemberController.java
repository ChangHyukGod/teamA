/**
 * 
 */
package com.simplecoding.repositoryexam.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplecoding.repositoryexam.service.auth.MemberService;
import com.simplecoding.repositoryexam.vo.auth.MemberVO;

import lombok.extern.log4j.Log4j;

/**
  * @fileName : MemberController.java
  * @author : KTE
  * @since : 2024. 9. 19. 
  * description : 로그인/회원가입/로그아웃
  */
@Log4j
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	// 로그인 화면
	@GetMapping("/login")
	public String loginView() {
		return "auth/login";
	}
	
//	회원가입 화면
	@GetMapping("/register")
	public String registerView() {
		return "auth/register";
	}
	
	// 로그인 진행 : 로그인 버튼 클릭시 실행 : 보안(post) get방식(id/password 노출)
	@PostMapping("/loginProcess")
	public String login(@ModelAttribute MemberVO loginVO,
						HttpServletRequest request
				)throws Exception{
		// 1) email/password 가지고 DB 에 정보가 있는지 확인 : 인증
		MemberVO memberVO = memberService.authenticateMember(loginVO);
		// 선택) 예외처리 : 회원이 없으면 없습니다.
		if(memberVO == null) {
			 throw new Exception("회원이 없습니다.");
		}
		// 2) 인증 OK(DB 에 유저가 있으면) : 세션에 email/password 넣기
		request.getSession().setAttribute("memberVO", memberVO);
		return "redirect:/"; // 첫페이지 강제 이동
	}
	
	// 로그아웃 메뉴 클릭시 실행
	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
//		1) 세션에 memberVO 객체 삭제
		httpSession.removeAttribute("memberVO");
//		2) 세션 무효화 실행
		httpSession.invalidate();
		return "redirect:/login";
	}
	
	// 회원가입 :
	@PostMapping("/register/addition")
	public String register(@ModelAttribute MemberVO memberVO) throws Exception {
		log.info("테스트 : " + memberVO);
//		1) 상세조회 해서 우리 DB에 있는 사람인지 확인 : 있으면 가입되어 있음(끝)
		MemberVO memberVO2 = memberService.authenticateMember(memberVO);
//		선택) 예외처리 : 우리 DB에 있는 사람인지 확인
		if(memberVO2 != null) {
			throw new Exception("이미 가입되었습니다.");
		}
//		2) 서비스 insert 함수 실행
		memberService.registerMember(memberVO);
		return "redirect:/";
	}
}

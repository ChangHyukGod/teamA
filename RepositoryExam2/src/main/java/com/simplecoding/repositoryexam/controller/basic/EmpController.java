/**
 * 
 */
package com.simplecoding.repositoryexam.controller.basic;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplecoding.repositoryexam.service.basic.EmpService;
import com.simplecoding.repositoryexam.vo.basic.EmpVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : EmpController.java
  * @author : KTE
  * @since : 2024. 9. 6. 
  * description :  연습 4) 컨트롤러 기능 추가, EmpSerivce 객체 정의,
  *                     전체조회 함수 작성 : (페이지 빼기), 
  *                           empService.전체조회실행
  *                           (model 담아 jsp 전송하고 ${} 출력
  *                     jsp : "basic/emp/emp_all"
  *                     (부서 참고 : Pag... 빼기 , searchVO 빼기
  *                              int totCot 빼기
  *   
  */
@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService; // 서비스 객체
	
//	전체 조회
	@GetMapping("/basic/emp")
	public String selectEmpList(
		@ModelAttribute("searchVO") Criteria searchVO,
		Model model) throws Exception{
//      TODO: 0) 페이징 변수에 설정 : 
      searchVO.setPageUnit(3); // 1페이지당 화면에 보이는 개수
      searchVO.setPageSize(2); // 페이지 번호를 보여줄 개수
      
//      TODO: 페이지 객체 생성
      PaginationInfo paginationInfo = new PaginationInfo();         // 페이징 객체
      paginationInfo.setCurrentPageNo(searchVO.getPageIndex());     // 현재 페이지 번호 저장
      paginationInfo.setRecordCountPerPage(searchVO.getPageUnit()); // 1페이지당 보일 게시물 개수
      paginationInfo.setPageSize(searchVO.getPageSize());           // 페이지 번호를 보여줄 개수
      
//      TODO: searchVO 객체 페이징 정보 저장
      searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());           // 첫페이지번호
      searchVO.setLastIndex(paginationInfo.getLastRecordIndex());             // 끝페이지번호
      searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage()); // 1페이지당 보일 게시물 개수

		
		
		
		
		List<?> emps = empService.selectEmptList(searchVO);
		model.addAttribute("emps",emps);
		
//      TODO: 3) 사원 테이블의 총개수(서비스 객체의 함수를 실행) : 페이지 객체 저장
      int totCnt = empService.selectEmpListTotCnt(searchVO);
      paginationInfo.setTotalRecordCount(totCnt);
//      TODO: 페이징 객체 -> jsp 전달
      model.addAttribute("paginationInfo", paginationInfo);
      
      return "basic/emp/emp_all";

	}
	
//	추가 페이지 열기 함수
   @GetMapping("/basic/emp/addition")
   public String createEmpView(Model model) {
	   return "basic/emp/add_emp";
   }
// 연습 2) emp 메뉴에 저장버튼 클릭 시 실행될 코드를 작성하세요
// 함수명 : createEmp
// url   : /basic/emp/add
// jsp   : redirect:/basic/emp
// 시퀀스  : SQ_EMP.NEXTVAL
// (부서 insert , 요약.txt 참고)
   @PostMapping("/basic/emp/add")
   public String createEmp(@ModelAttribute EmpVO empVO) throws Exception{
	  System.out.println(empVO);
	   empService.insertEmp(empVO);
	  
	  return "redirect:/basic/emp";
   }

// 연습 : emp 에 상세조회 기능을 작성하세요
// 함수명 : updateEmpView
// url : /basic/emp/edition
// jsp : basic/emp/update_emp
// jsp : emp_all.jsp 에서 js 함수 추가(a 태그 및 js함수(사원번호(eno)))
	@GetMapping("/basic/emp/edition")
	public String updateEmpView(@RequestParam int eno, Model model)
			throws Exception{
		EmpVO empVO = empService.selectEmp(eno);
		model.addAttribute("empVO", empVO);
		return "basic/emp/update_emp";
	}
//  연습 : 위의 updateEmpView() 함수에 서비스 상세조회함수를 실행해서
//  결과를 jsp 로 전송하고 화면에 출력하세요
//(mapper -> xml -> service -> serviceImpl -> controller -> jsp)
//	부서코드 참고, 요약.txt. 참고
	
//	수정 버튼 클릭시 수정하는 함수 :update
	@PostMapping("/basic/emp/edit")
	public String updateEmp(@RequestParam int eno,
							@ModelAttribute EmpVO empVO
							)throws Exception {
		empService.updateEmp(empVO);
		
		return "redirect:/basic/emp"; // 전체조회로 강제이동
	}
//  연습 : 컨트롤러 : deleteEmp()
//  url     : /basic/emp/delete
//  jsp     : redirect:/basic/emp
//  update_emp.jsp : fn_delete() js 함수 작성
//  매퍼     : delete 함수명 작성
//  Emp.xml : delete sql 작성
	@PostMapping("/basic/emp/delete")
	public String deleteEmp(@ModelAttribute EmpVO empVO) throws Exception {
		empService.deleteEmp(empVO);
		return "redirect:/basic/emp";
	}
	
}

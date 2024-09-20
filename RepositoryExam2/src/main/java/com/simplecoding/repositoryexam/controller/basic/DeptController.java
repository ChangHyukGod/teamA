/**
 * 
 */
package com.simplecoding.repositoryexam.controller.basic;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.simplecoding.repositoryexam.service.basic.DeptService;
import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.extern.log4j.Log4j;

/**
 * @fileName : DeptController.java
 * @author : KTE
 * @since : 2024. 9. 5. description :
 */
@Log4j
@Controller
public class DeptController {
//   역할 : 
//   1) 서비스 객체의 함수를 실행
//   2) jsp 결과를 전송
	@Autowired
	private DeptService deptService;
	
	   /** 유효성 체크 객체 */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

//   전체 조회 함수
	@GetMapping("/basic/dept")
	public String selectDeptList(@ModelAttribute("searchVO")
	Criteria searchVO, Model model) throws Exception {

//      0) 페이징 변수에 설정 : 
		searchVO.setPageUnit(3); // 1페이지당 화면에 보이는 개수
		searchVO.setPageSize(2); // 페이지 번호를 보여줄 개수

//      페이지 객체 생성
		PaginationInfo paginationInfo = new PaginationInfo(); // 페이징 객체
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex()); // 현재 페이지 번호 저장
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit()); // 1페이지당 보일 게시물 개수
		paginationInfo.setPageSize(searchVO.getPageSize()); // 페이지 번호를 보여줄 개수

//      searchVO 객체 페이징 정보 저장
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex()); // 첫페이지번호
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex()); // 끝페이지번호
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage()); // 1페이지당 보일 게시물 개수

//      1) 서비스 객체의 함수를 실행 : deptService.전체조회()
		List<?> depts = deptService.selectDeptList(searchVO);
//      2) 모델에 결과(depts) 담아 jsp 전송
		model.addAttribute("depts", depts);

//      3) 부서 테이블의 총개수(서비스 객체의 함수를 실행) : 페이지 객체 저장
		int totCnt = deptService.selectDeptListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
//      페이징 객체 -> jsp 전달
		model.addAttribute("paginationInfo", paginationInfo);

		return "basic/dept/dept_all";
	}

//	추가 페이지 열기 함수
	@GetMapping("/basic/dept/addition")
	public String createDeptView(Model model) {
//		유효성 객체 추가
		model.addAttribute("deptVO", new DeptVO());
		return "basic/dept/add_dept";
	}

// 저장 버튼 클릭시 실행 함수 : insert 실행 -> post 방식
//	TODO: 저장 버튼 클릭시 : 잘못 입력된 것을 체크(유효성)
	@PostMapping("/basic/dept/add")
	public String createDept(@ModelAttribute DeptVO deptVO, BindingResult bindingResult) throws Exception{

//		TODO: 유효성 체크
		beanValidator.validate(deptVO, bindingResult);
		
//		TODO: 2) 망걍 에러가 있으면 처리
		if(bindingResult.hasErrors()) {
			return "basic/dept/add_dept"; // 저장 안하고 다시 추가페이지 열기
		}
		
//      사용법 : log.info(변수);
		log.info("테스트" + deptVO);
//      1) 서비스의 함수 실행 : insert 함수
		deptService.insertDept(deptVO);

		
		return "redirect:/basic/dept"; // 전제조회 페이지로 강제이동
		
	}
	
// 상세조회 페이지 열기 :
	@GetMapping("/basic/dept/edition")	
	public String updateDeptView(@RequestParam int dno, Model model) 
			throws Exception {
//		1) deptService 의 상세조회 함수 실행
		DeptVO deptVO = deptService.selectDept(dno);
//		2) 모델에 담아 Jsp로 전송
		model.addAttribute("deptVO", deptVO);
		return "basic/dept/update_dept";
	}
//	수정 버튼 클릭시 수정하는 함수 : update 실행(dno, DeptVO)
//	jsp : 
	@PostMapping("/basic/dept/edit")
	public String updateDept(@RequestParam int dno,
							@ModelAttribute DeptVO deptVO
			) throws Exception{
//			1) deptService 의 update 함수 실행
		deptService.updateDept(deptVO);
//			2) 전체조회로 강제이동
		return "redirect:/basic/dept"; // 전체조회로 강제이동
	}
	
//	삭제 버튼 클릭시 실행 함수
//	insert/update/delete 기능 : post 방식, @PostMapping
	@PostMapping("/basic/dept/delete")
	public String deleteDept(@ModelAttribute DeptVO deptVO) throws Exception {
//		1) deptSerive 의 delete 함수 실행
		deptService.deleteDept(deptVO);
		return "redirect:/basic/dept"; // 2) 전체조회로 강제이동
	}
	
}

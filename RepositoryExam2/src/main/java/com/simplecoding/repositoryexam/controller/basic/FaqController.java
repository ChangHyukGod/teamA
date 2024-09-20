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

import com.simplecoding.repositoryexam.service.basic.FaqService;
import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.extern.log4j.Log4j;

/**
  * @fileName : FaqController.java
  * @author : KTE
  * @since : 2024. 9. 11. 
  * description :
  */
@Log4j
@Controller
public class FaqController {
	@Autowired
	private FaqService faqService;
	
	@GetMapping("/basic/faq")
	public String selectFaqList(@ModelAttribute("searchVO") 
	Criteria searchVO, Model model) throws Exception{
//  0) 페이징 변수에 설정 : 
	searchVO.setPageUnit(3); // 1페이지당 화면에 보이는 개수
	searchVO.setPageSize(2); // 페이지 번호를 보여줄 개수

//  페이지 객체 생성
	PaginationInfo paginationInfo = new PaginationInfo(); // 페이징 객체
	paginationInfo.setCurrentPageNo(searchVO.getPageIndex()); // 현재 페이지 번호 저장
	paginationInfo.setRecordCountPerPage(searchVO.getPageUnit()); // 1페이지당 보일 게시물 개수
	paginationInfo.setPageSize(searchVO.getPageSize()); // 페이지 번호를 보여줄 개수

//  searchVO 객체 페이징 정보 저장
	searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex()); // 첫페이지번호
	searchVO.setLastIndex(paginationInfo.getLastRecordIndex()); // 끝페이지번호
	searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage()); // 1페이지당 보일 게시물 개수


	List<?> faqs = faqService.selectFaqList(searchVO);

	model.addAttribute("faqs", faqs);


	int totCnt = faqService.selectFaqListTotCnt(searchVO);
	paginationInfo.setTotalRecordCount(totCnt);

	model.addAttribute("paginationInfo", paginationInfo);

	return "basic/faq/faq_all";
	}
	
	
}


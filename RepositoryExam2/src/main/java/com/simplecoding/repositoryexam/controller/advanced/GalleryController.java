/**
 * 
 */
package com.simplecoding.repositoryexam.controller.advanced;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.simplecoding.repositoryexam.service.advanced.GalleryService;
import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.advanced.GalleryVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : GalleryController.java
  * @author : KTE
  * @since : 2024. 9. 12. 
  * description :
  */
@Controller
public class GalleryController {
	
	@Autowired
	GalleryService galleryService;

//	전체조회
	@GetMapping("/advanced/gallery")
	public String selectGalleryList(@ModelAttribute("searchVO")
					Criteria searchVO,
					Model model
					)throws Exception {
		
//	     0) 페이징 변수에 설정 : 
			searchVO.setPageUnit(3); // 1페이지당 화면에 보이는 개수
			searchVO.setPageSize(2); // 페이지 번호를 보여줄 개수

//	     페이지 객체 생성
			PaginationInfo paginationInfo = new PaginationInfo(); // 페이징 객체
			paginationInfo.setCurrentPageNo(searchVO.getPageIndex()); // 현재 페이지 번호 저장
			paginationInfo.setRecordCountPerPage(searchVO.getPageUnit()); // 1페이지당 보일 게시물 개수
			paginationInfo.setPageSize(searchVO.getPageSize()); // 페이지 번호를 보여줄 개수

//	     searchVO 객체 페이징 정보 저장
			searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex()); // 첫페이지번호
			searchVO.setLastIndex(paginationInfo.getLastRecordIndex()); // 끝페이지번호
			searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage()); // 1페이지당 보일 게시물 개수
		
//	     1) fileDbService 의 전체조회 함수 실행
		List<?> gallerys = galleryService.selectGalleryList(searchVO);
		model.addAttribute("gallerys", gallerys);

//		3) FileDB 테이블의 총개수(서비스 객체의 함수를 실행) : 페이지 객체 저장
		int totCnt = galleryService.selectGalleryListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		
//      페이징 객체 -> jsp 전달
		model.addAttribute("paginationInfo", paginationInfo);
		
		
		return "advanced/gallery/gallery_all";
	}
	
	@GetMapping("/advanced/gallery/addition")
	public String createFileDbView() {
		return "advanced/gallery/add_gallery";
	}
	
//  저장 버튼 클릭시 실행 :
  @PostMapping("/advanced/gallery/add")
  public String createGallery(@RequestParam(defaultValue = "") String galleryTitle,
                    @RequestParam(required = false) MultipartFile image
        ) throws Exception {
//     0) 생성자 실행 : 
     GalleryVO galleryVO = new GalleryVO(galleryTitle, image.getBytes());
//     1) fileDbService 의 insert(객체) 함수 실행
     galleryService.insertGallery(galleryVO);
     return "redirect:/advanced/gallery"; // 전체조회 강제이동
  }
}

/**
 * 
 */
package com.simplecoding.repositoryexam.controller.advanced;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.simplecoding.repositoryexam.service.advanced.FileDbService;
import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.extern.log4j.Log4j;

/**
 * @fileName : FileDbController.java
 * @author : KTE
 * @since : 2024. 9. 11. description :
 */
@Log4j
@Controller
public class FileDbController {

	@Autowired
	FileDbService fileDbService; // 서비스 객체

//   전체 조회 : 
	@GetMapping("/advanced/fileDb")
	public String selectFileDbList(@ModelAttribute("searchVO") Criteria searchVO, Model model) throws Exception {

//     0) 페이징 변수에 설정 : 
		searchVO.setPageUnit(3); // 1페이지당 화면에 보이는 개수
		searchVO.setPageSize(2); // 페이지 번호를 보여줄 개수

//     페이지 객체 생성
		PaginationInfo paginationInfo = new PaginationInfo(); // 페이징 객체
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex()); // 현재 페이지 번호 저장
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit()); // 1페이지당 보일 게시물 개수
		paginationInfo.setPageSize(searchVO.getPageSize()); // 페이지 번호를 보여줄 개수

//     searchVO 객체 페이징 정보 저장
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex()); // 첫페이지번호
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex()); // 끝페이지번호
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage()); // 1페이지당 보일 게시물 개수

//      1) fileDbService 의 전체조회 함수 실행
		List<?> fileDBs = fileDbService.selectFileDbList(searchVO);
		model.addAttribute("fileDBs", fileDBs);

//		3) FileDB 테이블의 총개수(서비스 객체의 함수를 실행) : 페이지 객체 저장
		int totCnt = fileDbService.selectFileDbListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
//      페이징 객체 -> jsp 전달
		model.addAttribute("paginationInfo", paginationInfo);

		return "advanced/fileDb/fileDb_all";
	}

//	추가 페이지 열기 :
	@GetMapping("/advanced/fileDb/addition")
	public String createFileDbView() {
		return "advanced/fileDb/add_fileDb";
	}

//  저장 버튼 클릭시 실행 :
	@PostMapping("/advanced/fileDb/add")
	public String createFileDb(@RequestParam(defaultValue = "") String fileTitle,
			@RequestParam(defaultValue = "") String fileContent, @RequestParam(required = false) MultipartFile image)
			throws Exception {
//	  0) 생성자 실행 : 
		FileDbVO fileDbVO = new FileDbVO(fileTitle, fileContent, image.getBytes());
//	  1) fileDbService 의 insert(객체) 함수 실행
		fileDbService.insertFileDb(fileDbVO);
		return "redirect:/advanced/fileDb"; // 전체조회 강제이동
	}

//  상세조회 + 첨부파일 전송(jsp) : byte[] 형태로 전송 : @ResponseBody
//  복습 : /fileDb/{uuid} : 파라메터 방식 @PathVariable 사용
	@GetMapping("/advanced/fileDb/{uuid}")
	@ResponseBody
	public ResponseEntity<byte[]> findDownload(@PathVariable String uuid) throws Exception {
//     1) 상세조회 : 객체받기(첨부파일)
		FileDbVO fileDbVO = fileDbService.selectFileDb(uuid);

//     2) 첨부파일 jsp 전송 : 규격대로 전송(코딩 보냄)
		// 첨부파일 다운로드 응답 생성
		HttpHeaders headers = new HttpHeaders(); // html 문서 객체(머리말)
		headers.setContentDispositionFormData("attachment", fileDbVO.getUuid()); // 첨부파일(문서형태)
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // 첨부파일2(문서형태)

//      첨부파일 전송 + OK 신호 보냄
		return new ResponseEntity<byte[]>(fileDbVO.getFileData(), headers, HttpStatus.OK);
	}
	
//	삭제함수 : post 방식, uuid(기본키)
	@PostMapping("/advanced/fileDb/delete")
	public String deleteFileDb(@RequestParam(defaultValue="")String uuid) 
								throws Exception{
		log.info("테스트: " +uuid);
//		서비스의 삭제함수 실행 : 
		fileDbService.deleteFileDb(uuid);
		return "redirect:/advanced/fileDb"; // 전체조회 강제이동
	}

}

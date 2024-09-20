/**
 * 
 */
package com.simplecoding.repositoryexam.service.advanced;

import java.util.List;

import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : FileDbService.java
  * @author : KTE
  * @since : 2024. 9. 12. 
  * description :
  */
public interface FileDbService {
	   List<?> selectFileDbList(Criteria searchVO) throws Exception; // 전체조회
	   int selectFileDbListTotCnt(Criteria searchVO);                // 총개수
	   void insertFileDb(FileDbVO fileDbVO) throws Exception;        // insert 함수
	   FileDbVO selectFileDb(String uuid) throws Exception;          // 상세조회 함수
	   void deleteFileDb(String uuid) throws Exception;              // delete 함수
	}


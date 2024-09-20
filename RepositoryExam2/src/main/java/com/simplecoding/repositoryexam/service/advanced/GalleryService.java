/**
 * 
 */
package com.simplecoding.repositoryexam.service.advanced;

import java.util.List;

import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.advanced.GalleryVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : GalleryService.java
  * @author : KTE
  * @since : 2024. 9. 12. 
  * description :  * 
  * 				연습) insertGallery 함수 작성,
  *                  자식(GalleryServiceImpl)에 새uuid, 
  *                  새url(generateDownloadUrl() 함수 이용) 있는
  *                  insertGallery 함수 재정의 하기
  *                  (FileDbService, FileDbServiceImpl 참고)

  */
public interface GalleryService {
	List<?> selectGalleryList(Criteria searchVO) throws Exception;
	int selectGalleryListTotCnt(Criteria searchVO);
	void insertGallery(GalleryVO galleryVO) throws Exception; 
	
}

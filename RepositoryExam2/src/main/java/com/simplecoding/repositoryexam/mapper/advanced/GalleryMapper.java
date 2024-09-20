/**
 * 
 */
package com.simplecoding.repositoryexam.mapper.advanced;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.advanced.GalleryVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : GalleryMapper.java
  * @author : KTE
  * @since : 2024. 9. 12. 
  * description :
  */
@Mapper
public interface GalleryMapper {
	// 연습 : 전체조회 함수명 추가 , Gallery.xml 에서 전체조회 sql 문을 작성
	//  (selectGalleryList, FileDb 참고(리턴자료형, 매개변수는 동일))
//	별명 : sql-mapper-config.xml (별명추가)
	public List<?> selectGalleryList(Criteria searchVO);
	public int selectGalleryListTotCnt(Criteria searchVO);
	public int insert(GalleryVO galleryVO);
	public GalleryVO selectGallery(String uuid);
	
}

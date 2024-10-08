/**
 * 
 */
package com.simplecoding.repositoryexam.mapper.advanced;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : FileDbMapper.java
  * @author : KTE
  * @since : 2024. 9. 12. 
  * description :
  */
@Mapper
public interface FileDbMapper {
	public List<?> selectFileDbList(Criteria searchVO); 	// 전체조회 함수
	public int selectFileDbListTotCnt(Criteria searchVO); 	// 테이블 총개수 함수
	public int insert(FileDbVO fileDbVO);					//insert 함수
	public FileDbVO selectFileDb(String  uuid);				//상세조회 함수
	public int delete(String uuid);							// 삭제 함수
}

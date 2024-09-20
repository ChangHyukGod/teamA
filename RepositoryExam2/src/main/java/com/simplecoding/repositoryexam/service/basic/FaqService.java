/**
 * 
 */
package com.simplecoding.repositoryexam.service.basic;

import java.util.List;

import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : FaqService.java
  * @author : KTE
  * @since : 2024. 9. 11. 
  * description :
  */
public interface FaqService {
	List<?> selectFaqList(Criteria searchVO) throws Exception;
	int selectFaqListTotCnt(Criteria searchVO); 
}

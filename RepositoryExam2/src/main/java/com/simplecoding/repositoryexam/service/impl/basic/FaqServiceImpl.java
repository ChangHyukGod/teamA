/**
 * 
 */
package com.simplecoding.repositoryexam.service.impl.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.simplecoding.repositoryexam.mapper.basic.FaqMapper;
import com.simplecoding.repositoryexam.service.basic.FaqService;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : FaqServiceImpl.java
  * @author : KTE
  * @since : 2024. 9. 11. 
  * description :
  */
@Service
public class FaqServiceImpl implements FaqService {
	
	@Autowired
	private FaqMapper faqMapper;
	
	@Override
	public List<?> selectFaqList(Criteria searchVO) throws Exception {
		// TODO Auto-generated method stub
		return faqMapper.selectFaqList(searchVO);
	}
	@Override
	public int selectFaqListTotCnt(Criteria searchVO) {
		// TODO Auto-generated method stub
		return faqMapper.selectFaqListTotCnt(searchVO);
	}


}

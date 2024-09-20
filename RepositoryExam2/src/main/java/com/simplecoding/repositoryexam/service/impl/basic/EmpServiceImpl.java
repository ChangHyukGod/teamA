/**
 * 
 */
package com.simplecoding.repositoryexam.service.impl.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.simplecoding.repositoryexam.mapper.basic.EmpMapper;
import com.simplecoding.repositoryexam.service.basic.EmpService;
import com.simplecoding.repositoryexam.vo.basic.EmpVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : EmpServiceImpl.java
  * @author : KTE
  * @since : 2024. 9. 6. 
  * description :
  */
@Service
public class EmpServiceImpl implements EmpService{
	

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public List<?> selectEmptList(Criteria searchVO) throws Exception {
		// TODO Auto-generated method stub
		return empMapper.selectEmpList(searchVO);
	}
	
	@Override
	public int selectEmpListTotCnt(Criteria searchVO) {
		// TODO Auto-generated method stub
		return empMapper.selectEmpListTotCnt(searchVO);
	}

	@Override
	public void insertEmp(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		empMapper.insert(empVO);
	}

	@Override
	public EmpVO selectEmp(int eno) throws Exception {
		// TODO Auto-generated method stub
		EmpVO empVO = empMapper.selectEmp(eno);
		return empVO;
	}

	@Override
	public void updateEmp(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		empMapper.update(empVO);
	}

	@Override
	public void deleteEmp(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		empMapper.delete(empVO);
	}
	
	
	

}

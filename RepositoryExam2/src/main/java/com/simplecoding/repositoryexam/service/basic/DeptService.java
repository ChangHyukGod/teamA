/**
 * 
 */
package com.simplecoding.repositoryexam.service.basic;

import java.util.List;

import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : DeptService.java
  * @author : KTE
  * @since : 2024. 9. 5. 
  * description :
  */
public interface DeptService {
	// 전체조회 (페이징기능,검색어)
	List<?> selectDeptList(Criteria searchVO) throws Exception;
	int selectDeptListTotCnt(Criteria searchVO); // 개수 세기 
	void insertDept(DeptVO deptVO) throws Exception; // insert 함수
	DeptVO selectDept(int dno) throws Exception;	// 상세 조회
	void updateDept(DeptVO deptVO) throws Exception; // update 함수
	void deleteDept(DeptVO deptVO) throws Exception; // delete 함수
	
	
}











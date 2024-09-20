/**
 * 
 */
package com.simplecoding.repositoryexam.service.basic;

import java.util.List;


import com.simplecoding.repositoryexam.vo.basic.EmpVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : EmpService.java
  * @author : KTE
  * @since : 2024. 9. 6. 
  * description : (연습 3) 전체조회 함수를 추가하고,
  *   자식클래스 : EmpServiceImpl 에서 함수재정의 및 empMapper.전체조회함수를 실행하세요
  *    (부서 참고해서 매개변수 및 리턴값은 동일하게 하세요)
  */
public interface EmpService {
	List<?> selectEmptList(Criteria searchVO) throws Exception;
	int selectEmpListTotCnt(Criteria searchVO); // 개수 세기
	void insertEmp(EmpVO empVO) throws Exception;
	EmpVO selectEmp(int eno) throws Exception; 	// 상세 조회
	void updateEmp(EmpVO empVO) throws Exception;
	void deleteEmp(EmpVO empVO) throws Exception;
	
}

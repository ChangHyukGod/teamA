/**
 * 
 */
package com.simplecoding.repositoryexam.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.basic.EmpVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : EmpMapper.java
  * @author : KTE
  * @since : 2024. 9. 6. 
  * description : (연습 1) DeptMapper 참고해서
  * 				전체조회 함수 : selectEmpList, 매개변수(Criteria searchVO)
  * 					결과 : List<?>
  */
@Mapper
public interface EmpMapper {
	public List<?> selectEmpList(Criteria searchVO); // 전체 조회 : 페이징 기능 추가
	public int selectEmpListTotCnt(Criteria searchVO); // 개수 세기
	public int insert(EmpVO empVO);
	public EmpVO selectEmp(int dno);
//	연습 ) update 함수 작성 및 sql 작성하세요 (EmpMapper, Emp.xml)
	public int update(EmpVO empVO);
	public int delete(EmpVO empVO);
}

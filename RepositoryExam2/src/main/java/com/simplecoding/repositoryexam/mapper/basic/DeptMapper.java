/**
 * 
 */
package com.simplecoding.repositoryexam.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : DeptMapper.java
  * @author : KTE
  * @since : 2024. 9. 5. 
  * description : SQL 문 연결된 인터페이스, CRUD 함수이름 작성
  * spring => sql 작성
      DeptMapper : 함수 이름 (인터페이스)
      => java 작성하면 가독성 안좋음
          "select * from " + ""
      => html 확장한 xml 파일로 작성함: 
          (mybatis 프레임워크 : 자식클래스 역할)
           select * from department
      공홈 : https://mybatis.org/mybatis-3/ko/
  */
@Mapper
public interface DeptMapper {
   public List<?> selectDeptList(Criteria searchVO);   // 전체 조회 : 페이징 기능 추가
   public int selectDeptListTotCnt(Criteria searchVO); // 개수 세기 
   public int insert(DeptVO deptVO);                   // insert 함수
   public DeptVO selectDept(int dno);					//상세조회 함수
   public int update(DeptVO deptVO);					//update 함수
   public int delete(DeptVO deptVO);					// delete 함수

}







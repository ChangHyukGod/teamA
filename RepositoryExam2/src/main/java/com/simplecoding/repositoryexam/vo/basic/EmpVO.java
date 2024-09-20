/**
 * 
 */
package com.simplecoding.repositoryexam.vo.basic;

import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
  * @fileName : EmpVO.java
  * @author : KTE
  * @since : 2024. 9. 5. 
  * description : 
  *   연습 : TB_EMP 테이블과 동일한 VO, 속성/생성자/setter/getter
  *        공통컬럼 상속(생성일시/수정일시)
  *       (schema.sql, sql-develop 의 테이블 참고)
  */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuppressWarnings("serial")
public class EmpVO extends Criteria {
	private int eno;            // 사원번호(기본키)
	private String ename;       // 사원명
	private String job;         // 직위
	private int manager;        // 관리자 사원번호
	private String hiredate;    // 입사일
	private int salary;         // 급여
	private int commission;     // 상여금
	private int dno;            // 부서번호
}

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
  * @fileName : DeptVO.java
  * @author : KTE
  * @since : 2024. 9. 5. 
  * description :
  *   코딩 순서 : vo -> mapper -> service -> controller -> jsp
  *   vo : table 똑같이 생긴 자바 파일 
  *   vo 객체 1개 == 테이블의 1행
  *   => 테이블 1건의 정보를 그대로 저장하는 곳
  *   //	속성 없는 생성자 :== 어노테이션 : @NoArgsConstructor
      //	속성 모두 있는 생성자 : == 어노테이션 : @AllArgsConstructor
      //	setter/getter : source == 어노테이션 : @Setter, @Getter
      //	(참고) 객체 출력(디버깅) : TO-String() 재정의 == 어노테이션 : 
  */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuppressWarnings("serial")
public class DeptVO extends Criteria {
//	클래스의 3요소 : 속성(필드), 생성자, 함수(Setter/Getter)
	private int dno;           // 부서번호(기본키)
	private String dname;      // 부서명
	private String loc;        // 부서위치
}







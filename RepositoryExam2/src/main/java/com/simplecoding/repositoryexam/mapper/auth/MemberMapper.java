/**
 * 
 */
package com.simplecoding.repositoryexam.mapper.auth;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.auth.MemberVO;

/**
  * @fileName : MemberMapper.java
  * @author : KTE
  * @since : 2024. 9. 19. 
  * description :
  */
@Mapper
public interface MemberMapper {
	public MemberVO authenticate(MemberVO memberVO); // 상세조회(인증)
	public void register(MemberVO memberVO);		// insert 함수
}

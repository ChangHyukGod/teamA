/**
 * 
 */
package com.simplecoding.repositoryexam.service.auth;

import com.simplecoding.repositoryexam.vo.auth.MemberVO;

/**
  * @fileName : MemberService.java
  * @author : KTE
  * @since : 2024. 9. 19. 
  * description :
  */
public interface MemberService {
	public MemberVO authenticateMember(MemberVO memberVO) throws Exception; // 상세 조회
	public void registerMember(MemberVO memberVO) throws Exception;
}

/**
 * 
 */
package com.simplecoding.repositoryexam.vo.auth;

import org.springframework.web.multipart.MultipartFile;

import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
  * @fileName : MemberVO.java
  * @author : KTE
  * @since : 2024. 9. 19. 
  * description :
  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuppressWarnings("serial")
public class MemberVO extends Criteria {
//	EMAIL
//	PASSWORD
//	NAME
	private String email;
	private String password;
	private String name;
}

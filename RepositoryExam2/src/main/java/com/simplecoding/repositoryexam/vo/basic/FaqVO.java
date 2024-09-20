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
  * @fileName : FaqVO.java
  * @author : KTE
  * @since : 2024. 9. 11. 
  * description :
  */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuppressWarnings("serial")
public class FaqVO extends Criteria{
	private int fno;
	private String title;
	private String content;
}

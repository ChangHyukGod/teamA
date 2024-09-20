package com.simplecoding.repositoryexam.vo.advanced;

import org.springframework.web.multipart.MultipartFile;

import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @fileName : FileDbVO.java
 * @author : KTE
 * @since : 2024. 9. 5. description : VO (속성필드 , 생성자, setter/getter)
 * @NoArgsConstructor : 매개변수 없는 생성자
 * @AllArgsConstructor : 모든 매개변수 있는 생성자
 * @Setter : setter 함수
 * @Getter : getter 함수
 * @ToString : toString 함수 재정의 @SuppressWarnings("serial") : (참고)상속시 serial 있는
 *           클래스일때 경고 발생 , 위의 경고를 표시안하게 하는 어노테이션
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class FileDbVO extends Criteria {
//   주석 단축키 : ctrl + shift + c
	private String uuid; // 기본키
	private String fileTitle; // 제목
	private String fileContent; // 내용
	private byte[] fileData; // 이미지파일
	private MultipartFile image; // 내부적 사용(이미지파일)
	private String fileUrl; // 다운로드 url(클릭:이미지 다운로드됨)

// 추가 : (필요) 생성자 2개 : source - xxxconstrutor
// 매개변수 4개짜리 생성자 : uuid, fileTitle, fileContent, fileData
	public FileDbVO(String uuid, String fileTitle, String fileContent, MultipartFile image) {
		this.uuid = uuid;
		this.fileTitle = fileTitle;
		this.fileContent = fileContent;
		this.image = image;
	}

// 매개변수 3개짜리 생성자 : fileTitle, fileContent, fileData
	public FileDbVO(String fileTitle, String fileContent, byte[] fileData) {
		this.fileTitle = fileTitle;
		this.fileContent = fileContent;
		this.fileData = fileData;
	}

}

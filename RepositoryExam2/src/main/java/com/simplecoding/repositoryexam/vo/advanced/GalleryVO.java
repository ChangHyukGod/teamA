/**
 * 
 */
package com.simplecoding.repositoryexam.vo.advanced;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @fileName : GalleryVO.java
 * @author : KTE
 * @since : 2024. 9. 12. description : 연습 : 테이블을(TB_GALLERY) 참고해서 VO 객체 만드세요 (샘플
 *        : FileDbVO 참고)
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class GalleryVO {
//	UUID	VARCHAR2(1000 BYTE)
//	GALLERY_TITLE	VARCHAR2(1000 BYTE)
//	GALLERY_DATA	BLOB
//	GALLERY_FILE_URL	VARCHAR2(1000 BYTE)
	private String uuid; // 기본키
	private String galleryTitle; // 제목
	private byte[] galleryData; // 내용
	private MultipartFile image; // 내부적 사용(이미지파일)
	private String galleryFileUrl; // 이미지파일

	public GalleryVO(String galleryTitle, byte[] galleryData) {
		this.galleryTitle = galleryTitle;
		this.galleryData = galleryData;
	}

	public GalleryVO(String uuid, String galleryTitle, byte[] galleryData) {
		this.uuid = uuid;
		this.galleryTitle = galleryTitle;
		this.galleryData = galleryData;
	}

}
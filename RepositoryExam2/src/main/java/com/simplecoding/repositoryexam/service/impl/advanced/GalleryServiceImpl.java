/**
 * 
 */
package com.simplecoding.repositoryexam.service.impl.advanced;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplecoding.repositoryexam.mapper.advanced.GalleryMapper;
import com.simplecoding.repositoryexam.service.advanced.GalleryService;
import com.simplecoding.repositoryexam.vo.advanced.GalleryVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : GalleryServiceImpl.java
  * @author : KTE
  * @since : 2024. 9. 12. 
  * description :
  */
@Service
public class GalleryServiceImpl implements GalleryService {
   
   @Autowired
   GalleryMapper galleryMapper; // 매퍼 객체

//   전체 조회 : source
   @Override
   public List<?> selectGalleryList(Criteria searchVO) throws Exception {
      // TODO galleryMapper 의 전체 조회 함수 실행
      return galleryMapper.selectGalleryList(searchVO);
   }
   
//   총개수 : source
   @Override
   public int selectGalleryListTotCnt(Criteria searchVO) {
      // TODO galleryMapper 의 총개수 함수 실행
      return galleryMapper.selectGalleryListTotCnt(searchVO);
   }
   
//   insert : source - Over...
   @Override
   public void insertGallery(GalleryVO galleryVO) throws Exception {
      // TODO galleryMapper 의 insert 함수 실행 + 업무로직
          String newUuid = UUID.randomUUID().toString(); // 새 uuid
          String fileDownloadURL = generateDownloadUrl(newUuid);
          galleryVO.setUuid(newUuid);
          galleryVO.setGalleryFileUrl(fileDownloadURL);
          
          galleryMapper.insert(galleryVO);
   }
   
//   첨부파일 다운로드 url 자동 생성 해주는 함수
   public String generateDownloadUrl(String uuid) {
        return ServletUriComponentsBuilder // url 만들어 주는 자바 객체
          .fromCurrentContextPath()   // spring 기본주소 제공 : http://localhost:8000
          .path("/advanced/gallery/") // /advanced/gallery
          .path(uuid)                // /uuid
          .toUriString();            // 위의 것을 모두 조합 : [1] url 완성됨
   }
}







package com.dogfeetbirdfeet.ivorypilatesbackend.mapper.class_packages;

import com.dogfeetbirdfeet.ivorypilatesbackend.dto.enums.YN;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.schema.ClsPkg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassPackgesMapper {
    /**
     * 회차별 상품목록 조회
     * @author swo
     * @param clsPkgNm 상품명
     * @param useYn 사용여부
     * @return 회차별 상품목록
     */
    List<ClsPkg> getClassPackages(String clsPkgNm, YN useYn);

    /**
     * 회차상품 상세조회
     * @author swo
     * @param clsPkgId 회차상품ID
     * @return 회차상품 상세조회
     */
    ClsPkg getClassPackageDetail(Long clsPkgId);

    /**
     * 회차상품 등록
     * @author SWO
     * @param clsPkg 회차별 상품
     * @param userId 등록유저ID
     * @return int
     */
    int insertClsPkg(@Param("clsPkg") ClsPkg clsPkg, @Param("userId") String userId);

    /**
     * 회차상품 수정
     * @author SWO
     * @param clsPkg 회차별 상품
     * @param userId 등록유저ID
     * @return int
     */
    int updateClsPkg(@Param("clsPkg") ClsPkg clsPkg, @Param("userId") String userId);

}

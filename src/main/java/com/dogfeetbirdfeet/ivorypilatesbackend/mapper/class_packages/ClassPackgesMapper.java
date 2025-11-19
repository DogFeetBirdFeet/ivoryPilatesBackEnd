package com.dogfeetbirdfeet.ivorypilatesbackend.mapper.class_packages;

import com.dogfeetbirdfeet.ivorypilatesbackend.dto.enums.YN;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.schema.ClsPkg;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.searchdto.CusSearchDto;

import java.util.List;

public interface ClassPackgesMapper {
    /**
     * 회차별 상품목록 조회
     *
     * @author swo
     * @return 회차별 상품목록
     */
    List<ClsPkg> getClassPackages(String clsPkgNm, YN useYn);
}

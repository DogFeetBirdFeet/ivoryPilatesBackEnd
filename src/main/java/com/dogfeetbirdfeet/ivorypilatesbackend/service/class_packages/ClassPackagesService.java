package com.dogfeetbirdfeet.ivorypilatesbackend.service.class_packages;

import com.dogfeetbirdfeet.ivorypilatesbackend.component.util.commonmethod.CommonMethod;
import com.dogfeetbirdfeet.ivorypilatesbackend.component.util.maker.ServiceResult;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.enums.ResponseMsg;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.enums.YN;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.schema.ClsPkg;
import com.dogfeetbirdfeet.ivorypilatesbackend.mapper.class_packages.ClassPackgesMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassPackagesService {

    private final ClassPackgesMapper classPackgesMapper;

    /* 공통응답처리 객체 */
    private static final CommonMethod commonMethod = new CommonMethod();

    public ClassPackagesService(ClassPackgesMapper classPackgesMapper){
        this.classPackgesMapper = classPackgesMapper;
    }

    /**
     * 회차별 상품목록 조회
     * @author swo
     * @param clsPkgNm 상품명
     * @param useYn 사용여부
     * @return 회차별 상품목록
     */
    public List<ClsPkg> getClassPackages(@Param("clsPkgNm") String clsPkgNm, @Param("useYn") YN useYn) {
        return classPackgesMapper.getClassPackages(clsPkgNm, useYn);
    }

    /**
     * 회차상품 상세조회
     * @author swo
     * @param clsPkgId 회차상품ID
     * @return 회차상품 상세조회
     */
    public ClsPkg getClassPackageDetail(@Param("clsPkgId") Long clsPkgId) {
        return classPackgesMapper.getClassPackageDetail(clsPkgId);
    }

    /**
     * 회차상품 등록
     * @author SWO
     * @param clsPkg 회차별 상품
     * @param userId 등록유저ID
     * @return 회차상품 정보
     */
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult<List<ClsPkg>> insertClsPkg(ClsPkg clsPkg, String userId) {

        ResponseMsg fsMsg = commonMethod.returnResultByResponseMsg(classPackgesMapper.insertClsPkg(clsPkg, userId));

        if (!fsMsg.equals(ResponseMsg.ON_SUCCESS)) {
            return ServiceResult.failure(fsMsg);
        }

        return ServiceResult.success(() -> getClassPackages(null, null));
    }

    /**
     * 회차상품 수정
     * @author SWO
     * @param clsPkg 회차별 상품
     * @param userId 등록유저ID
     * @return 수정된 회차상품 상세정보
     */
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult<ClsPkg> updateClsPkg(ClsPkg clsPkg, String userId) {

        ResponseMsg fsMsg = commonMethod.returnResultByResponseMsg(classPackgesMapper.updateClsPkg(clsPkg, userId));

        if (!fsMsg.equals(ResponseMsg.ON_SUCCESS)) {
            return ServiceResult.failure(fsMsg);
        }

        return ServiceResult.success(() -> getClassPackageDetail(clsPkg.getClsPkgId()));
    }
}

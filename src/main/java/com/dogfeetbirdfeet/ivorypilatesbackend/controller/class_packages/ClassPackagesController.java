package com.dogfeetbirdfeet.ivorypilatesbackend.controller.class_packages;

import com.dogfeetbirdfeet.ivorypilatesbackend.component.util.commonmethod.CommonMethod;
import com.dogfeetbirdfeet.ivorypilatesbackend.component.util.maker.ApiResponse;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.enums.YN;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.schema.ClsPkg;
import com.dogfeetbirdfeet.ivorypilatesbackend.service.class_packages.ClassPackagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classPackages")
public class ClassPackagesController {

    private final ClassPackagesService classPackagesService;
    
    /* 공통응답처리 객체 */
    private static final CommonMethod commonMethod = new CommonMethod();
    
    public ClassPackagesController(ClassPackagesService classPackagesService){
        this.classPackagesService = classPackagesService;
    }

    /**
     * 회차별 상품목록 조회
     * @author swo
     * @param clsPkgNm 상품명
     * @param useYn 사용여부
     * @return 회차별 상품목록
     */
    @GetMapping()
    public ResponseEntity<List<ClsPkg>> getClassPackages(@RequestParam String clsPkgNm, @RequestParam YN useYn) {
        return ResponseEntity.ok(classPackagesService.getClassPackages(clsPkgNm, useYn));
    }

    /**
     * 회차상품 상세조회
     * @author swo
     * @param clsPkgId 회차상품ID
     * @return 회차상품 상세조회
     */
    @GetMapping("/detail")
    public ResponseEntity<ClsPkg> getClassPackageDetail(@RequestParam Long clsPkgId) {
        return ResponseEntity.ok(classPackagesService.getClassPackageDetail(clsPkgId));
    }

    /**
     * 회차상품 목록검색
     * @author SWO
     * @param clsPkgNm 회차상품명
     * @return 회차상품 목록
     */
    @GetMapping("/search")
    public ResponseEntity<List<ClsPkg>> getClassPackagesSearch(@RequestParam String clsPkgNm) {
        return ResponseEntity.ok(classPackagesService.getClassPackages(clsPkgNm, null));
    }

    /**
     * 회차상품 등록
     * @author SWO
     * @param clsPkg 회차별 상품
     * @param userId 등록유저ID
     * @return 회차상품 목록
     */
    @PostMapping()
    public ResponseEntity<ApiResponse<List<ClsPkg>>> insertClsPkg(@RequestBody ClsPkg clsPkg, @RequestParam String userId) {
        return commonMethod.responseTransaction(classPackagesService.insertClsPkg(clsPkg, userId));
    }

    /**
     * 회차상품 수정
     * @author SWO
     * @param clsPkg 회차별 상품
     * @param userId 등록유저ID
     * @return 수정된 회차상품 상세정보
     */
    @PutMapping()
    public ResponseEntity<ApiResponse<ClsPkg>> updateClsPkg(@RequestBody ClsPkg clsPkg, @RequestParam String userId) {
        return commonMethod.responseTransaction(classPackagesService.updateClsPkg(clsPkg, userId));
    }
}

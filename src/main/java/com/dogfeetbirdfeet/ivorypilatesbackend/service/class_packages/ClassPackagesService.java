package com.dogfeetbirdfeet.ivorypilatesbackend.service.class_packages;

import com.dogfeetbirdfeet.ivorypilatesbackend.dto.enums.YN;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.schema.ClsPkg;
import com.dogfeetbirdfeet.ivorypilatesbackend.mapper.class_packages.ClassPackgesMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassPackagesService {

    private final ClassPackgesMapper classPackgesMapper;

    public ClassPackagesService(ClassPackgesMapper classPackgesMapper){
        this.classPackgesMapper = classPackgesMapper;
    }

    public List<ClsPkg> getClassPackages(@Param("clsPkgNm") String clsPkgNm, @Param("useYn") YN useYn) {
        return classPackgesMapper.getClassPackages(clsPkgNm, useYn);
    }

}

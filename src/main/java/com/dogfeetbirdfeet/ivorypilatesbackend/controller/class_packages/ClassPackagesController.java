package com.dogfeetbirdfeet.ivorypilatesbackend.controller.class_packages;

import com.dogfeetbirdfeet.ivorypilatesbackend.dto.enums.YN;
import com.dogfeetbirdfeet.ivorypilatesbackend.dto.schema.ClsPkg;
import com.dogfeetbirdfeet.ivorypilatesbackend.service.class_packages.ClassPackagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classPackages")
public class ClassPackagesController {

    private final ClassPackagesService classPackagesService;

    public ClassPackagesController(ClassPackagesService classPackagesService){
        this.classPackagesService = classPackagesService;
    }

    @GetMapping
    public ResponseEntity<List<ClsPkg>> getClassPackages(@RequestParam String clsPkgNm, @RequestParam YN useYn) {
        return ResponseEntity.ok(classPackagesService.getClassPackages(clsPkgNm, useYn));
    }

}

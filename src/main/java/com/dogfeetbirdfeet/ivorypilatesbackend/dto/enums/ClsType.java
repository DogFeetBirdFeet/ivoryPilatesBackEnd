package com.dogfeetbirdfeet.ivorypilatesbackend.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClsType {

    IOI("IOI", "1:1"),
    TIO("TIO", "2:1");

    private final String key;
    private final String value;
}

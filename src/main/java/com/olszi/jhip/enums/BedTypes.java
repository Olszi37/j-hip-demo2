package com.olszi.jhip.enums;

import com.google.common.collect.Lists;

import java.util.List;

public enum BedTypes {
    SINGLE, DOUBLE, STORIED;

    public static List<BedTypes> getAll(){
        return Lists.newArrayList(SINGLE, DOUBLE, STORIED);
    }
}

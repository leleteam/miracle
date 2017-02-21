package com.dream.common.dto.enums;

public enum EnumCommonError {
    系统出错,
    ;

    public static final String NotSupported_File_Type(String suffix) {
        return suffix + " 类型文件不支持";
    }
}

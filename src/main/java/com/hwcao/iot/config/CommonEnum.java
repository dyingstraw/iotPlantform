package com.hwcao.iot.config;

public enum CommonEnum {

    /*******数据库*************/
    UPDATE(1,"update"),
    INSERT(0,"insert");



    private int key;
    private String value;
    CommonEnum(int key, String value) {
        this.key =key;
        this.value =value;
    }

    public String getValue() {
        return value;
    }
    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}

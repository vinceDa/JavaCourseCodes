package com.homework.pr.nine02;

/**
 * @author ohYoung
 * @date 2021/2/21 0:48
 */
public class ConfigBasePojo {

    private ConfigRefPojo refPojo;

    public void sayRefType() {
        System.out.println(refPojo.getRefType());
    }

    public ConfigRefPojo getRefPojo() {
        return refPojo;
    }

    public void setRefPojo(ConfigRefPojo refPojo) {
        this.refPojo = refPojo;
    }

}

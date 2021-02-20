package com.homework.pr.nine02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ohYoung
 * @date 2021/2/21 0:50
 */
@Component("annotationRefPojo")
public class RefPojo {

    @Value("${:ANNOTATION}")
    private String refType;

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }
}

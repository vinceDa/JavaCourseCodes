package com.homework.pr.nine02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author ohYoung
 * @date 2021/2/21 0:49
 */
@Configuration
@Component
public class JavaConfig {

    @Autowired
    @Qualifier("configRefPojo")
    private ConfigRefPojo refPojo;



    @Bean("configBasePojo")
    public ConfigBasePojo basePojo() {
        ConfigBasePojo basePojo = new ConfigBasePojo();
        basePojo.setRefPojo(refPojo);
        return basePojo;
    }

    @Bean("configRefPojo")
    public ConfigRefPojo refPojo( @Value("${:CONFIG}") String refType) {
        ConfigRefPojo refPojo = new ConfigRefPojo();
        refPojo.setRefType(refType);
        return refPojo;
    }
}

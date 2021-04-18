package com.knight.autoConfiguration;

import com.knight.springboot.pojo.qo.NamedQo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AutoImportConfig1 {

    @Bean
    public NamedQo createNewNameQo() {
        return new NamedQo();
    }
}

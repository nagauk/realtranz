package com.unr.realtranz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Locale;
import java.util.Optional;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:16-06-2022 21:58
 **/
@Configuration
@EnableJpaAuditing
public class RealTranzAuditConfig {

    @Bean
    public AuditorAware<String> aware() {
        return () -> Optional.of("Administrator");
    }

}

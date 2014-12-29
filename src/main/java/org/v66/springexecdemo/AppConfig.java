package org.v66.springexecdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("org.v66.springexecdemo")
@ImportResource("applicationContext.xml")
public class AppConfig {

//	@Bean
//    public String message() {
//        return "hello";
//    }
}

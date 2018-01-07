package com.jt.enterprise;

import lombok.Data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data
@SpringBootApplication
@MapperScan("com.jt.enterprise.mapper")
@ConfigurationProperties(prefix = "app")  
public class Application 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
    
    private String name;
    private String keywords;
    private String description;

}

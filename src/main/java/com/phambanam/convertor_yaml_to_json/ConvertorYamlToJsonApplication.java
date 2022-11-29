package com.phambanam.convertor_yaml_to_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class ConvertorYamlToJsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConvertorYamlToJsonApplication.class, args);
    }
    @Bean
    @Primary
    public static ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean(name="yamlMapper")
    public static YAMLMapper yamlMapper(){
        return new YAMLMapper();
    }
}

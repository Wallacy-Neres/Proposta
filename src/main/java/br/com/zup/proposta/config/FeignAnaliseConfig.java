package br.com.zup.proposta.config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class FeignAnaliseConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignAnaliseErrorDecoder();
    }
}

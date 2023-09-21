package br.com.zup.proposta.config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class FeignCartoesConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignCartoesErrorDecoder();
    }
}

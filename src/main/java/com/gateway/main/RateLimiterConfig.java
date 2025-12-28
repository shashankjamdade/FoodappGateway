package com.gateway.main;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * Configuration for rate limiting in Spring Cloud Gateway
 * Uses IP address as the key for rate limiting
 */
@Configuration
public class RateLimiterConfig {

    /**
     * Key resolver that uses the client's IP address for rate limiting
     * This allows per-IP rate limiting
     */
    @Bean
    public KeyResolver ipAddressKeyResolver() {
        return exchange -> Mono.just(
                exchange.getRequest().getRemoteAddress().getAddress().getHostAddress()
        );
    }

    /**
     * Alternative: Key resolver based on user principal
     * Uncomment to use user-based rate limiting instead of IP-based
     */
    // @Bean
    // public KeyResolver userKeyResolver() {
    //     return exchange -> Mono.just(
    //             exchange.getPrincipal()
    //                     .map(Principal::getName)
    //                     .defaultIfEmpty("anonymous")
    //     );
    // }

    /**
     * Alternative: Key resolver based on hostname
     * Uncomment to use hostname-based rate limiting
     */
    // @Bean
    // public KeyResolver hostKeyResolver() {
    //     return exchange -> Mono.just(
    //             exchange.getRequest().getRemoteAddress().getHostName()
    //     );
    // }
}


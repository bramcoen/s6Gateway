package com.hakobjan.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/*
  Source:
  https://github.dev/spring-attic/sample-zuul-filters
  https://cloud.spring.io/spring-cloud-netflix/multi/multi__router_and_filter_zuul.html
*/
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

    @Bean
    public AddResponseHeaderFilter addResponseHeaderFilter() {
        return new AddResponseHeaderFilter();
    }

    @Bean
    public ModifyResponseBodyFilter modifyResponseHeaderFilter() {
        return new ModifyResponseBodyFilter();
    }

    @Bean
    public ModifyResponseDataStreamFilter modifyResponseDataStreamFilter() {
        return new ModifyResponseDataStreamFilter();
    }

    @Bean
    public PrefixRequestEntityFilter prefixRequestEntityFilter() {
        return new PrefixRequestEntityFilter();
    }

    @Bean
    public QueryParamPortPreFilter queryParamPortPreFilter() {
        return new QueryParamPortPreFilter();
    }

    @Bean
    public QueryParamServiceIdPreFilter queryParamServiceIdPreFilter() {
        return new QueryParamServiceIdPreFilter();
    }

    @Bean
    public UppercaseRequestEntityFilter modifyRequestEntityFilter() {
        return new UppercaseRequestEntityFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}

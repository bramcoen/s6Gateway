package party.coenders.s6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

/*
  Source:
  https://github.dev/spring-attic/sample-zuul-filters
  https://cloud.spring.io/spring-cloud-netflix/multi/multi__router_and_filter_zuul.html
*/
@EnableZuulProxy
@SpringBootApplication
@CrossOrigin(origins = {"http://localhost", "https://www.coenders.party", "http://www.coenders.party"}, maxAge = 3600)
public class ApiGatewayApplication {

    @Bean
    public AddResponseHeaderFilter addResponseHeaderFilter() {
        return new AddResponseHeaderFilter();
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

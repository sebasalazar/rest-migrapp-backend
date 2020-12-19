package cl.sebastian.proyecto.rest;

import cl.sebastian.proyecto.rest.filter.SimpleCORSFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean simpleCORSFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SimpleCORSFilter());
        registration.addUrlPatterns("/*");
        registration.setName("simpleCORSFilter");
        registration.setOrder(1);
        return registration;
    }
}

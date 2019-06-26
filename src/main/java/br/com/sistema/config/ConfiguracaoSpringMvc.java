package br.com.sistema.config;


import br.com.sistema.converter.PessoaConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

import javax.servlet.Filter;

@Configuration
public class ConfiguracaoSpringMvc  extends WebMvcConfigurerAdapter {

    @Bean
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver resolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        return templateEngine;
    }


    public void addViewControllers (ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/empresa/home").setViewName("home");
        registry.addViewController("/css/style").setViewName("home");
    }

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(

                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(

                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }
*/
    protected Filter[] getSerFilters(){

        return new Filter[] {new OpenEntityManagerInViewFilter()};
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(new PessoaConverter());
    }

}

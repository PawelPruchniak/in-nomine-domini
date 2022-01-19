package pl.edu.amu.home.paleografia.spring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import pl.edu.amu.home.paleografia.hibernate.manager.ModelManager;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories("pl.edu.amu.home.paleografia.spring.repositories")
@EnableSwagger2
public class SpringApplication extends SpringBootServletInitializer {

    public static void main( String... args ) {
        org.springframework.boot.SpringApplication.run( SpringApplication.class, args );
        var modelManager = new ModelManager();
        modelManager.init();
    }

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
        return application.sources( SpringApplication.class );
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        var jsonConverter = new MappingJackson2HttpMessageConverter();
        var objectMapper = new ObjectMapper();
        objectMapper.registerModule( new JavaTimeModule() );
        objectMapper.disable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS );
        objectMapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
        jsonConverter.setObjectMapper( objectMapper );
        return jsonConverter;
    }

    @Bean
    public Docket productApi() {
        return new Docket( DocumentationType.SWAGGER_2 )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "pl.edu.amu.home.paleografia.spring.controllers" ) )
                .build();
    }
}
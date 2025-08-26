package pe.com.ncquality.sad.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket defApi() {
        return new Docket(DocumentationType.SWAGGER_2)
	        		.securityContexts(Arrays.asList(securityContext()))
	        		.securitySchemes(Arrays.asList(apiKey()))
                   .select()                 
                   .apis(RequestHandlerSelectors.basePackage("pe.com.ncquality.sad"))
                   //.paths(regex("/mpd/v1.*"))
                   .paths(PathSelectors.any())
                   .build()
                   .apiInfo(metaData());
        
        
       
      // .useDefaultResponseMessages(false);
    }
    
    private ApiInfo metaData() {
    	
   	 return new ApiInfoBuilder()
        	.title("Sistema Admnistrativo Digital - SAD")
                .description("Sistema Admnistrativo Digital para la Constructora NC Quality.")
                .termsOfServiceUrl("Terminos del servicio")
                .version("1.0")
                .contact(new Contact("NCQUALITY/PERÚ", "http://www.constructorancquality.com.pe", ""))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();    	

   }     
    
    private ApiKey apiKey() { 
        return new ApiKey("JWT", "Authorization", "header"); 
    }
    
    private SecurityContext securityContext() { 
        return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
    } 

    private List<SecurityReference> defaultAuth() { 
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
        authorizationScopes[0] = authorizationScope; 
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
    }
    
}

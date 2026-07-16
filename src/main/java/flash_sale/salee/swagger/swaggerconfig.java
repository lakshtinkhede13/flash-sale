package flash_sale.salee.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerconfig {
@Bean
    public OpenAPI openAPI(){
    return new OpenAPI()
            .info(new Info()
                    .title("FLASH SALE API")
                    .description("solved order cancel problem in sale")
                    .version("1.00")
                    .contact(new Contact()
                            .email("lakshtinkhede9@gmail.com")
                            .name("laksh")
                    ));

}
}

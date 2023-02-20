package br.com.pedrodeveloper.springdataexamples;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages={"br.com.pedrodeveloper.springdataexamples.*"})
public class SpringDataExamplesApplication {

	@Bean
	public OpenAPI springShopOpenAPI(@Value("${application-version}") String appVersion,@Value("${application-description}") String appDescription) {
		return new OpenAPI()
				.info(new Info().title("Api backend du projet Kleapp :)")
						.description(appDescription)
						.version(appVersion)
						.license(new License().name("MIT")));
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDataExamplesApplication.class, args);
	}

}

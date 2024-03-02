package zerobase.weather.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger springdoc-ui 구성 파일
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("날씨 일기 프로젝트 :)")
                .version("2.0")
                .description("날씨 일기를 CRUD 할 수 있는 백엔드 API 입니다");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
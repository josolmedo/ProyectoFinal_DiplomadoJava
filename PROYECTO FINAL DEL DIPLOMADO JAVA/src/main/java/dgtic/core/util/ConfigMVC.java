package dgtic.core.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigMVC implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //.addResourceLocations("file:/home/mash/imagenes/ventas/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/imagenes/ventas/**")
                .addResourceLocations("file:c:/imagenes/ventas/");
    }

}

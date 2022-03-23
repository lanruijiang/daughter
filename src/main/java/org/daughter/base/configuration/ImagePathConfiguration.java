package org.daughter.base.configuration;

import org.daughter.base.dao.sources.UpdateParamBase;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagePathConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( "/images/**" ).addResourceLocations( "file:D:\\data\\file\\images\\" );
        registry.addResourceHandler( "/editorimages/**" ).addResourceLocations( "file:"+ UpdateParamBase.wangEditorURL );
    }
}

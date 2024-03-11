package mx.edu.utez.sda.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    String UNA_constante = "UNA CONSTAnte mal declarada";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //registry.addViewController("/").setViewName("index");
        //registry.addViewController("/index").setViewName("index");

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/pokemon").setViewName("pokemon");

        String x= "No buena practica";
        while (x == null){
            System.out.println("algo");
        }
    }
}

package mx.edu.utez.sda.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1 = User.withUsername("user1")
                .password(
                        passwordEncoder().encode("user1Pass")
                )
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(
                        passwordEncoder().encode("admin123")
                ).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1,admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((request)->{
            request.requestMatchers("/","/index").permitAll();
            request.anyRequest().authenticated();
        });

        //Especificar una pagina de login
        http.formLogin((login)->{
            login.loginPage("/login").permitAll();
        });

        http.logout((logout)->{
            logout.permitAll();
        });

        return http.build();
    }
}

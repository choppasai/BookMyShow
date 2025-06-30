package BookMYShow.Application.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class PasswordConfig {
    /*
     * To bypass the authentication i used below code.
     * But this security configuration I no longer needed because i am implementing spring autherization server.So i commented.
     */
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())  // Disable CSRF for /signup endpoint
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("users/sign-up","users/login").permitAll()  // Allow signup requests
//                        .anyRequest().authenticated()  // Require auth for all other endpoints
//                )
//                .formLogin(login -> login.disable());
//
//        return http.build();
//    }
    @Bean
    public BCryptPasswordEncoder createBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

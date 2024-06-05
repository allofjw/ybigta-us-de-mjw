package com.example.demo;


import com.example.demo.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomOAuth2UserService customOAuth2UserService;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers("/").permitAll();//모두에게 허용되는 페이지
                    authorizeRequests.requestMatchers("/login").permitAll(); // 모두에게 허용되는 페이지
                    authorizeRequests.requestMatchers("/user").hasRole("USER");//user role이 있어야지만 허용하도록
                    authorizeRequests.anyRequest().authenticated();
                })
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.accessDeniedPage("/accessDenied")
                )
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                )
                .csrf(csrf -> csrf.disable())
                .oauth2Login(oauth2Login ->
                        oauth2Login.loginPage("/login")
                                .defaultSuccessUrl("/home", true)
                                .userInfoEndpoint(userInfoEndpoint ->
                                        userInfoEndpoint.userService(customOAuth2UserService)
                                )
                )
                ;

        return http.build();
    }
}

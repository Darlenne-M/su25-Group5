package com.example.Trotter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import jakarta.servlet.DispatcherType;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomProviderDetailsService providerDetailsService;

    public SecurityConfig(CustomProviderDetailsService providerDetailsService) {
        this.providerDetailsService = providerDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD,
                                DispatcherType.ERROR)
                        .permitAll()
                        .requestMatchers("/", "/providers", "/trotter", "/providers/createForm", "/profile-pictures/**",
                                "/login", "/logout")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/providers", "/profile-pictures/**").permitAll()
                        .requestMatchers("/provider-homepage/*", "/providers/delete/**",
                                "/provider-homepage/*/updateForm", "/provider-homepage/*/update",
                                "/provider-homepage/*/services/createForm", "/provider-homepage/*/services",
                                "/provider-homepage/*/services/**", "/provider-homepage/*/delete/**",
                                "/provider-homepage/*/services/**/updateForm",
                                "/providers/update/**", "/providers/**/update")
                        .hasAuthority("PROVIDER")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .successHandler((request, response, authentication) -> {
                            String username = authentication.getName();
                            Long providerId = providerDetailsService.getProviderIdByEmail(username);
                            response.sendRedirect("/provider-homepage/" + providerId);
                        })
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/trotter")
                        .permitAll())

                .exceptionHandling((x) -> x.accessDeniedPage("/403"))
                
                .requestCache((cache) -> cache
                        .requestCache(requestCache));

        return http.build();

    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(providerDetailsService).passwordEncoder(
                passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

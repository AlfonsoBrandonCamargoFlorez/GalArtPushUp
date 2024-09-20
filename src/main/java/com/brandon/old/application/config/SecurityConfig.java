package com.brandon.old.application.config;

import com.brandon.old.infrastructure.adapter.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
   public SecurityConfig() {
   }

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      return (SecurityFilterChain)httpSecurity.csrf((csrf) -> {
         csrf.disable();
      }).httpBasic(Customizer.withDefaults()).authorizeHttpRequests((auth) -> {
         ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.requestMatchers(new String[]{"/css/**", "/js/**", "/images/**"})).permitAll();
         ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.requestMatchers(HttpMethod.GET, new String[]{"/api/**"})).hasAnyRole(new String[]{"ADMIN"});
         ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.requestMatchers(HttpMethod.PUT, new String[]{"/api/**"})).permitAll();
         ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.requestMatchers(HttpMethod.POST, new String[]{"/api/**"})).permitAll();
         ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.requestMatchers(HttpMethod.DELETE, new String[]{"/api/**"})).permitAll();
         ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.anyRequest()).hasAnyRole(new String[]{"ADMIN"});
      }).formLogin((form) -> {
         ((FormLoginConfigurer)form.loginPage("/login").defaultSuccessUrl("/home", true)).permitAll();
      }).logout((logout) -> {
         logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();
      }).build();
   }

   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
   }

   @Bean
   public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
      DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
      provider.setPasswordEncoder(this.passwordEncoder());
      provider.setUserDetailsService(userDetailService);
      return provider;
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }
}

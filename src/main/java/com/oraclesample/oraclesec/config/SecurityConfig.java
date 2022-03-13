//package com.oraclesample.oraclesec.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurer {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/","/shop/**","/register")
//                .permitAll();
//    }
////    @Override
////    public void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
////    }
////
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/resources/**", "/static/**", "/img/**", "/css/**", "/js/**");
////    }
//}

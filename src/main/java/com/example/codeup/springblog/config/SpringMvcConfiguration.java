//package com.example.codeup.springblog.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//
//@Configuration
//public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {
//
//
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(java.util.Locale.US);
//        return sessionLocaleResolver;
////
//    }
//
//    @Bean
//    LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        return localeChangeInterceptor;
////        allows setting locale through a parameter. if param present, can change locale via lang param
////        if param not present, fall back to determine locale via url headers
//    }
//
//    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
//        interceptorRegistry.addInterceptor(localeChangeInterceptor());
////        allows the passing in of a language param on the url string and set diff language
//    }
//
//}

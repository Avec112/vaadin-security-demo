package io.avec.securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;


/*
    This tutorial tells ut that it will not work for SSO (not implemented however)
    https://vaadin.com/learn/tutorials/securing-your-app-with-spring-security/form-less
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_PROCESSING_URL = "/login";
    private static final String LOGIN_FAILURE_URL = "/login?error";
    private static final String LOGIN_URL = "/login";
    private static final String LOGOUT_SUCCESS_URL = "/login";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Not using Spring CSRF here to be able to use plain HTML for the login page
        // Vaadin has built-in Cross-Site Request Forgery already
        http.csrf().disable()

                // Register our CustomRequestCache, that saves unauthorized access attempts, so
                // the user is redirected after login.
                .requestCache().requestCache(new CustomRequestCache())

                // Restrict access to our application and force authentication for all views
                .and().authorizeRequests()

                // Allow all Vaadin internal requests.
                .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()

                // Allow all requests by logged in users.
                .anyRequest().authenticated()

                // Configure the login page.
                .and().formLogin()
                    .loginPage(LOGIN_URL).permitAll()
                    .loginProcessingUrl(LOGIN_PROCESSING_URL)
                    .failureUrl(LOGIN_FAILURE_URL)

                // Configure logout
                .and().logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
//                "/all-roles/**",
                "/VAADIN/**",
                "/favicon.ico",
//                "/robots.txt",
                "/manifest.webmanifest", "/sw.js", "/offline-page.html",
                "/icons/**", "/images/**",
                "/frontend/**",
                "/webjars/**",
//                "/h2-console/**",
                "/frontend-es5/**", "/frontend-es6/**",
                "/vaadinServlet/**"
        );

    }

    @SuppressWarnings("deprecation") // ok for demo purposes
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = Arrays.asList(
                User.withDefaultPasswordEncoder()
                        .username("guest")
                        .password("guest")
                        .roles("GUEST")
                        .build(),
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("user")
                        .roles("USER")
                        .build(),
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("USER", "ADMIN")
                        .build()
        );

        return new InMemoryUserDetailsManager(users);
    }
}


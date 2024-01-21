package br.com.fullstackdeveloper.hrworker.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> cors.disable());
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        http.authorizeHttpRequests(auth -> {

            auth.requestMatchers("/h2-console/**").permitAll();

            auth.anyRequest().fullyAuthenticated();
        });

        http.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.disable());
        http.formLogin(formLogin -> formLogin.disable());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCryptVersion.$2A, 11);
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails userDetails = User.withUsername("admin")
                .password(passwordEncoder().encode("123"))
                .authorities(Arrays.asList(() -> "ROLE_ADMIN"))
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

}

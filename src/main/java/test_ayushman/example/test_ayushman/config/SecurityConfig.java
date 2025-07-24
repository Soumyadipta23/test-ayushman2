/*package test_ayushman.example.test_ayushman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/patient/login", "/api/hospital/login", "/api/doctor/login", "/api/diagnostic/login").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}

 */
package test_ayushman.example.test_ayushman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/patient/login",
                                "/api/hospital/login",
                                "/api/doctor/login",
                                "/api/diagnostic/login"
                        ).permitAll() // Allow unauthenticated access to these login endpoints
                        .anyRequest().authenticated() // All other endpoints require auth
                )
                .httpBasic(httpBasic -> httpBasic.disable()) // Disable HTTP Basic Auth
                .formLogin(form -> form.disable()) // Disable form login
                .logout(logout -> logout.disable()); // Optional: disable default logout

        return http.build();
}
}
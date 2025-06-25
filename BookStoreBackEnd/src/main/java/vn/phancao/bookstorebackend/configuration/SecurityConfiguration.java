package vn.phancao.bookstorebackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Vô hiệu hóa CSRF vì là stateless (API)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Đặt session là stateless
                .authorizeHttpRequests(authorize -> authorize
                        // Cho phép các endpoint công khai (ví dụ: đăng ký, đăng nhập)
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        // Yêu cầu xác thực cho tất cả các endpoint khác
                        .anyRequest().authenticated()
                );
        // .httpBasic(); // (Tùy chọn) Nếu bạn muốn sử dụng xác thực HTTP Basic
        // .formLogin(); // (Tùy chọn) Nếu bạn muốn sử dụng xác thực form (ít dùng cho REST API)

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Sử dụng BCrypt để mã hóa mật khẩu
    }
}

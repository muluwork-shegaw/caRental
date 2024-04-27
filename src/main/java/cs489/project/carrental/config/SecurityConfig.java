package cs489.project.carrental.config;

import cs489.project.carrental.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtAuthFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/swagger-ui.html", "/swagger-ui/**",
                                        "/swagger-resources/*",
                                        "/v3/api-docs/**")
                                .permitAll()
                                .requestMatchers("/rentalAgent/*").hasAuthority("all")
                                .requestMatchers("/vehicles/register").permitAll()
                                .requestMatchers("/vehicles/{vehicleId}").permitAll()
                                .requestMatchers("/uaa/login").permitAll()
                                .requestMatchers("/uaa/signup").permitAll()
                                .requestMatchers(HttpMethod.POST, "/roles/*")
                                .hasAuthority("all").requestMatchers(HttpMethod.GET, "/cars/*").hasAuthority("all")
                                .requestMatchers("/customers/*").hasAuthority("all")
                                .requestMatchers("/customers/*").hasAuthority("all")
                                .requestMatchers("/reservations/*").hasAuthority("all")
                                .requestMatchers("/vehicles/*").hasAuthority("all")
                                .requestMatchers("/users/*").hasAuthority("all")

                                .anyRequest()
                                .authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS));

        httpSecurity.authenticationProvider(authenticationProvider());
        httpSecurity.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }


}

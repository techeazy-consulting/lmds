package com.techeazy.lmds.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
@Profile("prod")
@EnableWebSecurity
public class ProjectSecurityProdConfig {
	
	private static final String[] AUTH_WHITELIST = {
	        "/api/v1/auth/**",
	        "/v3/api-docs/**",
	        "/v3/api-docs.yaml",
	        "/swagger-ui/**",
	        "/swagger-ui.html"
	};

	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrfConfig -> csrfConfig.disable())
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/testClient").authenticated()
						.requestMatchers(AUTH_WHITELIST).permitAll()
						.requestMatchers("/error", "/registerClient","/getOrderDetail/**").permitAll())
				.httpBasic(Customizer.withDefaults())
	            .formLogin(Customizer.withDefaults());;
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public CompromisedPasswordChecker compromisedPasswordChecker() {
		return new HaveIBeenPwnedRestApiPasswordChecker();
	}
	

}

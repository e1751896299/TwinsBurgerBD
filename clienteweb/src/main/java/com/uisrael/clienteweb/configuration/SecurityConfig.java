package com.uisrael.clienteweb.configuration;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http,
			ApiAuthenticationProvider authenticationProvider,
			ApiUserDetailsService userDetailsService) throws Exception {
		http
			.authenticationProvider(authenticationProvider)
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/login", "/registro", "/acceso-denegado", "/error",
						"/menu", "/menu/**", "/core/**", "/css/**", "/preview/**", "/static/**", "/favicon-dev.ico").permitAll()
				.requestMatchers("/carrito/**").hasRole("CLIENTE")
				.anyRequest().hasRole("ADMIN"))
			.formLogin(form -> form
				.loginPage("/login")
				.usernameParameter("correo")
				.passwordParameter("contrasena")
				.successHandler(successHandler())
				.failureUrl("/login?error")
				.permitAll())
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID"))
			.rememberMe(remember -> remember
				.userDetailsService(userDetailsService)
				.tokenValiditySeconds(7 * 24 * 60 * 60)
				.useSecureCookie(false))
			.exceptionHandling(errors -> errors.accessDeniedPage("/acceso-denegado"));

		return http.build();
	}

	private AuthenticationSuccessHandler successHandler() {
		return (request, response, authentication) -> {
			boolean esAdmin = authentication.getAuthorities().stream()
					.anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
			redireccionar(response, esAdmin ? "/" : "/menu");
		};
	}

	private void redireccionar(jakarta.servlet.http.HttpServletResponse response, String ruta) throws IOException {
		response.sendRedirect(ruta);
	}
}

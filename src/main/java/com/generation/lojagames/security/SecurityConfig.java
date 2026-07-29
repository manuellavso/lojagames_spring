package com.generation.lojagames.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration //FAZ A CONFIGURAÇÃO DA SECURITY
@EnableWebSecurity //SOBRESCREVER A SECURITY PADRÃO
public class SecurityConfig {

	//DESCREVO ENDPOINTS PÚBLICOS (LIBERADOS DE AUTENTICAÇÃO)
    private static final String[] PUBLIC_ENDPOINTS = {
        "/usuarios/logar",
        "/usuarios/cadastrar",
        "/error/**",
        "/", "/docs", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**" //DOCUMENTAÇÃO DO SISTEMA
    };

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    
    //RESPONSÁVEL POR CRIPTOGRAFAR A SENHA
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    
    //GERENTE DE AUTENTICAÇÃO, INDICA A ORDEM DOS FILTROS ETC
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    
    //DEFINE COMO A SECURITY VAI FUNCIONAR
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
            .csrf(csrf -> csrf.disable()) //DESABILITAR PROTEÇÃO CONTRA ATAQUE CSRF
            .cors(cors -> {}) //PERMITE REQUISIÇÕES DE FORA DO SERVIDOR
            
            //PERMISSÕES
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(PUBLIC_ENDPOINTS).permitAll() 
                .requestMatchers(HttpMethod.OPTIONS).permitAll() 
                .anyRequest().authenticated() 
            )
            
            
            .exceptionHandling(exceptions -> exceptions
                    .authenticationEntryPoint((request, response, authException) -> 
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, 
                            "Não autorizado - Token JWT ausente ou inválido"))
            )
            
            //FILA DE FILTROS
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
    
}
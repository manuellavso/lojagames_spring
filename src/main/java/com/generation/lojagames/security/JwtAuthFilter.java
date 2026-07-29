package com.generation.lojagames.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {//"PORTEIRO"
//HERDA PADRÃO PARA CRIAR FILTROS DE SERVER; BASICAMENTE CHECA O TOKEN, E DEPOIS COMEÇA A PASSAR PELOS FILTROS
	
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException { 
        
        try {//EXTRAIR O TOKEN DE DENTRO DA REQUISIÇÃO
            String token = extractTokenFromRequest(request);
            
            if (token == null || SecurityContextHolder.getContext().getAuthentication() != null) {
                filterChain.doFilter(request, response);
                return;
            }
            
            processJwtAuthentication(request, token);
            filterChain.doFilter(request, response);
            
        } catch (ExpiredJwtException | SignatureException | MalformedJwtException
        		| UsernameNotFoundException e) {
        	response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }

    
    //MÉTODO AUXILIAR: LÊ O CABEÇARIO DA REQUISIÇÃO E PEGA APENAS O TOKEN
    private String extractTokenFromRequest(HttpServletRequest request) {
        
    	String authHeader = request.getHeader("Authorization");
        
        if (authHeader != null && authHeader.startsWith("Bearer ") && authHeader.length() > 7) {
            return authHeader.substring(7);
        }
        
        return null;
    }
    
    
    private void processJwtAuthentication(HttpServletRequest request, String token) {
        
    	//EXTRAIR O NOME DE USUÁRIO DE DENTRO DO TOKEN
    	String username = jwtService.extractUsername(token);
        
    	//CHECA SE O USUÁRIO ESTÁ AUTENTICADO
        if (username != null && !username.trim().isEmpty()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            
            if (jwtService.validateToken(token, userDetails)) {
            	
            	//SE O TOKEN FOR LIBERADO, MOSTRA OS DIRETOS DE ACESSO DO USUÁRIO
                UsernamePasswordAuthenticationToken authToken = 
                    new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                
                //ADICIONA O TOKEN E LIBERA REQUISIÇÃO
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                SecurityContextHolder.getContext().setAuthentication(authToken);
                
            } else {//SE O TOKEN NÃO FOR LIBERADO (401)
                throw new RuntimeException("Token JWT inválido ou expirado");
            }
            
        } else {//SE O USUÁRIO NÃO ESTIVER AUTENTICADO (401)
            throw new RuntimeException("Usuário não pode ser extraído do token JWT");
        }
    }

}
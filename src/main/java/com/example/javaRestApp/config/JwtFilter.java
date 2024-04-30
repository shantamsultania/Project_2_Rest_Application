package com.example.javaRestApp.config;

import com.example.javaRestApp.service.UserServiceProvider;
import com.example.javaRestApp.utils.JwtGeneratorValidator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    UserServiceProvider userServiceProvider;

    @Autowired
    JwtGeneratorValidator jwtGeneratorValidator;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizedHeader = request.getHeader("Authorization");

        String token = null;
        String userName = null;

        if (authorizedHeader != null && authorizedHeader.startsWith("Bearer")) {

            token = authorizedHeader.substring(7);
            userName = jwtGeneratorValidator.extractUserName(token);
            System.out.println("this is username in local "+userName);

        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userServiceProvider.loadUserByUsername(userName);

            if (jwtGeneratorValidator.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);

    }
}

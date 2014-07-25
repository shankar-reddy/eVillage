package com.itreddys.evillage.security;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.web.filter.GenericFilterBean;



/**
 * @author SANKARA REDDY TELUKUTLA
 * July 21st 2014 11:31 PM PDT
 * This is the class you should use to extract and manipulate the header data
 * to pass to the authentication manager to authenticate.
 */
public class NeelRestSecurityFilter extends GenericFilterBean {

    private AuthenticationManager authenticationManager;
    private AuthenticationEntryPoint authenticationEntryPoint;

    public NeelRestSecurityFilter(AuthenticationManager authenticationManager) {
        this(authenticationManager, new BasicAuthenticationEntryPoint());
        //((BasicAuthenticationEntryPoint)authenticationEntryPoint).setRealmName("Username:  UserName password: Password");
    }

    public NeelRestSecurityFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationManager = authenticationManager;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String authorization = request.getHeader("Authorization");
        //If the Authorization header is null, let the ExceptionTranslationFilter provided by
        //the <http> namespace kick of the BasicAuthenticationEntryPoint to provide the username and password dialog box
        if (authorization == null) {
            chain.doFilter(request, response);
            return;
        }

        String[] credentials = decodeHeader(authorization);
        if(credentials.length!=2){
        	  chain.doFilter(request, response);
              return;
        }
        Authentication authentication = new NeelToken(credentials[0], credentials[1]);

        try {
            Authentication successfulAuthentication = authenticationManager.authenticate(authentication);
            //Pass the successful token to the SecurityHolder where it can be retrieved by this thread at any stage.
            SecurityContextHolder.getContext().setAuthentication(successfulAuthentication);
            chain.doFilter(request, response);
        } catch (AuthenticationException authenticationException) {
            //If it fails clear this threads context and kick off the authentication entry point process.
            SecurityContextHolder.clearContext();
            authenticationEntryPoint.commence(request, response, authenticationException);
        }
    }

    /**
     * Decode the Auth Header to get the username and password
     * @param authorization
     * @return
     */
    public String[] decodeHeader(String authorization) {
        try {
            byte[] decoded = Base64.decode(authorization.substring(6).getBytes("UTF-8"));
            String credentials = new String(decoded);
            return credentials.split(":");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

}

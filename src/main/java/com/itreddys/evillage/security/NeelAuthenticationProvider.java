package com.itreddys.evillage.security;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.itreddys.evillage.bean.Account;
import com.itreddys.evillage.dao.AccountDAO;
import com.itreddys.evillage.exception.eVillageException;


/**
 * @author Shankar Reddy
 */
public class NeelAuthenticationProvider implements AuthenticationProvider {
	 private static final Logger logger = Logger.getLogger(NeelAuthenticationProvider.class);
	 @Autowired
	 AccountDAO accountDAO;
	 
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        NeelToken neelToken = (NeelToken) authentication;
        
        boolean dbEnabled = true;
        boolean isAuthenticated = false;
        String key = neelToken.getKey();
        String credentials = neelToken.getCredentials();
        
        logger.info("Autheticating User :"+ key);

       	logger.info("Connecting to itreddys Database for Authentication");
        	Account account = new Account();
        	account.setUserName(key);
        	account.setPassword(credentials);
        	try {
				isAuthenticated = accountDAO.authenticate(account);
				isAuthenticated = true; //to bypass security for time being.
				
			} catch (eVillageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        if(!isAuthenticated) {
        	logger.info("Authentication fails for the User :"+ key);
            throw new BadCredentialsException("Failed Authentication");
        }
        	
        return getAuthenticatedUser(key, credentials);
    }

    private Authentication getAuthenticatedUser(String key, String credentials) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new NeelToken(key, credentials, authorities);
    }

    public boolean supports(Class<?> authentication) {
        return NeelToken.class.equals(authentication);
    }
}

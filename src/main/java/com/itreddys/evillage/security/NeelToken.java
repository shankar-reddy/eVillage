package com.itreddys.evillage.security;

/**
* @author SANKARA REDDY TELUKUTLA
* July 21st 2014 11:31 PM PDT
*/
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Token to hold security credentials
 */
public class NeelToken extends UsernamePasswordAuthenticationToken {

    public NeelToken(String key, String credentials) {
        super(key, credentials);
    }

    public NeelToken(String key, String credentials, Collection<? extends GrantedAuthority> authorities) {
        super(key, credentials, authorities);
    }

    public String getKey() {
        return (String) super.getPrincipal();
    }

    public String getCredentials() {
        return (String) super.getCredentials();
    }
}

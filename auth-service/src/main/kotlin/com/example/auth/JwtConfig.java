package com.example.auth;

import org.springframework.beans.factory.annotation.Value;

public class JwtConfig {
    @Value("${security.jwt.uri")
    String Uri;

    @Value("${security.jwt.expiration")
    Long Expiration;

    @Value("${security.jwt.header")
    String Header;

    @Value("${security.jwt.prefix")
    String Prefix;

    @Value("${security.jwt.uri")
    String Secret;

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public Long getExpiration() {
        return Expiration;
    }

    public void setExpiration(Long expiration) {
        Expiration = expiration;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String prefix) {
        Prefix = prefix;
    }

    public String getSecret() {
        return Secret;
    }

    public void setSecret(String secret) {
        Secret = secret;
    }
}

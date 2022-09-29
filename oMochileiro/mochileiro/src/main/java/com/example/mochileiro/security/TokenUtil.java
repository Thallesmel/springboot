package com.example.mochileiro.security;

import java.security.Key;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.example.mochileiro.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {
    private static final String HEADER = "Autorization";
    private static final String PREFIX = "Bearer ";
    private static final long EXPIRATION = 12*60*60*1000;
    private static final String SECRET_KEY = "MyK3yt0T0k3nP4r@S3CuriTY@Sp3c14L";
    private static final String EMISSOR = "DevNice";

    public static String createToken(Usuario usuario) {
        Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        String token = Jwts.builder()
                            .setSubject(usuario.getNome())
                            .setIssuer(EMISSOR)
                            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                            .signWith(secretKey, SignatureAlgorithm.HS256)
                            .compact();
        return PREFIX  + token;
    }

    private static boolean isExpirationValid(Date expiration) {
        return expiration.after(new Date(System.currentTimeMillis()));
    }

    private static boolean isEmissorValid(String emissor) {
        return emissor.equals(EMISSOR);
    }

    private static boolean isSubjectValid(String username) {
        return username != null && username.length() > 0;
    }

    public static Authentication validate(HttpServletRequest request) {
        String token = request.getHeader(HEADER);
        token = token.replace(PREFIX, "");

        Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes())
                                    .build()
                                    .parseClaimsJws(token);

        String username = jwsClaims.getBody().getSubject();
        String issuer = jwsClaims.getBody().getIssuer();
        Date expira = jwsClaims.getBody().getExpiration();

        if (isSubjectValid(username) && isEmissorValid(issuer) && isExpirationValid(expira)) {
            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
        }
        return null;
    }
}

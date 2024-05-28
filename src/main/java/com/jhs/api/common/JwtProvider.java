package com.jhs.api.common;


import com.jhs.api.user.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtProvider {
  @Value("${jwt.iss}")
  private String issuer;

  @Value("${jwt.exp}")
  private Long expiration;

  private final SecretKey secretKey;

  Instant expiredDate = Instant.now().plus(1, ChronoUnit.DAYS);

  public JwtProvider(@Value("${jwt.secret}") String secretKey) {
    this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
  }

  public String createToken(UserDTO dto) {
    String token = Jwts.builder()
            .issuer(issuer)
            .signWith(secretKey)
            .expiration(Date.from(expiredDate))
            .subject("user Auth")
            .claim("userEmail", dto.getEmail())
            .claim("userId", dto.getId())
            .compact();
    log.info("로그인성공으로 발급된 토큰 : " + token);
    return token;
  }

  public String extractTokenFromHeader(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }else {return "undefined token";}
  }

  public void printPayload(String AccessToken) {
    Base64.Decoder decoder = Base64.getDecoder();

    String[] chunk = AccessToken.split("\\.");
    String payload = new String(decoder.decode(chunk[1]));
    String header = new String(decoder.decode(chunk[0]));

    log.info("AccessToken Header : "+header);
    log.info("AccessToken Payload : "+payload);

    //return payload;
  }

  public Claims getPayload(String accessToken) {
//    Jws<Claims> claimsJws = Jwts.parser().verifyWith(secretKey).build()
//            .parseSignedClaims(accessToken);
//    String IDstr = claimsJws.getPayload().getId();
//    log.info("Jwt 프로바이더 Access Token ID : "+IDstr);
    return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(accessToken).getPayload();
  }
}

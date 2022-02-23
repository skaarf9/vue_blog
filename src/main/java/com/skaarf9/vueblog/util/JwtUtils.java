package com.skaarf9.vueblog.util;/**
 * @author: Administrator
 * @date: 2022/2/23 14:01
 * @description:
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Administrator
 * @date 2022/2/23
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "skaarf9.jwt")
public class JwtUtils {
    private String secret;
    private long expire;
    private String header;

    /**
     * 生成token
     * @param userId
     * @return
     */
    public String generateToken(long userId){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "jwt")
                .setSubject(userId + "")
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimsByToken(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.debug("validate is token error ", e);
            return null;
        }
    }

    /**
     * 验证token是否过期
     * @param expiration
     * @return
     */
    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }
}

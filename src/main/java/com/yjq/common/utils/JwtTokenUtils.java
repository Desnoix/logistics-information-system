package com.yjq.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @ClassName JwtTokenUtils
 * @Author GDMZ_jqyang@outlook.com
 * @Description token生成工具类
 * @Date 2020/2/11 20:02
 * @Version 1.0
 */
public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecret";
    private static final String ISS = "admin";

    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;

    // 创建token
    public static String createToken(String username, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET) //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了
                .setIssuer(ISS)
                .setSubject(username)//sub(Subject)：代表这个JWT的主体，即它的所有人
                .setIssuedAt(new Date())//iat: jwt的签发时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    // 从token中获取用户名
    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }

    // 是否已过期
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

}

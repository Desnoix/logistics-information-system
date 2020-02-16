package com.yjq.security.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName JWTAuthenticationEntryPoint
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/2/16 0:58
 * @Version 1.0
 */
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        String reason = "统一处理，原因：" + e.getMessage();
        response.getWriter().write(new ObjectMapper().writeValueAsString(reason));

    }
}

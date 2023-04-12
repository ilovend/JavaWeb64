package com.itheima.day06.filter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.itheima.day06.common.Result;
import com.itheima.day06.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录检查过滤器
 *
 * @author ilovend
 * @date 2023/04/09
 */
@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    /**
     * 过滤器方法
     *
     * @param request  请求
     * @param response 响应
     * @param chain    链
     * @throws ServletException servlet异常
     * @throws IOException      ioexception
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
//        1. 获取请求url
        String uri = req.getRequestURI();
//        2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if (uri.contains("login")) {
            chain.doFilter(req, resp);
            return;
        }
//        3. 获取请求头中的令牌（token）
        String token = req.getHeader("token");
        log.info("请求的令牌是:{}", token);
//        4. 判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if (!StringUtils.hasLength(token)) {
            log.info("token不存在");
            Result responseResult = Result.error("NOT_LOGIN");
            String toJSONString = JSON.toJSONString(responseResult);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(toJSONString);
            return;
        }
//        5. 解析token，如果解析失败，返回错误结果（未登录）
        try {
            Claims claims = JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("令牌解析失败");

            Result responseResult = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(responseResult);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
            return;
        }
//        6. 放行
        chain.doFilter(req, resp);


    }
}

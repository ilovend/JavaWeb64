package com.itheima.day07.common;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.itheima.day07.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录拦截器
 *
 * try{
 *     preHandle
 *     Controller
 *     postHandle
 * }catch{
 *
 * }finally{
 *     afterCompletion
 * }
 *
 * @author ilovend
 * @date 2023/04/10
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * Controller执行之前<br/>
     *
     * @param req  请求
     * @param resp 响应
     * @param handler  处理程序
     * @return boolean
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //        1. 获取请求url
        String uri = req.getRequestURI();
//        2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行
//        if (uri.contains("login")) {
//            return true;
//        }
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
            return false;
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
            return false;
        }

        return true;

    }

    /**
     * Controller执行之后
     *
     * @param request      请求
     * @param response     响应
     * @param handler      处理程序
     * @param modelAndView 模型和视图
     * @throws Exception 异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * postHandle完成后
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @param ex       前女友
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

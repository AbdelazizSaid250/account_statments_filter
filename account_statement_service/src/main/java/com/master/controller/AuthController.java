package com.master.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {
    @GetMapping("logout")
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) {
        log.info("11111111111111111");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            log.info("2222222222222");
            new SecurityContextLogoutHandler().logout(request, response, auth);
            log.info("3333333333333");
        }
    }

}

package com.lc.vuedemospringboot.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {

        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error404.html");
        ErrorPage errorPag500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500.html");

        registry.addErrorPages(errorPage404,errorPag500);

    }
}

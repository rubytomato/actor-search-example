package com.example.actor.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
  final static Logger logger = LoggerFactory.getLogger(ErrorController.class);

  @Bean
  public EmbeddedServletContainerCustomizer containerCustomizer() {
    return new EmbeddedServletContainerCustomizer() {
      @Override
      public void customize(ConfigurableEmbeddedServletContainer container) {
        ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        container.addErrorPages(error404, error500);
      }
    };
  }

  @RequestMapping("/error/404")
  public String error404() {
    return "Error/404";
  }

  @RequestMapping("/error/500")
  public String error500() {
    return "Error/500";
  }

}

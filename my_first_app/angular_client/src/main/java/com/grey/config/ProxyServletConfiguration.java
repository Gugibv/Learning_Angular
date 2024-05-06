package com.grey.config;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ProxyServletConfiguration {

  @Bean
  public ServletRegistrationBean<?> servletRegistrationBean() {
    String urlMapping = "/mobile/*";
    String targetUri = "http://127.0.0.1:8080/angular_server/mobile/";
    ServletRegistrationBean<?> servletRegistrationBean = new ServletRegistrationBean<>(new ProxyServlet(),
      urlMapping);
    servletRegistrationBean.addInitParameter("targetUri", targetUri);
    servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, "true");
    servletRegistrationBean.addInitParameter(ProxyServlet.P_HANDLEREDIRECTS, "true");
    return servletRegistrationBean;
  }

}

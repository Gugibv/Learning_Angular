package com.grey.config;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SolrProxyServletConfiguration {

  @Bean
  public ServletRegistrationBean<?> servletRegistrationBean() {
    String urlMapping = "/baidu/*";
    String targetUri = "http://www.baidu.com";
    ServletRegistrationBean<?> servletRegistrationBean = new ServletRegistrationBean<>(new ProxyServlet(),
      urlMapping);
    servletRegistrationBean.addInitParameter("targetUri", targetUri);
    servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, "true");
    servletRegistrationBean.addInitParameter(ProxyServlet.P_HANDLEREDIRECTS, "true");
    return servletRegistrationBean;
  }

}

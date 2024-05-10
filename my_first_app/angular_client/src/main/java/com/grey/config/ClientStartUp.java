package com.grey.config;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.mitre.dsmiley.httpproxy.ProxyServlet;

import java.util.Set;

public class ClientStartUp  implements ServletContainerInitializer {
  @Override
  public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
    ctx.addServlet("reverseProxy", ProxyServlet.class).setLoadOnStartup(1);
    ServletRegistration reverseProxy = ctx.getServletRegistration("reverseProxy");
    String getenv = System.getenv("gcc_apim");

    getenv = "http://127.0.0.1:8080/angular_server/mobile/";

    reverseProxy.setInitParameter("targetUri", getenv);
    reverseProxy.setInitParameter(ProxyServlet.P_LOG, "true");
    reverseProxy.setInitParameter(ProxyServlet.P_PRESERVECOOKIES, "true");
    reverseProxy.setInitParameter(ProxyServlet.P_PRESERVECOOKIEPATH, "true");

    reverseProxy.addMapping("/mobile/*");

    System.out.println("ProxyServlet initialization completed");

  }
}

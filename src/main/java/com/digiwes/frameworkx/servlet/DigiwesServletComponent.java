package com.digiwes.frameworkx.servlet;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.http.HttpService;

/**
 * Created by huangxm on 3/9/2016.
 */

/**
 * @scr.component name="digiwes.servlet.dscomponent" immediate="true"
 * @scr.reference name="http.service" interface="org.osgi.service.http.HttpService"
 * cardinality="1..1" policy="dynamic"  bind="setHttpService" unbind="unsetHttpService"
 */
public class DigiwesServletComponent {

    private static HttpService httpServiceInstance;

    protected void activate(ComponentContext ctxt) {
        final HttpService httpService = getHttpService();
        DigiwesServlet digiwesServlet = new DigiwesServlet();
        try {
            httpService.registerServlet("/digiwesServlet", digiwesServlet, null, null);
        } catch (Throwable e) {
            System.out.println("Failed to activate DigiwesServletComponent");
        }

        System.out.println("DigiwesServletComponent is activated ");
    }

    protected void deactivate(ComponentContext ctxt) {
        System.out.println("DigiwesServletComponent is deactivated ");
    }

    protected void setHttpService(HttpService httpService) {
        httpServiceInstance = httpService;
    }

    protected void unsetHttpService(HttpService httpService) {
        httpServiceInstance = null;
    }

    public static HttpService getHttpService() {
        if (httpServiceInstance == null) {
            String msg = "Before activating Digiwes Servlet bundle, an instance of "
                    + HttpService.class.getName() + " should be in existence";
            throw new RuntimeException(msg);
        }
        return httpServiceInstance;
    }
}

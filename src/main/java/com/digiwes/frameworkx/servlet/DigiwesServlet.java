package com.digiwes.frameworkx.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.io.IOException;

/**
 * Created by huangxm on 3/9/2016.
 */
public class DigiwesServlet extends HttpServlet {
    /**
     * Web Post Method
     */
    public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    /**
     * Web GET Method
     */
    public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ServletOutputStream output = response.getOutputStream();

        try {
            output.println("This is just a servlet test message!");
            output.close();
            return;
        } catch (Exception e) {
            output.println("Error occurs");
            output.println(e.toString());
            output.close();
            return;
        }
    }

}

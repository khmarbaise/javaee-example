package com.soebes.examples.j2ee.gui.web;

import com.soebes.examples.j2ee.domain.Name;
import com.soebes.examples.j2ee.sevice.api.Greeter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "GreeterController", urlPatterns = {"/greet"})
public class GreeterServlet extends HttpServlet {

    private static final long serialVersionUID = 42L;

    @EJB
    private Greeter greeter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameParameter = req.getParameter("name");
        if (nameParameter == null) {
            nameParameter = "world";
        }
        final String greeting = greeter.greet(new Name(nameParameter));
        resp.getOutputStream().print(greeting);
    }

}

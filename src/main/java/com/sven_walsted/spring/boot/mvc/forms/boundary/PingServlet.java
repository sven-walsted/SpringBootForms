package com.sven_walsted.spring.boot.mvc.forms.boundary;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PingServlet", urlPatterns = { "/pingServlet" })
public class PingServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    final PrintWriter writer = response.getWriter();
    writer.write("Ping!");
  }

}

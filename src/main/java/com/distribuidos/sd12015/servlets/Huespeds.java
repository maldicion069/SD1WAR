/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidos.sd12015.servlets;

import com.distribuidos.sd12015.models.Huesped;
import static com.distribuidos.sd12015.servlets.GenericHttpServlet.miStream;
import static com.distribuidos.sd12015.servlets.GenericHttpServlet.sr;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian
 */
public class Huespeds extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String huespedsStr = sr.getHuespeds();
        if (request.getSession().getAttribute("ok") != null) {
            request.setAttribute("ok", request.getSession().getAttribute("ok"));
            request.getSession().removeAttribute("ok");
        }
        if (request.getSession().getAttribute("msg") != null) {
            request.setAttribute("msg", request.getSession().getAttribute("msg"));
            request.getSession().removeAttribute("msg");
        }
        List<Huesped> huespeds = (List<Huesped>) miStream.fromXML(huespedsStr);
        request.setAttribute("huespeds", huespeds);
        request.getRequestDispatcher("WEB-INF/views/huespeds/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

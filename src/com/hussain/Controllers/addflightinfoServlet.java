package com.hussain.Controllers;

import com.hussain.Business_Layer.addflightService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "addflightinfoServlet",urlPatterns = {"/addflightinfoServlet"})
public class addflightinfoServlet extends HttpServlet {
    addflightService serve=new addflightService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Class=request.getParameter("class");
        String flight_id=request.getParameter("flightid");
        String detail_id=request.getParameter("detailID");


        String price=request.getParameter("price");
        String features=request.getParameter("field_name[]");
        String seats=request.getParameter("seats");

        out.println("FLight_InFO_1:"+Class);
        out.println("FLight_InFO_2:"+flight_id);

        if(Integer.valueOf(detail_id)==0) {
            if (serve.addflightinfo(flight_id, Class, price, features, seats)) {
                out.println("FLight_InFO_Added");
            }
        }
        else
        {
            if (serve.updateflightinfo(detail_id, price, features, seats)) {
                out.println("FLight_InFO_Updated");
            }
        }
        RequestDispatcher rt=request.getRequestDispatcher("ShowflighttoAdminServlet");
        rt.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

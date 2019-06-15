package com.pal.detroitmapper.apartmentsapi;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class ApartmentsServlet extends HttpServlet {

    private static final long serialVersionUID = -5832176047021911038L;

    public static int PAGE_SIZE = 5;

    private ApartmentsClient apartmentsClient;

    public ApartmentsServlet(ApartmentsClient apartmentsClient) {
        this.apartmentsClient = apartmentsClient;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("Add".equals(action)) {

            String name = request.getParameter("name");
            String street_address = request.getParameter("street_address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String pincode = request.getParameter("pincode");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            long price = Long.parseLong(request.getParameter("price"));
            String[] bedrooms = request.getParameterValues("bedrooms");
            boolean bhk_1 = false, bhk_2 = false, bhk_3 = false;
            for (String room : bedrooms) {
                if (room.equalsIgnoreCase("bhk_1")) {
                    bhk_1 = true;
                } else if (room.equalsIgnoreCase("bhk_2")) {
                    bhk_2 = true;
                } else {
                    bhk_3 = true;
                }
            }
            ApartmentInfo restaurantInfo = new ApartmentInfo(name, street_address, price, city, state, pincode, phone, email, bhk_1, bhk_2, bhk_3);
            apartmentsClient.addApartment(restaurantInfo);

            response.sendRedirect("apartments");
            return;

        } else if ("Remove".equals(action)) {

            String[] ids = request.getParameterValues("id");
            for (String id : ids) {
                apartmentsClient.deleteApartmentId(new Long(id));
            }

            response.sendRedirect("apartments");
            return;

        } else {
            String key = request.getParameter("key");
            String field = request.getParameter("field");

            int count = 0;

            if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)) {
                count = apartmentsClient.countAll();
                key = "";
                field = "";
            } else {
                count = apartmentsClient.count(field, key);
            }

            int page = 1;

            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
            }

            int pageCount = (count / PAGE_SIZE);
            if (pageCount == 0 || count % PAGE_SIZE != 0) {
                pageCount++;
            }

            if (page < 1) {
                page = 1;
            }

            if (page > pageCount) {
                page = pageCount;
            }

            int start = (page - 1) * PAGE_SIZE;
            List<ApartmentInfo> range;

            if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)) {
                range = apartmentsClient.findAll(start, PAGE_SIZE);
            } else {
                range = apartmentsClient.findRange(field, key, start, PAGE_SIZE);
            }

            int end = start + range.size();

            request.setAttribute("count", count);
            request.setAttribute("start", start + 1);
            request.setAttribute("end", end);
            request.setAttribute("page", page);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("apartments", range);
            request.setAttribute("key", key);
            request.setAttribute("field", field);
        }

        request.getRequestDispatcher("WEB-INF/apartments.jsp").forward(request, response);
    }
}

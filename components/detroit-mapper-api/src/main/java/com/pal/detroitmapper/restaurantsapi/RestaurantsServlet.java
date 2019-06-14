package com.pal.detroitmapper.restaurantsapi;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class RestaurantsServlet extends HttpServlet {

    private static final long serialVersionUID = -5832176047021911038L;

    public static int PAGE_SIZE = 5;

    private RestaurantsClient restaurantsClient;

    public RestaurantsServlet(RestaurantsClient restaurantsClient) {
        this.restaurantsClient = restaurantsClient;
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
            String cuisine = request.getParameter("cuisine");
            String price_range = request.getParameter("price_range");

            RestaurantInfo restaurantInfo = new RestaurantInfo(name, street_address, city, state, pincode, phone, email, cuisine, price_range);

            restaurantsClient.addRestaurant(restaurantInfo);

            response.sendRedirect("restaurants");
            return;

        } else if ("Remove".equals(action)) {

            String[] ids = request.getParameterValues("id");
            for (String id : ids) {
                restaurantsClient.deleteRestaurantId(new Long(id));
            }

            response.sendRedirect("restaurants");
            return;

        } else {
            String key = request.getParameter("key");
            String field = request.getParameter("field");

            int count = 0;

            if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)) {
                count = restaurantsClient.countAll();
                key = "";
                field = "";
            } else {
                count = restaurantsClient.count(field, key);
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
            List<RestaurantInfo> range;

            if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)) {
                range = restaurantsClient.findAll(start, PAGE_SIZE);
            } else {
                range = restaurantsClient.findRange(field, key, start, PAGE_SIZE);
            }

            int end = start + range.size();

            request.setAttribute("count", count);
            request.setAttribute("start", start + 1);
            request.setAttribute("end", end);
            request.setAttribute("page", page);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("restaurants", range);
            request.setAttribute("key", key);
            request.setAttribute("field", field);
        }

        request.getRequestDispatcher("WEB-INF/restaurants.jsp").forward(request, response);
    }

}


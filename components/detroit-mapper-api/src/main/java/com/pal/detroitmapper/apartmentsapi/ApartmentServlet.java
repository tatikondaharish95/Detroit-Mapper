
/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pal.detroitmapper.apartmentsapi;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @version $Revision$ $Date$
 */
@Component
public class ApartmentServlet extends HttpServlet {

    private static final long serialVersionUID = -5832176047021911038L;

    public static int PAGE_SIZE = 5;

    private ApartmentClient apartmentsClient;

    public ApartmentServlet(ApartmentClient moviesClient) {
        this.apartmentsClient = moviesClient;
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
            float price = Integer.parseInt(request.getParameter("price"));
            String streetAddress = request.getParameter("streetAddress");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            int pincode = Integer.parseInt(request.getParameter("pincode"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            boolean oneBhk = Boolean.parseBoolean(request.getParameter("oneBhk"));
            boolean twoBhk = Boolean.parseBoolean(request.getParameter("twoBhk"));
            boolean threeBhk = Boolean.parseBoolean(request.getParameter("threeBhk"));
            boolean fourBhk = Boolean.parseBoolean(request.getParameter("fourBhk"));

            ApartmentInfo movie = new ApartmentInfo(name, price, streetAddress, city, state,
                    pincode, phone, email, oneBhk, twoBhk, threeBhk, fourBhk);

            apartmentsClient.addApartment(movie);
            response.sendRedirect("detroitmapper");
            return;

        } else if ("Remove".equals(action)) {

            String[] ids = request.getParameterValues("id");
            for (String id : ids) {
                apartmentsClient.deleteApartmentId(new Long(id));
            }

            response.sendRedirect("detroitmapper");
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
            request.setAttribute("movies", range);
            request.setAttribute("key", key);
            request.setAttribute("field", field);
        }
        //we don't need this unless we actually make a real GUI with a WEB-INF folder
        //request.getRequestDispatcher("WEB-INF/moviefun.jsp").forward(request, response);
    }

}

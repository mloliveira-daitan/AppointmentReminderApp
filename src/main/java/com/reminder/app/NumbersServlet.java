package com.reminder.app;

import com.bandwidth.sdk.BandwidthClient;
import com.bandwidth.sdk.model.PhoneNumber;
import com.bandwidth.sdk.model.ResourceList;
import com.reminder.bean.NumbersBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumbersServlet extends HttpServlet {

    private static String userId = System.getenv("BANDWIDTH_USER_ID");
    private static String apiToken = System.getenv("BANDWIDTH_API_TOKEN");
    private static String apiSecret = System.getenv("BANDWIDTH_API_SECRET");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NumbersBean numbersBean = new NumbersBean();
        List<String> numberList = new ArrayList();
        numbersBean.setNumbers(numberList);

        BandwidthClient.getInstance().setCredentials(userId, apiToken, apiSecret);

        try {
            ResourceList<PhoneNumber> userNumbers = PhoneNumber.list();

            for (PhoneNumber number : userNumbers){
                numberList.add(number.getNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.setAttribute("numbersBean", numbersBean);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/start.jsp");
        rd.forward(request, response);
    }
}

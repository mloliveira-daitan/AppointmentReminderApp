package com.reminder.app;

import com.bandwidth.sdk.model.Call;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CallServlet extends HttpServlet{

    private static String toNumber;
    private static String fromNumber;
    private static String callbackUrl =  "https://" + System.getenv("HEROKU_APP_NAME") + ".herokuapp.com/callback";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            String body = getBody(req);
            String parsedBody = body.replaceAll("%2B", "+");

            String delims = "[=&]+";
            String[] tokens = parsedBody.split(delims);

            for (int i = 0; i < tokens.length; i++){
                if (tokens[i].equals("toNumber")){
                    toNumber = tokens[i+1];
                }
                else if (tokens[i].equals("fromNumber")){
                    fromNumber = tokens[i+1];
                }
            }

            Call call = Call.create(toNumber, fromNumber, callbackUrl, "");
            HttpSession session = req.getSession();
            session.setAttribute("callid", call.getId());

            resp.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();

        }
    }

    protected String getBody(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream in = req.getInputStream();

            InputStreamReader is = new InputStreamReader(in);

            BufferedReader br = new BufferedReader(is);
            String read = br.readLine();

            while (read != null) {
                sb.append(read);
                read = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void destroy()
    {
        // do nothing.
    }

}

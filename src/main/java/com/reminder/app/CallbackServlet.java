package com.reminder.app;

import com.bandwidth.sdk.model.Call;
import com.bandwidth.sdk.model.events.Event;
import com.bandwidth.sdk.model.events.EventBase;
import com.bandwidth.sdk.model.events.EventType;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class CallbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String body = getBody(req);
            Event event = (Event) EventBase.createEventFromString(body);

            String callId = event.getProperty("callId");
            Call call = Call.get(callId);
            System.out.println(body);

            if (EventType.ANSWER.equals(event.getEventType())) {

                sendGather(call);

            } else if (EventType.GATHER.equals(event.getEventType())) {

                String inputDigit = event.getProperty("digits");

                    if (inputDigit.equals("1")) {

                        call.hangUp();

                    } else if (inputDigit.equals("2")) {

                        call.stopSentence();
                        call.speakSentence("Your appointment location is around the corner, at 3 PM");

                    } else {
                        call.stopSentence();
                        sendGather(call);
                    }


            } else if (EventType.SPEAK.equals(event.getEventType())) {

                if (event.getProperty("state").equals("PLAYBACK_STOP")) {
                    call.hangUp();
                }
            }

            resp.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();

        }
    }

    public void destroy() {
        // do nothing.
    }

    protected String getBody(HttpServletRequest req) {

        StringBuilder sb = new StringBuilder();
        try {
            InputStream in = req.getInputStream();

            InputStreamReader is = new InputStreamReader(in);

            BufferedReader br = new BufferedReader(is);
            String read = br.readLine();

            while (read != null) {
                // System.out.println(read);
                sb.append(read);
                read = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void sendGather(Call call) {
        Map<String, Object> gatherParams = new HashMap<String, Object>();
        gatherParams.put("maxDigits", "1");

        Map<String, Object> promptParams = new HashMap<String, Object>();
        String reminderSentence = "Hello! This is the appointment reminder app from Bandwidth." +
                " Your appointment is scheduled to Wednesday at 3 PM. ." + "Please press 1 to end this call. " +
                "Press 2 to receive directions, or press 3 to repeat this menu.";
        promptParams.put("sentence", reminderSentence);
        promptParams.put("voice", "kate");
        promptParams.put("gender", "female");
        promptParams.put("locale", "en_US");

        try {
            call.createGather(gatherParams, promptParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
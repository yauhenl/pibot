package com.yauhenl.pibot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.net.www.protocol.http.HttpURLConnection;

import java.net.URL;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class IndexController {
    private static final String host = "http://192.168.1.7:8080";

    @RequestMapping(value = "/")
    public String view() {
        return "index";
    }

    @RequestMapping(value = "/switch/{state}", method = GET)
    public void state(@PathVariable String state) {
        request(host + "/switch/" + state);
    }

    @RequestMapping(value = "/move/{direction}", method = GET)
    public void move(@PathVariable String direction) {
        request(host + "/move/" + direction);
    }

    private void request(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.getResponseCode();
            con.disconnect();
        } catch (Exception ignore) {
        }
    }
}

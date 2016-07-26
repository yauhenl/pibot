package com.yauhenl.pibot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class IndexController {
    @Value("${botHost}")
    private String host;

    @RequestMapping(value = "/")
    public String view() {
        return "index";
    }

    @RequestMapping(value = "/switch/{state}", method = GET)
    @ResponseStatus(HttpStatus.OK)
    public void state(@PathVariable String state) {
        request(host + "/switch/" + state);
    }

    @ResponseStatus(HttpStatus.OK)
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

package com.yauhenl.pibot;

import com.sun.net.httpserver.HttpServer;
import com.yauhenl.pibot.web.BotController;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Application {
    public static void main(String[] args) throws IOException {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig(BotController.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
    }
}


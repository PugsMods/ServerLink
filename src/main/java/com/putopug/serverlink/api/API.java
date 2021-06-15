package com.putopug.serverlink.api;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class API {
    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(9090),0);
        server.createContext("/ServerLinkAPI", new APIHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Started!");
    }
}

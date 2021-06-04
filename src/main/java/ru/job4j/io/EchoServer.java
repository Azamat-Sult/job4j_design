package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String request = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        String[] lineSplit = str.split(" ");
                        if (lineSplit[1].startsWith("/?msg")) {
                            String[] requestSplit = lineSplit[1].split("=");
                            request = requestSplit[1];
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    if (request.equals("Bye")) {
                        out.write("SERVER is SHUTDOWN\r\n".getBytes());
                        server.close();
                    }
                    System.out.println("-----------------------------------------");
                }
            }
            System.out.println("SERVER is SHUTDOWN");
        }
    }
}